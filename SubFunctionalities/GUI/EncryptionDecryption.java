package SubFunctionalities.GUI;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionDecryption {
    private SecretKey secretKey;

    public EncryptionDecryption() throws NoSuchAlgorithmException {
        createSecretKey();
    }

    private void createSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        this.secretKey = keyGenerator.generateKey();
    }

    private String encryptData(byte[] data) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String encryptString(String string) throws Exception {
        return encryptData(string.getBytes());
    }
}
