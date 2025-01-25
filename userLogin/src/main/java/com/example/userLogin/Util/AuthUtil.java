package com.example.userLogin.Util;

import java.util.Base64;

public class AuthUtil {

    public static String encodeCredentials(String username, String password) {
        String authString = username + ":" + password;
        return Base64.getEncoder().encodeToString(authString.getBytes());
    }
}
