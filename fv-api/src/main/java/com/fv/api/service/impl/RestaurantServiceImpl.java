package com.fv.api.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.fv.api.dto.LocationDetail;
import com.fv.api.dto.MenuDetail;
import com.fv.api.dto.MenuDetailRequest;
import com.fv.api.dto.PhotographDetail;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.dto.RestaurantDetailContainer;
import com.fv.api.dto.RestaurantDetailRequest;
import com.fv.api.dto.RestaurantFeedbackDetail;
import com.fv.api.service.RestaurantService;
import com.fv.api.service.impl.helper.FSRestaurantServiceHelper;
import com.fv.api.service.impl.helper.RestaurantServiceHelper;
import com.fv.common.util.Either;
import com.fv.common.util.FVUtilities;
import com.fv.common.util.IDGenerator;
import com.fv.db.RestaurantDetailHelper;
import com.fv.repository.domain.CustomerRegistrationEO;
import com.fv.repository.domain.RestaurantDetailEO;
import com.fv.repository.service.CustomerRegistrationRepository;
import com.fv.repository.service.impl.CustomerRegistrationRepositoryImpl;


@PropertySource({"classpath:message.properties"})
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired CustomerRegistrationRepository userRegistration ;
	@Autowired Environment message;
	@Autowired RestaurantServiceHelper restaurantServiceHelper;
	@Autowired FSRestaurantServiceHelper fsRestaurantServiceHelper;
	@Autowired RestaurantDetailHelper restaurantDetailHelper;
	
	public static final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);
	@Override
	public Either<MenuDetail> getRestaurantMenuDetail(MenuDetailRequest menuDetailRequest) {
		Either returnEntity = null;
		MenuDetail menu = new MenuDetail();
		try {
			CustomerRegistrationEO userRegPO = new CustomerRegistrationRepositoryImpl().imRetrieveRegistrationDetails(menuDetailRequest.getApiKey());
			if(!userRegPO.isExpired()){
				menu = new RestaurantDetailHelper().getMenu(new BigDecimal(menuDetailRequest.getRestaurantId()),new BigDecimal(0),0);
				returnEntity.buildEntity(menu);
			}else{
				//Either.buildErrors(errors)
				//returnString = FVUtilities.errorResponse("0",  MessageReader.getMessage("0"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		return returnEntity;
	}

	@Override
	public Either<RestaurantDetail> retrieveRestaurantDetails(RestaurantDetailRequest restaurantDetailRequest) {
		Either returnEntity = null;
		RestaurantDetailContainer restaurantDetailContainer = new RestaurantDetailContainer();
		
		String returnString = null;
		boolean isfeedback = false;
		List<RestaurantDetail> restaurantPOList = new ArrayList<RestaurantDetail>();
		java.util.Date date = new java.util.Date();
		try {
//		String validationString = imValidationForGetDetails(reqJson);
//		if (true) {
		CustomerRegistrationEO userRegPO = userRegistration.imRetrieveRegistrationDetails(restaurantDetailRequest.getApiKey());
		
			if (!FVUtilities.isNullOrEmpty(userRegPO)) {
			
				if (!userRegPO.isExpired()) {
					if(restaurantDetailRequest.getLongitude().contains("103.")){
						restaurantPOList = imGetRestaurantsFromCloud(restaurantDetailRequest.getSearchText(), restaurantDetailRequest.getLatitude(), restaurantDetailRequest.getLongitude(), restaurantDetailRequest.getBottomCount(),restaurantDetailRequest.getDistance());
						System.out.println("restaurantPOList size in service"+restaurantPOList.size());
					}else{
						if(!FVUtilities.isNullOrEmpty((restaurantDetailRequest.getSearchText())) ){
				
				
							restaurantPOList = fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(restaurantDetailRequest.getLatitude(), restaurantDetailRequest.getLongitude(),
									restaurantDetailRequest.getSearchText());
				
				
						}else{
				
							restaurantPOList = fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(restaurantDetailRequest.getLatitude(), restaurantDetailRequest.getLongitude(),
									Integer.parseInt(restaurantDetailRequest.getBottomCount()));
				
							if(restaurantPOList.size() == 0)
				
								restaurantDetailContainer.setHasMoreProducts(false);
				
							else 
				
								restaurantDetailContainer.setHasMoreProducts(true);
				
						}
						
						restaurantPOList = restaurantDetailHelper.addRestToDB(restaurantPOList);
				
				}
				
				
				// build pagination
				
					logger.debug("restaurantPOList size in service"+restaurantPOList.size());
				restaurantDetailContainer.setRestaurantDetailList(restaurantPOList);
				RestaurantFeedbackDetail feedbackPO = new RestaurantFeedbackDetail();
				/*CustomerDetailsPOImpl customerDetailsPOImpl = customerDetailsImpl
				.getCustomerDetails(userRegPO.getCustomerId());
				Set<BigDecimal> orderList = customerDetailsPOImpl.getOrderList();
				BroadcastsPOImpl broadcastsPOImpl = new BroadcastsPOImpl();
			
					if (isfeedback) {
						RestaurantDetailsPOImpl restaurantDetailsPOImpl = restaurantDetailsImpl
						.getRestaurant(broadcastsPOImpl.getSelectedRestraId());
						
						feedbackPO.setPhotos(
						restaurantPhotosImpl.getPhotos(broadcastsPOImpl.getSelectedRestraId()));
						feedbackPO.setRestId(broadcastsPOImpl.getSelectedRestraId().toString());
						feedbackPO.setRestName(restaurantDetailsPOImpl.getRestName());
					}
					if (!FVUtilities.isNullOrEmpty(orderList)) {
						Iterator iter = orderList.iterator();
						BigDecimal latestOrder = (BigDecimal) iter.next();
						OrdersPOImpl ordersPOImpl = ordersImpl.getOrder(latestOrder);
						System.out.println("latestOrder"+latestOrder);
						if (ordersPOImpl.getStatus().equals("3")
							&& ordersPOImpl.getIsFeedback().equalsIgnoreCase("N")) {
							RestaurantDetailsPOImpl restaurantDetailsPOImpl = restaurantDetailsImpl
							.getRestaurant(ordersPOImpl.getRestId());
							feedbackPO.setOrderId(latestOrder.toString());
							feedbackPO.setPhotos(restaurantPhotosImpl.getPhotos(ordersPOImpl.getRestId()));
							feedbackPO.setRestId(ordersPOImpl.getRestId().toString());
							feedbackPO.setRestName(restaurantDetailsPOImpl.getRestName());
							}
					}*/
					//restaurantDetail.setFeedback(feedbackPO);
					restaurantDetailContainer.setResultCode("101");
					restaurantDetailContainer.setIsSuccess(true);
					restaurantDetailContainer.setMsg("success");
					//returnString = gson.toJson(restaurantDetail);
					returnEntity.buildEntity(restaurantDetailContainer);
				} else
				//returnString = FVUtilities.errorResponse("0", "Invalid session");
					returnEntity.buildErrors(errors)
			} else {
				//returnString = validationString;
			}
		
		//}
		} 
		 
		catch (Exception e) {
			e.printStackTrace();
			logger.info("Caught Exception");
		//	return FVUtilities.errorResponse("100",message.getProperty("100"));
		}
		//return returnString;
		return returnEntity;
	}
	
	public List<RestaurantDetail> imGetRestaurantsFromCloud(String text,String lat,String lon , String count,int distance){
		List<RestaurantDetail> restaurantPOList = new ArrayList<RestaurantDetail>();
		if(!FVUtilities.isNullOrEmpty(text)){
			List<RestaurantDetail>	restPOList = new ArrayList<RestaurantDetail>();
			//	restPOList =  getRestPO(restaurantDetailsImpl.getRestByName(reqJson.getSearchText()),reqJson.getLatitude(), reqJson.getLongitude());
			try{
				restPOList = imGetRestaurantDetails(text,lat, lon,0,0);
			}catch(Exception e){
				e.printStackTrace();
				restPOList = restaurantDetailHelper.addRestToDB(fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(lat, lon,text));
			}
			if(restPOList.isEmpty() || restPOList.size()==0) 
				restaurantPOList = restaurantDetailHelper.addRestToDB(fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(lat, lon,text));	 
				else
					restaurantPOList =  restPOList;
				}else{
					try{
						restaurantPOList = imGetRestaurantDetails("",lat, lon,new Double(distance).doubleValue(),Integer.parseInt(count));
					}catch(Exception e){
						e.printStackTrace();
						restaurantPOList =  restaurantDetailHelper.addRestToDB(fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(lat, lon,Integer.parseInt(count)));
					}
			if(restaurantPOList.isEmpty() || restaurantPOList.size()==0) 
				restaurantPOList =  restaurantDetailHelper.addRestToDB(fsRestaurantServiceHelper.imGetFourSquarePlaceDetails(lat, lon,Integer.parseInt(count)));
//		if(restaurantPOList.size() == 0)
//			response.setHasMoreProducts(false);
//		else 
//			response.setHasMoreProducts(true);
		}
		return restaurantPOList;
	}
	
	
	
	
	
		
	

}
