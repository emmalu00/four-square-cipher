/**
* IO.java
* Emma Lucas
* This class handles all the input and output of the program.
*/

import java.util.*;

public class IO 
{
    private Scanner s;

    /**
    * Constructor that initializes the scanner.
    */
    public IO()
    {
        s = new Scanner(System.in);
    }

    /**
    * Asks the user for the first key
    * @return first key entered by user
    */
    public String firstKey()
    {
        System.out.print("Enter first key: ");
        String firstKey = s.nextLine().toUpperCase();
        return firstKey;
    }

    /**
    * Asks the user for the second key
    * @return second key entered by user
    */
    public String secondKey()
    {
        System.out.print("Enter second key: ");
        String secondKey = s.nextLine().toUpperCase();
        return secondKey;
    }

    /**
    * Asks the user if they want to encrypt or decrypt
    * @return character entered by user
    */
    public char encryptOrDecrypt()
    {
        System.out.print("Would you like to (e)ncrypt or (d)ecrypt?: ");
        char response = s.nextLine().toLowerCase().charAt(0);
        return response;
    }

    /**
    * Asks the user to enter the message being encrypted or decrypted
    * @param encrypt - indicates whether the user wants to encrypt or decrypt
    * @return message entered by user
    */
    public String message(boolean encrypt)
    {
        if (encrypt)
        {
            System.out.print("Enter the message to be encrypted: ");
        }
        else
        {
            System.out.print("Enter the message to be decrypted: ");
        }
        String message = s.nextLine().replaceAll(" ", "");
        return message;
    }

    /**
    * Prints the encrypted or decrypted message
    * @param message - encrypted or decrypted message
    * @param encrypt - indicates whether the user wants to encrypt or decrypt
    */
    public void printResults(String message, boolean encrypt)
    {
        if (encrypt)
        {
            System.out.println("Encrypted message: " + message);
        }
        else 
        {
            System.out.println("Decrypted message: " + message);
        }
        System.out.println();
    }

    /**
    * Prints an error message
    * @param error - error message
    */
    public void printError(String error)
    {
        System.out.println(error);
    }

    /**
    * Indicates whether a string has an even amount of characters.
    * @param messgae - message
    * @return true if message has even amount of characters, false otherwise
    */
    public boolean evenLetters(String message)
    {
        if (message.length() % 2 == 0)
        {
            return true;
        }
        return false;
    }

} // end IO class