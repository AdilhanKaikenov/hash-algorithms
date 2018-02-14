package com.epam.adok.hashalgorithms;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Base64;


public class BCryptUtils {

    private static int workload = 12;

    public static String hash(byte[] bytes) {
        byte[] encode = Base64.getEncoder().encode(bytes);
        String source = new String(encode);
        return hash(source);
    }

    public static String hash(String source) {
        String salt = BCrypt.gensalt(workload);
        return(BCrypt.hashpw(source, salt));
    }
}
