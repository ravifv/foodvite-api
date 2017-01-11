package com.fv.db;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fv.api.dto.CategoryDetail;
import com.fv.api.dto.MenuDetail;
import com.fv.api.dto.ProductDetail;
import com.fv.api.dto.ProductDetailContainer;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.service.impl.helper.RestaurantServiceHelper;
import com.fv.common.util.FVUtilities;
import com.fv.common.util.IDGenerator;
import com.fv.repository.domain.MenuCategoryDetailEO;
import com.fv.repository.domain.ProductDetailEO;
import com.fv.repository.domain.RestaurantDetailEO;
import com.fv.repository.service.MenuCategoryDetailRepository;
import com.fv.repository.service.ProductDetailRepository;
import com.fv.repository.service.RestaurantDetailRepository;
import com.fv.repository.service.RestaurantPhotoRepository;


public  class RestaurantDetailHelper {
	@Autowired RestaurantPhotoRepository restaurantPhotoRepository;
	@Autowired ProductDetailRepository productDetailRepository;
	@Autowired RestaurantDetailRepository restaurantDetailRepository;
	@Autowired  MenuCategoryDetailRepository menuCategoryDetailRepository;
	
	 public MenuDetail getMenu(BigDecimal restId,BigDecimal categoryId,int page)  {
		 boolean isImageMenu=false;
	     MenuDetail menuDTO = new MenuDetail();
	      	RestaurantDetailEO seller = restaurantDetailRepository.getSeller(restId);
	        menuDTO.setRestaurantName(seller.getRestName());

	        List<BigDecimal> categoryList = restaurantDetailRepository.getCategoryList(restId);
	        List<CategoryDetail> categoryDTOList = new ArrayList<CategoryDetail>();
	        try {
	        if(categoryId.intValue() == 0) {
	            for (BigDecimal integer : categoryList) {
	            	CategoryDetail categoryDTO;
					
						categoryDTO = getPagedCategoryData(integer, 1,seller.isOnFV());
					
	                categoryDTOList.add(categoryDTO);
	            }
	        }else{
	        	CategoryDetail categoryDTO = getPagedCategoryData(categoryId, page+1,seller.isOnFV());
	            
	            categoryDTOList.add(categoryDTO);
	        }
	        menuDTO.setCategoryDetailList(categoryDTOList);
	        menuDTO.setImageMenu(isImageMenu);
	        menuDTO.setPhotographDetailList(new RestaurantPhotoHelper().getPhoto(restId));
	        menuDTO.setResultCode("101");
	        menuDTO.setIsSuccess(true);
	        menuDTO.setMsg("Success");
	        
	        } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return menuDTO;
	    }
	
	public  void saveRestaurant(RestaurantDetail restaurantPO){
		RestaurantDetailEO entity = new RestaurantDetailEO();
		entity.setRestId(new BigDecimal(restaurantPO.getRestaurantId()));
		entity.setRestName(restaurantPO.getRestaurantName());
		entity.setMinimumValue(new BigDecimal(4));
		entity.setOnFV(0);
		entity.setGstApplicable(0);
		entity.setIsSponsored(0);
		entity.setPlaceId(restaurantPO.getPlaceId());
		entity.setCreatedTimestamp(FVUtilities.getTimestamp(new Timestamp(new Date().getTime()), "MM/dd/yyyy HH:mm:ss"));
		entity.setIsTableReserve(0);
		entity.setReserveURL("-");
		entity.setLocation(restaurantPO.getLocationDetail().getLatitude()+","+restaurantPO.getLocationDetail().getLongitude());
		entity.setLatitude(restaurantPO.getLocationDetail().getLatitude());
		entity.setLongitude(restaurantPO.getLocationDetail().getLongitude());
		entity.setAddress(restaurantPO.getLocationDetail().getAddress());
		entity.setPincode(restaurantPO.getLocationDetail().getPincode());
		entity.setRestaurantCategoryList(new RestaurantServiceHelper().getFormattedCategory(restaurantPO.getCategories()));
		if(!FVUtilities.isNullOrEmpty(restaurantPO.getRestaurantFeedbackDetail()))
		entity.setRatings(restaurantPO.getRestaurantFeedbackDetail().getRatings());
		try{
		entity.setVisits(!FVUtilities.isNullOrEmpty(restaurantPO.getRestaurantFeedbackDetail().getNoOfVisits())?restaurantPO.getRestaurantFeedbackDetail().getNoOfVisits():0);
		}catch(NullPointerException ne){
			ne.printStackTrace();
		}
		//if(restaurantPO.getLocation().getLongitude().contains("103.")){
			System.out.println("*****saving entity *******");
			restaurantDetailRepository.saveSeller(entity);
			restaurantPhotoRepository.saveFSEntity(restaurantPO.getPhotographs(), entity.getRestId());
		//}
		}
	
	
	 //data of which page is required.
    public CategoryDetail getPagedCategoryData(BigDecimal categoryId, int currentPage,int onFV) throws JSONException {
    	int paginationSize = 5;
        int minItemIndex = (paginationSize * (currentPage-1))+1;
        int maxItemIndex = paginationSize * currentPage;
        //if page 1 then i need 1-5 and minItemIndex=1,maxItemIndex = 5
        //if page 2 then i need 6-10 and minItemIndex=6,maxItemIndex = 10

        MenuCategoryDetailEO categoryItem = menuCategoryDetailRepository.getCategoryProductsItems(categoryId);
        CategoryDetail categoryDTO = new CategoryDetail();
        categoryDTO.setCategoryId(categoryId);
        categoryDTO.setCategoryName(categoryItem.getCategoryName());

        ProductDetailContainer productDTOWrapper = new ProductDetailContainer();
        List<BigDecimal> productIdList = categoryItem.getProductId();

        int itemIndex=0;
        //extract category products.
        List<ProductDetail> productDTOList = new ArrayList<ProductDetail>();
        for (BigDecimal productId : productIdList) {
        
        	  ProductDetailEO productDetail = productDetailRepository.getProductDetail(productId);

            if (productDetail != null) {
            	 if (productDetail.getIsExclude() == 0) {
                itemIndex++;
                if(itemIndex<minItemIndex) continue;
                ProductDetail productDTO = new ProductDetail(productDetail.getProductId(),
                        productDetail.getName(),
                        productDetail.getPicUrl(),
                        productDetail.getDescription(),
                      new Double (productDetail.getPrice()));
                
                if(onFV == 0)
                	productDTO.setImageUrl("http://uat.foodvite.co/FV/default/item/Default_Item.jpg");
                
                productDTOList.add(productDTO);
               // commented for full menu list
               // if (productDTOList.size() == paginationSize) break;
            	 }
            }
        }

        //extract subcategory products only if product List is small than pagination.
        /*for (int i = 0; i < 10; i++) {
            String json = categoryItem.getJSON("subcategory" + String.valueOf(i + 1));
            if (json == null || json.isEmpty()) break;
            else {
                JSONObject object = new JSONObject(json);
                JSONArray productIds = object.getJSONArray("productIds");
                for (int j = 0; j < productIds.length(); j++) {
                	System.out.println(new BigDecimal(productIds.getString(j)));
                    ProductDetailEO productDetail = productDetailRepository.getProductDetail(new BigDecimal(productIds.getString(j)));
                   
                    if (productDetail != null) {
                    	
                        itemIndex++;
                        if(itemIndex<minItemIndex) continue;
                        ProductDetail productDTO = new ProductDetail(productDetail.getProductId(),
                                productDetail.getName(),
                                productDetail.getPicUrl(),
                                productDetail.getDescription(),
                              new Double (productDetail.getPrice())
                        );
                        if(onFV == 0)
                        	productDTO.setImageUrl("http://uat.foodvite.co/FV/default/item/Default_Item.jpg");
                        productDTOList.add(productDTO);
                        if (productDTOList.size() == paginationSize) break;
                    }
                }
            }
        }*/
        productDTOWrapper.setProductDetailList(productDTOList);
        categoryDTO.setProductDetailContainer(productDTOWrapper);
        return categoryDTO;
    }
    
    public List<RestaurantDetail> addRestToDB(List<RestaurantDetail> restPOList){
		System.out.println("RestaurantSearchService.addRestToDB()");
		int k=0;
		List<RestaurantDetail> restaurantPOList = new ArrayList<RestaurantDetail>();
		for (RestaurantDetail restaurantPO : restPOList) {
				RestaurantDetailEO restaurantDetailsPOImpl = RestaurantDetailRepository.getRestLatAndLong(
				restaurantPO.getLocationDetail().getLatitude(), restaurantPO.getLocationDetail().getLongitude());
					if(FVUtilities.isNullOrEmpty(restaurantDetailsPOImpl) || FVUtilities.isNullOrEmpty(restaurantDetailsPOImpl.getRestId() )
							){
						
						restaurantPO.setRestaurantId(String.valueOf(IDGenerator.getLongId()));
						new RestaurantDetailHelper().saveRestaurant(restaurantPO);
					}else{
					restaurantPO.setRestaurantId(restaurantDetailsPOImpl.getRestId().toString());
					RestaurantDetailRepository.updateRestaurantDetails(restaurantPO);
				}
				//}
				
				restaurantPOList.add(k++, restaurantPO);
			}
		//stubbing for testing
		//restaurantPOList.add(k++,restDetails.imGetTestingRestaurant(new BigDecimal(12345)));
			return restaurantPOList;
	}

}
