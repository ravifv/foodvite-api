package com.fv.api.service.impl.helper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fv.api.dto.CategoryDetail;

public class RestaurantServiceHelper {
	public  String getFormattedName(String str){
		
		byte[] bytes;
		try {
			bytes = str.getBytes("UTF-16");
			str =   new String(bytes,"UTF-16");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return str;
	}
	public List<String> getFormattedCategory(List<com.fv.api.dto.RestaurantDetail.CategoryDetail> list){
		List<String> categoryDetails = new ArrayList<String>();
		for(com.fv.api.dto.RestaurantDetail.CategoryDetail categoryDetail: list){
			categoryDetails.add(getFormattedName(categoryDetail.getName())+"~"+categoryDetail.getId());
			
		}
		return categoryDetails;
	}
}
