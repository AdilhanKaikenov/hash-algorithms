package com.epam.adok.hashalgorithms;

import com.epam.adok.exception.MessageDigestAlgorithmException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtils {

    private static final int SIGNUM = 1;
    private static final int HEX_RADIX = 16;
    private static final int HASH_LENGTH = 32;
    private static final String ZERO_PREFIX = "0";

    public static String hash(String algorithm, byte[] bytes) throws MessageDigestAlgorithmException {
        MessageDigest md;
        byte[] digest;
        try{
            md = MessageDigest.getInstance(algorithm);
            md.reset();
            md.update(bytes);
            digest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new MessageDigestAlgorithmException("Error in MDUtils in hash method:",  e);
        }
        BigInteger bigInt = new BigInteger(SIGNUM, digest);
        String mdHex = bigInt.toString(HEX_RADIX);
        while (mdHex.length() < HASH_LENGTH){
            mdHex = ZERO_PREFIX + mdHex;
        }
        return mdHex;
    }

}
