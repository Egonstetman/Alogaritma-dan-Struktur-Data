public class VigenereCipher {
    public static void main(String[] args) {
        String plaintext = "Halo, ini adalah teks yang akan dienkripsi!";
        String keyword = "kunci"; // Kata kunci untuk enkripsi

        // Enkripsi
        String ciphertext = encryptVigenere(plaintext, keyword);
        System.out.println("Teks Terenkripsi: " + ciphertext);

        // Dekripsi
        String decryptedText = decryptVigenere(ciphertext, keyword);
        System.out.println("Teks Terdekripsi: " + decryptedText);
    }

    // Metode untuk mengenkripsi menggunakan Vigenère Cipher
    public static String encryptVigenere(String plaintext, String keyword) {
        StringBuilder ciphertext = new StringBuilder();

        int keywordIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (Character.isLetter(currentChar)) {
                int key = keyword.charAt(keywordIndex % keyword.length()) - 'a';
                char encryptedChar = (char) ((currentChar - 'a' + key) % 26 + 'a');

                ciphertext.append(encryptedChar);
                keywordIndex++;
            } else {
                ciphertext.append(currentChar);
            }
        }

        return ciphertext.toString();
    }

    // Metode untuk mendekripsi menggunakan Vigenère Cipher
    public static String decryptVigenere(String ciphertext, String keyword) {
        StringBuilder plaintext = new StringBuilder();

        int keywordIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (Character.isLetter(currentChar)) {
                int key = keyword.charAt(keywordIndex % keyword.length()) - 'a';
                char decryptedChar = (char) ((currentChar - 'a' - key + 26) % 26 + 'a');

                plaintext.append(decryptedChar);
                keywordIndex++;
            } else {
                plaintext.append(currentChar);
            }
        }

        return plaintext.toString();
    }
}
