import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AesEncryption {
    public static void main(String[] args) throws Exception {
        String plaintext = "Halo, ini adalah teks yang akan dienkripsi!";

        // Generate kunci rahasia
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        // Enkripsi
        byte[] ciphertext = encryptAES(plaintext, secretKey);
        String encryptedText = Base64.getEncoder().encodeToString(ciphertext);
        System.out.println("Teks Terenkripsi: " + encryptedText);

        // Dekripsi
        byte[] decryptedBytes = decryptAES(ciphertext, secretKey);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        System.out.println("Teks Terdekripsi: " + decryptedText);
    }

    // Metode untuk mengenkripsi menggunakan AES
    public static byte[] encryptAES(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    // Metode untuk mendekripsi menggunakan AES
    public static byte[] decryptAES(byte[] ciphertext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(ciphertext);
    }
}
