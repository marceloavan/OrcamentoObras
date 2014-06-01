package edu.asselvi.orcamentoobras.cripto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cripto {

	private static MessageDigest digesterMd5;
	
	static {
		try {
			digesterMd5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
	}
	
	public static String criptToMd5(String value) {
		
		digesterMd5.update(value.getBytes());
		byte[] hash = digesterMd5.digest();

		StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
	}
}
