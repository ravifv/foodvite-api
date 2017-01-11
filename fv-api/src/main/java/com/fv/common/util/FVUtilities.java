package com.fv.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fv.api.dto.Response;
import com.google.gson.Gson;

public class FVUtilities {
	static DecimalFormat f = new DecimalFormat("##.0");
	private static final double MIN_LAT = Math.toRadians(-90d);  // -PI/2
	private static final double MAX_LAT = Math.toRadians(90d);   //  PI/2
	private static final double MIN_LON = Math.toRadians(-180d); // -PI
	private static final double MAX_LON = Math.toRadians(180d);  //  PI
	//private static final FVLogger log = FVLoggerFactory.getLogger(FVUtilities.class);
	public String generateMD5(String paswd){
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("MD5");
		
	
			byte[] bytesOfMessage = paswd.getBytes();
			md.update(bytesOfMessage);
			byte[] mdbytes = md.digest();
			StringBuffer sb = new StringBuffer();
				for (int i = 0; i < mdbytes.length; i++) {
					sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
				}
        
				System.out.println("Digest(in hex format):: " + sb.toString());
				return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getTime(String reqdate){
		String time;
		java.util.Date date= new java.util.Date();

		String today = FVUtilities.getTimestamp(new Timestamp(date.getTime()), "MM/dd/yyyy");
		String passedDate = getTodayTime(reqdate);
		if(passedDate.equals(today))
			time = "today,"+" "+getOnlyTime(reqdate);
		else
			time = getDate(reqdate);
	
		return time;
		
	}
	
	public static String getSkipedTime(String reqdate){
		String time;
		java.util.Date date= new java.util.Date();

		String today = FVUtilities.getTimestamp(new Timestamp(date.getTime()), "MM/dd/yyyy");
		String passedDate = getTodayTime(reqdate);
		if(passedDate.equals(today))
			time = "today,"+" "+getOnlyTime(reqdate);
		else
			time = getDate(reqdate);
	
		return time;
		
	}
	
	
	public static String getTodayTime(String dd) {
		if (isNullOrEmpty(dd))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(FVConstants.DATE_FV_PATTERN);
		SimpleDateFormat dateFormat = new SimpleDateFormat(FVConstants.DATE_SIMPLE_PATTERN);
		try {
			return dateFormat.format(df.parse(dd));
		} catch (ParseException e) {
			return "";
		}
	}
	
	
	public static String getDate(String dd) {
		if (isNullOrEmpty(dd))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(FVConstants.DATE_FV_PATTERN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM hh:mm a");
		try {
			return dateFormat.format(df.parse(dd));
		} catch (ParseException e) {
			return "";
		}
	}
	
	public static String getOnlyTime(String dd) {
		if (isNullOrEmpty(dd))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(FVConstants.DATE_FV_PATTERN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		try {
			return dateFormat.format(df.parse(dd));
		} catch (ParseException e) {
			return "";
		}
	}
	public static Set<String> getBuddyCustomerId(Set<String> buddyList){
		Set<String> customerIdSet = new HashSet<String>();
		for(String customerId : buddyList){
			customerId = customerId.substring(customerId.indexOf("&")+1);
			customerIdSet.add(customerId);
		}
		return customerIdSet;
		
	}
	public static String getTimeDifference(String dateStart,String dateEnd,String pattern){
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		StringBuffer sb = new StringBuffer();
		String rt="";
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(dateStart);
		
			d2 = format.parse(dateEnd);
		
		
		long diff = d2.getTime() - d1.getTime();
		
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		
		if (diffDays == 0){
			if (diffHours == 0){
				if (diffMinutes == 1 || diffMinutes == -1)
					rt = String.valueOf(diffMinutes).concat("~"+FVConstants.MIN_TIME_TEXT);
				else
					rt = String.valueOf(diffMinutes).concat("~"+FVConstants.MINS_TIME_TEXT);
					
			}else if (diffHours == 1 || diffHours == -1)
				rt = String.valueOf(diffHours).concat("~"+FVConstants.HR_TIME_TEXT);
			else 
				rt = String.valueOf(diffHours).concat("~"+FVConstants.HRS_TIME_TEXT);
			
		}else if (diffDays == 1 || diffDays == -1){
			rt = String.valueOf(diffDays).concat("~"+FVConstants.DAY_TIME_TEXT);
		}
		else
			rt = String.valueOf(diffDays).concat("~"+FVConstants.DAYS_TIME_TEXT);
	
		
		return rt;
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
public static long getSkipTimeDifference(String dateStart,String dateEnd,String pattern){
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		StringBuffer sb = new StringBuffer();
		String rt="";
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(dateStart);
		
			d2 = format.parse(dateEnd);
		
		
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = diff / 1000 % 60;

		
		return diff;
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Long(0);
		}
		
	}

	public static String units(int distance){
		StringBuffer str = new StringBuffer();
		if(distance<1000)
			return str.append(distance).append(" ").append("meters").toString();
			else{
				String temp = f.format(Double.parseDouble(String.valueOf(distance))*0.001);
				return str.append(temp).append(" ").append("km").toString();
			}
	}
	
	public static String distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		  double R = 6371; // km
		
		
		double dLat = Math.toRadians(lat1-lat2);
	    double dLon = Math.toRadians(lon1-lon2);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	            Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat1)) * 
	            Math.sin(dLon/2) * Math.sin(dLon/2); 
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	    DecimalFormat df = new DecimalFormat("#.#");
	    
		return df.format(R * c);  
		//return (int)Math.round(dist);
		
	}
	
	public static int distanceDigits(double lat1, double lon1, double lat2, double lon2, String unit) {
		  double R = 6371; // km
		
		
		double dLat = Math.toRadians(lat1-lat2);
	    double dLon = Math.toRadians(lon1-lon2);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	            Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat1)) * 
	            Math.sin(dLon/2) * Math.sin(dLon/2); 
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	   // DecimalFormat df = new DecimalFormat("#.#");
	    
		return (int) (R * c * 1000);  
		//return (int)Math.round(dist);
		
	}
	
	
	
	



	
	public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
	    double earthRadius = 6371000; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist/1000;
	    }
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	public static String getString(String s, int maxlength) {
		String ret = s;
		if (s != null) {
			byte [] ori = s.getBytes(Charset.forName(FVConstants.SYSTEM_CODEPAGE));
			int len = ori.length;
			int newLen = maxlength;
			if (len > newLen) {
				while (true) {
					byte [] chars = new byte [newLen];
					for (int i=0; i<newLen; i++) {
						chars[i] = ori[i];
					}
					ret = new String(chars, Charset.forName(FVConstants.SYSTEM_CODEPAGE));
					ori = ret.getBytes(Charset.forName(FVConstants.SYSTEM_CODEPAGE));
					len = ori.length;
					if (len == newLen) // to make sure all characters are valid
						break;
					newLen--;
				}
			}
		}
		return ret;
	}
	
	public static Date getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return currDate;
	}

	@SuppressWarnings("static-access")
	public static Date getNextTime(int days) { // set forward date if days>0
		Calendar cal = Calendar.getInstance();
		cal.set(cal.DAY_OF_MONTH, cal.get(cal.DAY_OF_MONTH)+days);
		Date currDate = cal.getTime();
		return currDate;
	}
	
	@SuppressWarnings("static-access")
	public static Date getNextTime(Date dd, int days) { // set forward date if days>0
		Calendar cal = Calendar.getInstance();
		cal.setTime(dd);
		cal.set(cal.HOUR_OF_DAY, 0); // need to reset the hour info
		cal.set(cal.DAY_OF_MONTH, cal.get(cal.DAY_OF_MONTH)+days);
		Date currDate = cal.getTime();
		return currDate;
	}

	public static Date getTime(String dd, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(dd);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getTime(Date dd, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(dd);
	}

	
	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = new Timestamp(getCurrentTime().getTime());
		return timeStamp;
	}

	@SuppressWarnings("static-access")
	public static Timestamp getTimestamp(String tt, String pattern, boolean bStartOfDay, boolean bEndOfDay) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date dd;
		try {
			dd = df.parse(tt);
		} catch (ParseException e) {
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dd);
		
		if (bStartOfDay) {
			cal.set(cal.HOUR_OF_DAY, 0);
			cal.set(cal.MINUTE, 0);
			cal.set(cal.SECOND, 0);
		}
		
		if (bEndOfDay) {
			cal.set(cal.HOUR_OF_DAY, 23);
			cal.set(cal.MINUTE, 59);
			cal.set(cal.SECOND, 59);			
		}
			
		Timestamp timeStamp = new Timestamp(cal.getTimeInMillis());
		return timeStamp;
	}

	public static Timestamp getNextTimestamp(String tt, String pattern, int days, boolean bStartOfDay, boolean bEndOfDay) {
		Date dd = getTime(tt,  pattern);
		dd = FVUtilities.getNextTime(dd, days);
		String ddString = getTime(dd, pattern);
		return getTimestamp(ddString, pattern, bStartOfDay, bEndOfDay);
	}

	public static String getTimestamp(Timestamp tt, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(tt);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object value) {
		if (value == null)
			return true;
		
		if (value instanceof List) {
			if (((List)value).isEmpty())
				return true;
			else 
				return false;
		} else {
			String s = value.toString().trim();
			return (s.length() == 0 || s.equalsIgnoreCase("null") );
		}
	}
	
	public static String errorResponse(String errorCode,String errMsg){
		Response resjson = new Response();
		Gson gson = new Gson();
		resjson.setIsSuccess(false);
		resjson.setMsg(errMsg);;
		resjson.setResultCode(errorCode);
		return gson.toJson(resjson);
	}

	
}
