package com.epam.adok.hashalgorithms;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class SHA3Utils {

    public static String hash(byte[] bytes) {
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(bytes);
        return Hex.toHexString(digest);
    }
}
