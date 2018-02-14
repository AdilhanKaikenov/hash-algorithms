package com.epam.adok.hashalgorithms;

import com.epam.adok.io.FileReader;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class HashAlgorithmsPerformanceTest {

    private static final String MD5 = "MD5";
    private static final String SHA_1 = "SHA-1";
    private static final String SHA_256 = "SHA-256";

    private static final String filePath = "The Sun.jpg";

    private static FileReader fileReader = new FileReader();

    @Benchmark
    public void testMD5() {
        String md5 = MDUtils.hash(MD5, getFileBytes());
    }

    @Benchmark
    public void testSHA1() {
        String sha1 = MDUtils.hash(SHA_1, getFileBytes());
    }

    @Benchmark
    public void testSHA256() {
        String sha256 = MDUtils.hash(SHA_256, getFileBytes());
    }

    @Benchmark
    public void testBCrypt() {
        String bcrypt = BCryptUtils.hash(getFileBytes());
    }

    @Benchmark
    public void testSHA3() {
        String bcrypt = SHA3Utils.hash(getFileBytes());
    }

    private byte[] getFileBytes() {
        return fileReader.read(filePath);
    }
}
