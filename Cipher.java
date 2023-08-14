/**
* Cipher.java
* Emma Lucas
* This class represents the Cipher.
*/

public class Cipher 
{
    private Square plain1;
    private Square plain2;
    private Square cipher1;
    private Square cipher2;

    /**
    * Constructor used initializing the square objects
    * to be used for the cipher.
    */
    public Cipher(String key1, String key2)
    {
        plain1 = new Square(false);
        plain2 = new Square(true);
        cipher1 = new Square(key1);
        cipher2 = new Square(key2);
    
    }

    /**
    * Encrypts the message passed in
    * @param message - message to be encrypted
    * @return encrypted message
    */
    public String encrypt(String message)
    {
        //message = message.toUpperCase();
        String encrypted = "";
        for (int i = 0; i < (message.length() / 2); ++i)
        {
            char letter1 = message.charAt(2*i);
            char letter2 = message.charAt((2*i) + 1);
            int[] char1 = plain1.getPos(letter1);
            int[] char2 = plain2.getPos(letter2);
            if (Character.isLowerCase(letter1))
            {
                encrypted += Character.toLowerCase(cipher1.getChar(char1[0], char2[1]));
            }
            else
            {
                encrypted += Character.toUpperCase(cipher1.getChar(char1[0], char2[1]));

            }
            if (Character.isLowerCase(letter2))
            {
                encrypted += Character.toLowerCase(cipher2.getChar(char2[0], char1[1]));
            }
            else
            {
                encrypted += Character.toUpperCase(cipher2.getChar(char2[0], char1[1]));

            }
        }
        if (message.length() % 2 == 1)
        {
            encrypted += message.charAt(message.length() - 1);
        }
        return encrypted;
    } // end encrypt

    /**
    * Decrypts the message passed in
    * @param message - message to be decrypted
    * @return decrypted message
    */
    public String decrypt(String message)
    {
        String decrypted = "";
        String encrypted = "";
        for (int i = 0; i < (message.length() / 2); ++i)
        {
            char letter1 = message.charAt(2*i);
            char letter2 = message.charAt((2*i) + 1);
            int[] char1 = cipher1.getPos(letter1);
            int[] char2 = cipher2.getPos(letter2);
            if (Character.isLowerCase(letter1))
            {
                decrypted += Character.toLowerCase(plain1.getChar(char1[0], char2[1]));
            }
            else
            {
                decrypted += Character.toUpperCase(plain1.getChar(char1[0], char2[1]));

            }
            if (Character.isLowerCase(letter2))
            {
                decrypted += Character.toLowerCase(plain2.getChar(char2[0], char1[1]));
            }
            else
            {
                decrypted += Character.toUpperCase(plain2.getChar(char2[0], char1[1]));

            }
        } 
        if (message.length() % 2 == 1)
        {
            decrypted += message.charAt(message.length() - 1);
        }
        return decrypted;
    } 

} 