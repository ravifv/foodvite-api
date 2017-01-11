package com.fv.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fv.storage.util.AmazonS3Connection;




public class ImageUtil {
	  static AmazonS3 s3client = new AmazonS3Connection().getConnection();
	  private static final String SUFFIX = "/";
	
//	  public static String encodeToString(BufferedImage image, String type) {
//	        String imageString = null;
//	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//	        try {
//	            ImageIO.write(image, type, bos);
//	            byte[] imageBytes = bos.toByteArray();
//
//	            BASE64Encoder encoder = new BASE64Encoder();
//	            imageString = encoder.encode(imageBytes);
//
//	            bos.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return imageString;
//	    }

	
	
//	private static File createSampleFile() throws IOException {
//        File file = File.createTempFile("aws-java-sdk-", ".txt");
//        file.deleteOnExit();
//
//        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
//        writer.write("abcdefghijklmnopqrstuvwxyz\n");
//        writer.write("01234567890112345678901234\n");
//        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
//        writer.write("01234567890112345678901234\n");
//        writer.write("abcdefghijklmnopqrstuvwxyz\n");
//        writer.close();
//
//        return file;
//    }
//	
//	 private static void displayTextInputStream(InputStream input) throws IOException {
//	        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//	        while (true) {
//	            String line = reader.readLine();
//	            if (line == null) break;
//
//	            System.out.println("    " + line);
//	        }
//	        System.out.println();
//	    }
	
	 public static String  uploadGroupImage(String apikey,String id,String imageString,String type){
			String picurl="";
			  String keyName = "";
			  BufferedImage image = null;
			  byte[] imageByte;

			  
				try {
					
					imageByte = Base64.encodeBase64(imageString .getBytes());
					ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
					
					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setContentLength(imageByte.length);
					metadata.setContentType("image/"+type);
					String idg = String.valueOf(IDGenerator.getLongId());
					keyName = apikey+"/"+idg+"."+type;
				
				//	s3client.putObject(	 new PutObjectRequest("fv-customer-profile", keyName, new File(id+"."+type)));
					s3client.putObject("fv-customer-profile", keyName, bis, metadata);
					bis.close();
					picurl = "https://s3-ap-southeast-1.amazonaws.com/fv-customer-profile/"+apikey+"/"+idg+"."+type;
					return picurl;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}catch (com.amazonaws.AmazonClientException ace) {
					// TODO Auto-generated catch block
					ace.printStackTrace();
					return null;
				}
				
		}
	 
	 public static String storeRestPhoto(String gphotoUrl,int height,int width,String id){
		 String picUrl = null;
		 Image image = null;
		
		 URL url;
		try {
			 url = new URL(gphotoUrl);
			 image = ImageIO.read(url);
			
		
		 
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(id+"/"+id+height+"*"+width+".jpg");
		 
			byte[] b = new byte[2048];
			int length;
		 
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
		 
			is.close();
			os.close();
			
			ObjectMetadata metadata = new ObjectMetadata();
			
			metadata.setContentType("image/jpg");
			
			createFolder("fv-seller-profile",id,s3client);
			String keyName = id+"/"+id+height+"*"+width+".jpg";
			s3client.putObject("fv-seller-profile", keyName, is,metadata);
			picUrl = "https://s3-ap-southeast-1.amazonaws.com/fv-seller-profile/"+keyName;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return picUrl;
	 }

	 
	 public static String  uploadImage(String id,String imageString,boolean isUpdate,String type){
			String picurl="";
		  String keyName = "";
		  BufferedImage image = null;
		  byte[] imageByte;

			//BASE64Decoder decoder = new BASE64Decoder();
			try {
				imageByte = Base64.decodeBase64(imageString.getBytes());
				ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
				
				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setContentLength(imageByte.length);
				metadata.setContentType("image/"+type);
		
				if(isUpdate)
				createFolder("fv-customer-profile",id,s3client);
			
				keyName = id+"/"+IDGenerator.getLongId()+"."+type;
			
				//s3client.putObject(	 new PutObjectRequest("fv-customer-profile", keyName, new File(id+"."+type)));
				s3client.putObject("fv-customer-profile", keyName, bis, metadata);
				bis.close();
				picurl = "https://s3-ap-southeast-1.amazonaws.com/fv-customer-profile/"+keyName;
				return picurl;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}catch (com.amazonaws.AmazonClientException ace) {
				// TODO Auto-generated catch block
				ace.printStackTrace();
				return null;
			}
	}	
	
	 
	 public static String storeDefaultPhoto(String fileName,String customerId,String name,String id){
		 String picUrl = null;
		 
		File file = new File(fileName);
		
		createFolder("fv-customer-profile",customerId,s3client);
		String keyName = customerId+SUFFIX+id+".jpg";
		s3client.putObject("fv-customer-profile", keyName, file);
		picUrl = "https://s3-ap-southeast-1.amazonaws.com/fv-customer-profile/"+keyName;
		 return picUrl;
	 }
	 
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + "/", emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}
}
