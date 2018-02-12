package io.zilker.zbuy.utility;

import java.security.MessageDigest;

public class PasswordHashing {
	public static String generateHash(String password) {
		
		StringBuffer hash = new StringBuffer();;
		
		  try {
		        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		        byte[] array = messageDigest.digest(password.getBytes());
		        
		        for (int i = 0; i < array.length; ++i) {
		          hash.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		     
		     
		    } 
		    catch (java.security.NoSuchAlgorithmException e) {
		    } 
		      
		
		return ""+hash;
	}
}
