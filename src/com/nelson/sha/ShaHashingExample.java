package com.nelson.sha;

import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicReference;

public class ShaHashingExample {

    public static void main(String[] args) throws Exception {
        String password = "123456";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());

        byte byteData[] = messageDigest.digest();

        // convert the byte to hex format method 1
        AtomicReference<StringBuffer> sb;
        sb = new AtomicReference<>();
        sb.set(new StringBuffer());
        int i;
        for (i = 0; i < byteData.length; i++) {
            sb.get().append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.get().toString());

        // convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (byte aByteData : byteData) {
            String hex = Integer.toHexString(0xff & aByteData);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("Hex format : " + hexString.toString());
    }
}
