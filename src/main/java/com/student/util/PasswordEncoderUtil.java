package com.student.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncoderUtil {

    public static String encode(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean matchesPassword(String password, String password1) throws NoSuchAlgorithmException {
        String hashedPassword = encode(password);
        String hashedPassword1 = encode(password1);
        return hashedPassword.equals(hashedPassword1);
    }
}
