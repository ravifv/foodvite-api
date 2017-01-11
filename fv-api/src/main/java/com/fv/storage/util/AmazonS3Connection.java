package com.fv.storage.util;

import java.io.IOException;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3Client;


public class AmazonS3Connection {
	
	public AmazonS3Client getConnection(){
		
		AmazonS3Client s3Client = null;

		ClientConfiguration config = new ClientConfiguration();
	//	config.setSocketTimeout(100000);
		config.setRequestTimeout(30 * 1000);
		config.setClientExecutionTimeout(30000);
		config.setMaxErrorRetry(3);

		//AWSCredentials credentials = null;
		try {
			
		
		
			s3Client = new AmazonS3Client(new PropertiesCredentials(AmazonS3Connection.class.getResourceAsStream("AWSS3Credentials.properties")),config);
	//	s3Client.setRegion(Region.getRegion(Regions.));
	

		return s3Client;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("io exception");
			return null;
		//	return FVUtilities.errorResponse("100", "Failure");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" exception");
		//	 FVUtilities.errorResponse("100", "Failure");
			 return null;
		}finally{
		//	s3Client.shutdown();
		}
		
	}
	


}
