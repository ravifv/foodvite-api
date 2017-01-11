package com.fv.common.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
//import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Created by ishu on 13/02/16.
 */
public class IDGenerator {
    public static long getLongId(){
        return new Random().hashCode();
    }
    
//    public static String generateAESApiKey() {
//		try {
//			KeyGenerator generator = KeyGenerator.getInstance("AES");
//			generator.init(256);
//			SecretKey key = generator.generateKey();
//			String apiTokenString = Base64.encode(key.getEncoded());
//			return apiTokenString;
//		} catch (NoSuchAlgorithmException ex) {
//			return Base64.encode(BigInteger.probablePrime(256, new Random()));
//
//		}
//	}
}
