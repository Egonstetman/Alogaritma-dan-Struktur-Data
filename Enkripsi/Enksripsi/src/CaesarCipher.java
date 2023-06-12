public class CaesarCipher {
    public static void main(String[] args) {
        String plaintext = "Halo, ini adalah teks yang akan dienkripsi!";
        int shift = 3; // Jumlah pergeseran

        // Enkripsi
        String ciphertext = encryptCaesar(plaintext, shift);
        System.out.println("Teks Terenkripsi: " + ciphertext);

        // Dekripsi
        String decryptedText = decryptCaesar(ciphertext, shift);
        System.out.println("Teks Terdekripsi: " + decryptedText);
    }

    // Metode untuk mengenkripsi menggunakan Caesar Cipher
    public static String encryptCaesar(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (currentChar + shift);

                if (!Character.isLetter(encryptedChar)) {
                    encryptedChar -= 26;
                }

                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }

        return ciphertext.toString();
    }

    // Metode untuk mendekripsi menggunakan Caesar Cipher
    public static String decryptCaesar(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) (currentChar - shift);

                if (!Character.isLetter(decryptedChar)) {
                    decryptedChar += 26;
                }

                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }

        return plaintext.toString();
    }
}
