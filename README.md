# Object Oriented Cipher Program

## Background
In cryptography, _plain text_ is the original message and _cipher text_ is the encrypted message. A _cipher_ is an algorithm that converts _plain text_ into _cipher text_.

The _four-square_ cipher is a symmetric encryption technique invented by the French cryptographer Felix Delastelle. The technique encrypts pairs of letters (digraphs), and thus falls into a category of ciphers known as _polygraphic substitution ciphers_. Click [here](https://en.wikipedia.org/wiki/Four-square_cipher) for more information. 

The _four-square cipher_ uses four matrices to convert pairs of plain text. This technique involves two _keys_ that are used to _encrypt_ messages and to _decrypt_ messages. We use the two _keys_ to construct the 5x6 matrices _plain1_, _plain2_, _cipher1_, and _cipher2_ as follows:

> **_plain1_** is constructed by filling in all letters of the alphabet one row at a time, starting with the letter 'A'. 

> **_plain2_** is constructed by filling in all letters of the alphabet one row at a time, starting with the letter 'Z'. 

> **_cipher1_** is constructed by filling in the matrix with the unique letters from the first key. For example, if the first key is “testkey”, then cipher1 is filled with the letters T, E, S, K, Y. Then the rest of the matrix is filled with remaining characters of the alphabet, making sure to not repeat any characters that appeared in the key.

> **_cipher2_** is constructed the same as **_cipher1_**.

Because there is 26 letters in the alphabet, but 30 spaces in the matrix, the last four spaces will be filled with special characters.

### Encryption
Each message is divided into groups of two characters. Each group of two is encrypted separately. For example, consider encrypting the the string “HELLO WORLD”, using keys "testkey" and "secondkey". First, the message is divided into groups of two: HE LL OW OR LD (ignore spaces). 
> To _encrypt_ “HE”, find the row and column of “H” in **_plain1_**: **row [1], column [2]** and the row and column of “E” in **_plain2_**: **row [4], column [1]**.

> The first letter in the encrypted string is at **row [1]** (from the first letter “H”) and **column [1]** (from the second letter “E”) in **_cipher1_** – B. The second letter in the encrypted string is at **row [4]** (from letter 2) and **column [2]** (from letter 1) in **_cipher2_** – W. 

Therefore, “HE” encrypted becomes “BW”. When this process is repeated for every pair of characters in “HELLO WORLD”, the encrypted message becomes “BWLHJNJFIV”.

### Decryption
Decryption works in the same manner as encryption, but backwards. To _decrypt_ “BWLHJNJFIV”, the string must be broken up into groups of two – BW LH JN JF IV – and each group decrypted separately.

> To decrypt “BW”, find the row and column of “B” in **_cipher1_**: **row [1], column [1]** and find the row and column of “W” in **_cipher2_**: **row [4], column [2]**.

> The first letter in the decrypted string is at **row [1]** and **column [2]** in **_plain1_** – H. The second letter in the decrypted string is at **row [4]** and **column [1]** in **_plain2_** – E. Therefore, “BW” becomes “HE”.

When this process is repeated for every pair of characters in “ BWLHJNJFIV”, we get the encrypted message “HELLOWORLD”.

## Project Description
This program uses object-oriented programming to implement a four-square cipher algorithm. The user is asked for both keys and whether they want to encrypt or decrypt. If the user wants to encrypt, the user is asked for the original message and then the encrypted result is displayed. If the user wants to decrypt, the user is asked for the original message and then the decrypted result is displayed. All spaces are removed from the input string for both keys and the message. The user may enter a message with an even or odd amount of characters. Additionally, the user may enter messages with spaces, and with upper and lowercase characters. This program contains four classes and implements MVC architecture. The Square and Cipher classes are both model classes. The IO class acts as the view, and the Project 8 class is the controller.

***

# Sqaure Class

The **_Square_** class is a model class. This class represents one of the 5x6 matrices. It has a 5x6 array of characters as an instance variable. It will also have three constructors – two for creating _plain1_ and _plain2_ that fills the matrices with all the letters of the alphabet and one for creating _cipher1_ and _cipher2_ that takes in the key and initializes the matrix as discussed in the background section. 

### `getChar(int r, int c)`
takes a row and column and returns the character at that position in the matrix

### `getPos(char c)`
takes a character and returns an integer array that holds the row and column positions of that character in the matrix

### `strContains(String s, char c)`
takes a string and char and returns true if string contains the character

### `removeDups(String s)`
takes a string, removes all duplicate letters and returns the string w/o duplicates

***

# Cipher Class

The **_Cipher_** class is a model class. This class handles encryption and decryption. It also contains four _Square_ objects as instance variables, which will be called _plain1_, _plain2_, _cipher1_, and _cipher2_. It also contains a constructor that takes in the two keys and creates the four _Square_ objects.

### `encrypt(String message)`
takes a string message and returns the encrypted string

### `decrypt(String message)`
takes an encrypted string and returns the decrypted string

***

# IO Class

The **_IO_** class functions as the _view_ in the MVC architecture. This class handles all input and output of the program.

### `firstKey()`
asks the user for the first key and returns the result

### `secondKey()`
asks the user for the second key and returns the result

### `encryptOrDecrypt()`
asks the user whether they want to encrypt or decrypt and returns a char ('e' for encrypt or 'd' for decrypt)

### `message(boolean encrypt)`
asks the user for the message they would like to encrypt or decrypt and returns the result

### `printResults(String message, boolean encrypt)`
takes the encrypted message or decrypted message, and prints the results to the console

*** 

# Project8 Class
The **_Project8_** class acts as the controller. This class contains only a main method and handles all of the main logic in the program. It creates an _IO_ object and a _Cipher_ object. It calls methods in _IO_ to get input and display results, and will call methods in _Cipher_ to complete the encryption and decryption. 
