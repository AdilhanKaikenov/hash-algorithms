import com.epam.adok.hashalgorithms.BCryptUtils;
import com.epam.adok.hashalgorithms.MDUtils;
import com.epam.adok.hashalgorithms.SHA3Utils;
import com.epam.adok.io.FileReader;
import org.apache.commons.codec.binary.Base64;

public class AppMain {

    private static final String MD5 = "MD5";
    private static final String SHA_1 = "SHA-1";
    private static final String SHA_256 = "SHA-256";

    private static final String filePath = "The Sun.jpg";
    private static FileReader fileReader = new FileReader();


    public static void main(String[] args) {

        String md5 = MDUtils.hash(MD5, getFileBytes());
        System.out.println("MD5 - " + md5);

        String sha1 = MDUtils.hash(SHA_1, getFileBytes());
        System.out.println("SHA_1 - " + sha1);

        String sha256 = MDUtils.hash(SHA_256, getFileBytes());
        System.out.println("SHA_256 - " + sha256);

        String sha3 = SHA3Utils.hash(getFileBytes());
        System.out.println("SHA_3 - " + sha3);

        String bcrypt = BCryptUtils.hash(getFileBytes());
        System.out.println("BCrypt - " + bcrypt);
    }

    private static byte[] getFileBytes() {
        return fileReader.read(filePath);
    }
}
