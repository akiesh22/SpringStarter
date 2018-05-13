package com.spring.wc.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class SHA {
    public static String getKey(String password){
    return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
