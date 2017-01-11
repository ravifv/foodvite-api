package com.fv.api.service.impl.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.fv.api.dto.PhotographDetail;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.dto.RestaurantFeedbackDetail;
import com.fv.api.service.impl.RestaurantServiceImpl;
import com.fv.common.util.FVUtilities;


@PropertySource({"classpath:message.properties"})
public class FSRestaurantServiceHelper {
	@Autowired
	Environment message;
	public static final Logger logger = LoggerFactory.getLogger(FSRestaurantServiceHelper.class);
    
	public static final SimpleDateFormat fsDate = new SimpleDateFormat("yyyymmdd");
	private RestaurantDetail imGetFSVenueDetails(RestaurantDetail restaurantPO,String id) {
		List<PhotographDetail> phList = new ArrayList<PhotographDetail>();
		SimpleDateFormat fsDate = new SimpleDateFormat("yyyymmdd");
		HttpsURLConnection con=null;
		InputStream is;
		try {
			String url = "https://api.foursquare.com/v2/venues/"+id+"?"
			+ "client_id=SLXTIY3IQI102QD5SK5FS4W4KU4KZR2L4R2BAVZXE4O3SGX1&client_secret=AAMIDQLEYFSC3B32OZMB1WLUP2QPYCU4RV2Z4MCTOACQ21A3&v="
			+fsDate.format(new Date())
			+ "&m=foursquare";
			URL obj;
			obj = new URL(url);
			con = (HttpsURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// Send post request
			con.setDoOutput(true);
			if (con.getResponseCode() >= 400) {
			   is = con.getErrorStream();
			} else {
			   is = con.getInputStream();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			}
			in.close();
			is.close();
			RestaurantFeedbackDetail restaurantFeedPO = new RestaurantFeedbackDetail();
			JSONObject object = new JSONObject(response.toString());
			if(!FVUtilities.isNullOrEmpty(object)){
				JSONObject responseObj = object.getJSONObject("response").getJSONObject("venue");
				JSONArray groups = responseObj.getJSONObject("photos").getJSONArray("groups");
				for(int c=0;c<groups.length();c++){
					 //stubbing for restaurant visits <100 start
					if(responseObj.getJSONObject("stats").getInt("visitsCount")<100)
						continue;
					 //stubbing for restaurant visits <100 end
				        JSONArray itemsArr = groups.getJSONObject(c).getJSONArray("items");
				        if(responseObj.has("rating"))
				        	restaurantFeedPO.setRatings(new Float (responseObj.getDouble("rating")/2));
				        else
				        	restaurantFeedPO.setRatings(1); //change for android crash actual value 0
				      	restaurantFeedPO.setRecommendation("");
				      	restaurantFeedPO.setNoOfVisits(responseObj.getJSONObject("stats").getInt("visitsCount"));
				      	
				        restaurantFeedPO.setVisits(getVisitCount(responseObj.getJSONObject("stats").getInt("visitsCount")));
				        restaurantFeedPO.setFavourite(false);
				        restaurantPO.setRestaurantFeedbackDetail(restaurantFeedPO);
				   
				        for (int j = 0; j < itemsArr.length(); j++) {
				           	PhotographDetail photosPO = new PhotographDetail();
				           	JSONObject item =itemsArr.getJSONObject(j);
				           	photosPO.setWidth(item.getInt("width"));
				           	photosPO.setHeight(item.getInt("height"));
				           	photosPO.setPhotoImageUrl(item.getString("prefix")+item.getInt("width")+"x"+item.getInt("height")+item.getString("suffix"));
				                   
				            phList.add(photosPO);
				        }
				        restaurantPO.setPhotographs(phList);
				}
			}else{
//				restaurantFeedPO.setNoOfVisits(0);
//				restaurantFeedPO.setVisits("");
//				restaurantFeedPO.setRatings(1); //change for android crash value 0 
//				restaurantFeedPO.setVisits("0");
//				restaurantFeedPO.setRecommendation("");
				restaurantPO = null;  //stubbing for restaurant visits <100
			}
		//	restaurantPO.setPhotos(phList);
		//	restaurantPO.setFeed(restaurantFeedPO);
		}catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally{
		con.disconnect();
		}
	return restaurantPO;
	}
	
	public String getVisitCount(int count){
	String str = "";
		int i=0;
		if(String.valueOf(count).length() == 6){
			i = count/1000;
			str = String.valueOf(i)+"K";
		}else if(String.valueOf(count).length() == 5){
			i = count/1000;
			str = String.valueOf(i)+"K";
		}else if(String.valueOf(count).length() == 4){
			i = count/1000;
			str = String.valueOf(i)+"K";
		}else  	if(String.valueOf(count).length() == 3){
			str = String.valueOf(count);
		}else if(String.valueOf(count).length() == 2){
		 
			str = String.valueOf(count);
		}else{
			str = String.valueOf(count);
		}
		return str;
		}
	
	public List<RestaurantDetail> imGetFourSquarePlaceDetails(String lat, String lon,int offset){
		logger.debug("\nLoginService.imGetFourSquarePlaceDetails()");
		List<RestaurantDetail> restPOList = new ArrayList<RestaurantDetail>();
		InputStream is;
		HttpURLConnection con=null;
		try {
			String url = "https://api.foursquare.com/v2/venues/explore?ll="+lat+","+lon
			+ "&v="+fsDate.format(new Date())+"&client_id=SLXTIY3IQI102QD5SK5FS4W4KU4KZR2L4R2BAVZXE4O3SGX1&client_secret=AAMIDQLEYFSC3B32OZMB1WLUP2QPYCU4RV2Z4MCTOACQ21A3"
			+ "&sortByDistance=1&offset="+offset+"&specials=0&openNow=0&day=any&time=any&section=food&venuePhotos=1&m=foursquare";
			URL obj;
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// Send post request
			con.setDoOutput(true);
			if (con.getResponseCode() >= 400) {
			   is = con.getErrorStream();
			} else {
			   is = con.getInputStream();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			}
			in.close();
			is.close();
			JSONObject object = new JSONObject(response.toString());
			JSONObject responseObj = object.getJSONObject("response");
			//	System.out.println("responseObj::"+responseObj.toString());
			        JSONArray venuesArr = responseObj.getJSONArray("groups");
			        
			        for (int j = 0; j < venuesArr.length(); j++) {
			       
			        JSONObject grp =venuesArr.getJSONObject(j);
			        JSONArray itemsArr = grp.getJSONArray("items");
			       
			        for (int k = 0; k < itemsArr.length(); k++) {
			        JSONObject venue =itemsArr.getJSONObject(k);
			        //System.out.println("venue::"+venue);
			        JSONObject venueDetails =venue.getJSONObject("venue");
			        
			 
			        FSRestSeacrhPO fs = gson.fromJson(venueDetails.toString(), FSRestSeacrhPO.class);
			        //System.out.println("str::"+getFormattedName(fs.getName()));
			    	List<categoryPO> categoryList = fs.getCategories();
	           		for(categoryPO category:categoryList){
	           			
	           			for(String str:getCategoryNames()){
		           			if(category.getName().contains(str)){
		           				
		           				RestaurantDetail restaurantPO = new RestaurantDetail();
					           	LocationDetail locationPO = new LocationDetail();
					           	restaurantPO.setPlaceId(fs.getId());
					            restaurantPO.setRestName(getFormattedName(fs.getName()));
					           	restaurantPO.setIsFoodviteOnboarded(false);
					           	restaurantPO.setCategories(categoryList);
					            locationPO.setAddress(getAddress(fs.getLocation().getFormattedAddress()));
					            locationPO.setLatitude(String.valueOf(fs.getLocation().getLat()));
					            locationPO.setLongitude(String.valueOf(fs.getLocation().getLng()));
					            locationPO.setPincode(fs.getLocation().getPostalCode());
					           	//System.out.println(fs.getLocation().getDistance());
					            locationPO.setDistance(FVUtilities.units(fs.getLocation().getDistance()));
					            restaurantPO.setLocationDetail(locationPO);
					            //commenting for Indian restaurants
					           // if(!(String.valueOf(fs.getLocation().getLng())).contains("103.")) 
					            //        restaurantPO.setRestID(String.valueOf(IDGenerator.getLongId()));
					            RestaurantDetail restPO = imGetFSVenueDetails(restaurantPO,fs.getId());
					            if(!FVUtilities.isNullOrEmpty(restPO.getRestaurantFeedbackDetail()))
					            	restPOList.add(restPO);
					           
					            break;
		           			}
		           			else 
		           				continue;
		           			}
	           		}  
			          }
			      }
			                    
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} finally{
			con.disconnect();
			}
		
		return restPOList;
	}
	public String getAddress(String[] formattedAddress){
		StringBuffer str= new StringBuffer();
		for(int i=0;i<formattedAddress.length;i++){
			str.append( formattedAddress[i]);
			str.append(" ");
		}
		return str.toString();
	}
	
	public List<RestaurantDetail> imGetFourSquarePlaceDetails(String lat, String lon,String searchText){
		
		searchText = searchText.replace("&", "");
		searchText = searchText.replace(" ", "");
		List<RestaurantDetail> restPOList = new ArrayList<RestaurantDetail>();
		HttpURLConnection con = null ;
		URL obj;
		try {
			String url = "https://api.foursquare.com/v2/venues/search?ll="+lat+","+lon
			+"&client_id=SLXTIY3IQI102QD5SK5FS4W4KU4KZR2L4R2BAVZXE4O3SGX1&client_secret=AAMIDQLEYFSC3B32OZMB1WLUP2QPYCU4RV2Z4MCTOACQ21A3&v="+fsDate.format(new Date())+"&query="+searchText+"&categoryId=4d4b7105d754a06374d81259,4d4b7105d754a06376d81259"
			;
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.flush();
			wr.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
				in.close();
			JSONObject object = new JSONObject(response.toString());
				JSONObject responseObj = object.getJSONObject("response");
			        JSONArray venuesArr = responseObj.getJSONArray("venues");
			           
			        for (int j = 0; j < venuesArr.length(); j++) {
			           
			            JSONObject venue =venuesArr.getJSONObject(j);

			           	FSRestSeacrhPO fs = gson.fromJson(venue.toString(), FSRestSeacrhPO.class);
			           	//System.out.println("fs restnames"+fs.getName());
			           	List<categoryPO> categoryList = fs.getCategories();
			           		for(categoryPO category:categoryList){
			           			
			           			for(String str:getCategoryNames()){
				           			if(category.getName().contains(str)){
				           				
				           				RestaurantDetail restaurantPO = new RestaurantDetail();
				           				LocationDetail locationPO = new LocationDetail();
							           	restaurantPO.setPlaceId(fs.getId());
			
							            restaurantPO.setRestName(getFormattedName(fs.getName()));
							           	restaurantPO.setIsFoodviteOnboarded(false);
							           	restaurantPO.setCategories(categoryList);
							            locationPO.setAddress(getAddress(fs.getLocation().getFormattedAddress()));
							            locationPO.setLatitude(String.valueOf(fs.getLocation().getLat()));
							            locationPO.setLongitude(String.valueOf(fs.getLocation().getLng()));
							            locationPO.setPincode(fs.getLocation().getPostalCode());
							           	//System.out.println(fs.getLocation().getDistance());
							            locationPO.setDistance(FVUtilities.units(fs.getLocation().getDistance()));
							            restaurantPO.setLocationDetail(locationPO);
//							            if(!(String.valueOf(fs.getLocation().getLng())).contains("103."))
//							                    restaurantPO.setRestID(String.valueOf(IDGenerator.getLongId()));
							            RestaurantDetail restPO = imGetFSVenueDetails(restaurantPO,fs.getId());
							            if(!FVUtilities.isNullOrEmpty(restPO.getRestaurantFeedbackDetail()))
							            	restPOList.add(restPO);
							           
							            break;
				           			}
				           			else 
				           				continue;
				           			}
			           		}       	
			           				
						           
			            }
			                    
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally{
			con.disconnect();
			}
			return restPOList;
			}
	
	
	private List<String> getCategoryNames(){
		List<String> categoryList =  new ArrayList<String>();
		int i=0;
		StringTokenizer st = new StringTokenizer(message.getProperty("categoryNames"),",");
		while (st.hasMoreElements()) {
			categoryList.add(i++, (String) st.nextElement());
		}

		return categoryList;
	}
		

}
