package com.fv.api.service.impl;

import java.math.BigDecimal;

import com.fv.api.dto.MenuDetail;
import com.fv.api.dto.MenuDetailRequest;
import com.fv.api.service.RestaurantService;
import com.fv.common.util.Either;
import com.fv.entity.CustomerRegistrationEO;
import com.fv.parser.menu.MenuDTO;
import com.fv.restaurants.RestaurantDetailsImpl;
import com.fv.util.FVUtilities;
import com.fv.util.propertyReader.MessageReader;

public class RestaurantServiceImpl implements RestaurantService{

	@Override
	public Either<MenuDetail> getRestaurantMenuDetail(MenuDetailRequest menuDetailRequest) {
		RestaurantDetailsImpl restDetailsImpl = new RestaurantDetailsImpl();
		MenuDTO menu = new MenuDTO();
		try {
			CustomerRegistrationEO userRegPO = userRegistrationImpl.imRetrieveRegistrationDetails(json.getApiKey());
			if(!userRegPO.isExpired()){
				menu = restDetailsImpl.getMenu(new BigDecimal(json.getRestId()),new BigDecimal(0),0);

				returnString = gson.toJson(menu);
			}else{
				returnString = FVUtilities.errorResponse("0",  MessageReader.getMessage("0"));
			}
			//System.out.println(mapper.writeValueAsString(menu));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//catch (JsonProcessingException e) {
		//// TODO Auto-generated catch block
		//e.printStackTrace();
		//}
		return returnString;
	
		return null;
	}

}
