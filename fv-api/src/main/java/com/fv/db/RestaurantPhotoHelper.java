package com.fv.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fv.api.dto.PhotographDetail;
import com.fv.api.service.impl.RestaurantServiceImpl;
import com.fv.common.util.FVConstants;
import com.fv.common.util.FVUtilities;
import com.fv.repository.domain.RestaurantPhotoEO;
import com.fv.repository.service.RestaurantPhotoRepository;

@PropertySource({"classpath:constants.properties"})
public class RestaurantPhotoHelper {
	public static final Logger logger = LoggerFactory.getLogger(RestaurantPhotoHelper.class);
	@Autowired RestaurantPhotoRepository restaurantPhotoRepository;
	@Autowired
    Environment env;

	 public List<PhotographDetail> getPhotos(BigDecimal restId) {
	    	List<PhotographDetail>  photosPOs = new ArrayList<PhotographDetail>();
	    	Item item = restaurantPhotoRepository.getItem("restId",restId);
	    	String filename="";
	    	
	    	 for (int i = 0; i < 3; i++) {
	    		 PhotographDetail photosPO = new PhotographDetail();
	    			if(!FVUtilities.isNullOrEmpty(item) && item.isPresent("photo0")){
	    			
	    				 DateTime today = new DateTime();
	                     DateTime yesterday = today.plusDays(-i);
	                     int dayOfWeek = yesterday.getDayOfWeek();
	                     switch(dayOfWeek){
	                     case 1:filename= "Default_Parallax_1.jpg";
	                     break;
	                     case 2:filename= "Default_Parallax_2.jpg";
	                     break;
	                     case 3:filename= "Default_Parallax_3.jpg";
	                     break;
	                     case 4:filename= "Default_Parallax_4.jpg";
	                     break;
	                     case 5:filename= "Default_Parallax_5.jpg";
	                     break;
	                     case 6:filename= "Default_Parallax_6.jpg";
	                     break;
	                     case 7: filename= "Default_Parallax_1.jpg";
	                     break;
	                     }
	    			
	    			
	             
	    					Map<String, Object> photos = item.getMap("photo"+ String.valueOf(i));
	    					
	    					
	    					if(photos == null || photos.isEmpty()){
	    						 if(i==1){
	    							 System.out.println("path"+env.getProperty("parallax.path"));
	    	                    	 photosPO.setPhotoImageUrl(env.getProperty("parallax.path")+filename);
	    	                         photosPO.setHeight(900);
	    	                         photosPO.setWidth(1140);
	    	                         
	    	                     }
	    						 if(i==2){
	    	                    	 photosPO.setPhotoImageUrl(env.getProperty("parallax.path")+filename);
	    	                         photosPO.setHeight(300);
	    	                         photosPO.setWidth(400);
	    	                         
	    	                     }
	    					}else if(i==0){
	    					
	    					photosPO.setPhotoImageUrl(photos.get("imgUrl").toString());
	    					photosPO.setHeight( ((BigDecimal)photos.get("height")).intValue());
	    					photosPO.setWidth(((BigDecimal)photos.get("width")).intValue());
	    				
	             
	    					}
	          
	           
	             
	    	 }else{
	    	
	    			
	    		 if(i==0){
	                	 photosPO.setPhotoImageUrl(env.getProperty(FVConstants.LOGO_PATH));
	                     photosPO.setHeight(230 );
	                     photosPO.setWidth(230);
	    		 }      
	                     DateTime today = new DateTime();
	                     DateTime yesterday = today.plusDays(-i);
	                     int dayOfWeek = yesterday.getDayOfWeek();
	                     switch(dayOfWeek){
	                     case 1:filename= "Default_Parallax_1.jpg";
	                     break;
	                     case 2:filename= "Default_Parallax_2.jpg";
	                     break;
	                     case 3:filename= "Default_Parallax_3.jpg";
	                     break;
	                     case 4:filename= "Default_Parallax_4.jpg";
	                     break;
	                     case 5:filename= "Default_Parallax_5.jpg";
	                     break;
	                     case 6:filename= "Default_Parallax_6.jpg";
	                     break;
	                     case 7: filename= "Default_Parallax_1.jpg";
	                     break;
	                     }
	                    
	                     
	                     if(i==1){
	                    	 photosPO.setPhotoImageUrl(env.getProperty(FVConstants.PARALLAX_PATH)+filename);
	                         photosPO.setHeight(900);
	                         photosPO.setWidth(1140);
	                         
	                     }
	                     
	                     if(i==2){
	                    	 photosPO.setPhotoImageUrl(env.getProperty(FVConstants.PARALLAX_PATH)+filename);
	                         photosPO.setHeight(300);
	                         photosPO.setWidth(400);
	                         
	                     }
	                
	             }
	    			photosPOs.add(i, photosPO);
	    	 }
	    	
	             
	             
	         
	    	return photosPOs;
	    }
	 
	 
	 public  List<PhotographDetail> getPhoto(BigDecimal restId) {
		   	List<PhotographDetail>  photosPOs = new ArrayList<PhotographDetail>();
		   	Item item = restaurantPhotoRepository.getItem("restId",restId);
		   	
		   	if(item != null &&  !item.hasAttribute("photo0")){
			   	for(int i=1;i<=item.numberOfAttributes()-2;i++ ){
			   		PhotographDetail photosPO = new PhotographDetail();
			   		if(item.hasAttribute("photo"+i)){
			   	 
			   			Map<String, Object> photos = item.getMap("photo"+ String.valueOf(i));
			   			photosPO.setPhotoImageUrl(photos.get("imgUrl").toString());
			   			photosPO.setHeight( ((BigDecimal)photos.get("height")).intValue());
			   			photosPO.setWidth(((BigDecimal)photos.get("width")).intValue());
			   			photosPOs.add(i-1, photosPO);
			   		}
			   	
			   	}
		   	}
		   	return photosPOs;
		   }
}
