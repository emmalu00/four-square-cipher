/**
* Project8.java
* Emma Lucas
* This class handles all the main logic and communicates 
* between the IO and Cipher classes.
*/

import java.util.*;
import java.io.*;

public class CipherMain {
    public static void main(String[] args)
    {
        IO view = new IO();
        String firstKey = view.firstKey();
        String secondKey = view.secondKey();
        Cipher cipher = new Cipher(firstKey, secondKey);
        
        char c = view.encryptOrDecrypt();
        if (c == 'e')
        {
            String message = view.message(true);
            String encrypt = cipher.encrypt(message);
            view.printResults(encrypt, true);
        }
        else if (c == 'd')
        {
            String message = view.message(false);
            String decrypt = cipher.decrypt(message);
            view.printResults(decrypt, false);
        }

    }
}