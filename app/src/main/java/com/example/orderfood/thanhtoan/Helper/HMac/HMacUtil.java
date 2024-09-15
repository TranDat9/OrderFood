package com.example.orderfood.thanhtoan.Helper.HMac;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMacUtil {
    public static final String HMACSHA256 = "HmacSHA256";

    public static String HMacHexStringEncode(String algorithm, String key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(data.getBytes());
        StringBuilder hash = new StringBuilder();
        for (byte b : hmacBytes) {
            hash.append(String.format("%02x", b));
        }
        return hash.toString();
    }
}