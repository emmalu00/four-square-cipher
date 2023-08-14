# four-square-cipher

## Background
In cryptography, _plain text_ is the original message and _cipher text_ is the encrypted message. A _cipher_ is an algorithm that converts _plain text_ into _cipher text_.

The _four-square_ cipher is a symmetric encryption technique invented by the French cryptographer Felix Delastelle. The technique encrypts pairs of letters (digraphs), and thus falls into a category of ciphers known as _polygraphic substitution ciphers_. Click [here](https://en.wikipedia.org/wiki/Four-square_cipher) for more information. 

In this project, the _four-square cipher_ is implemented using four matrices to convert pairs of plain text. The program utilizes two _keys_ that are used to _encrypt_ messages and to _decrypt_ messages. The two _keys_ are constructed using 5x6 matrices _plain1_, _plain2_, _cipher1_, and _cipher2_ as follows:

* **_plain1_** is constructed by filling in all letters of the alphabet one row at a time, starting with the letter 'A'. 

* **_plain2_** is constructed by filling in all letters of the alphabet one row at a time, starting with the letter 'Z'.
* 
* **_cipher1_** is constructed by filling in the matrix with the unique letters from the first key. For example, if the first key is “testkey”, then cipher1 is filled with the letters T, E, S, K, Y. Then the rest of the matrix is filled with remaining characters of the alphabet, making sure to not repeat any characters that appeared in the key.

* **_cipher2_** is constructed the same as **_cipher1_**, using the second key.

### Encryption
Each message is divided into groups of two characters. Each group of two is encrypted separately.
For example, consider encrypting the the string “HELLO WORLD”, using keys "testkey" and "secondkey". First, the message is divided into groups of two: HE LL OW OR LD (ignore spaces). 

* To _encrypt_ “HE”, find the row and column of “H” in **_plain1_**: **row [1], column [2]** and the row and column of “E” in **_plain2_**: **row [4], column [1]**.

* The first letter in the encrypted string is at **row [1]** (from the first letter “H”) and **column [1]** (from the second letter “E”) in **_cipher1_** – B. The second letter in the encrypted string is at **row [4]** (from the letter "E") and **column [2]** (from the letter "H") in **_cipher2_** – W. 

Therefore, “HE” encrypted becomes “BW”. When this process is repeated for every pair of characters in “HELLO WORLD”, the encrypted message becomes “BWLHJNJFIV”.

### Decryption
Decryption works in the same manner as encryption, but backwards. To _decrypt_ “BWLHJNJFIV”, the string must be broken up into groups of two – BW LH JN JF IV – and each group decrypted separately.

* To decrypt “BW”, find the row and column of “B” in **_cipher1_**: **row [1], column [1]** and find the row and column of “W” in **_cipher2_**: **row [4], column [2]**.

* The first letter in the decrypted string is at **row [1]** and **column [2]** in **_plain1_** – H. The second letter in the decrypted string is at **row [4]** and **column [1]** in **_plain2_** – E. Therefore, “BW” becomes “HE”.

When this process is repeated for every pair of characters in “ BWLHJNJFIV”, we get the encrypted message “HELLOWORLD”.

*** 

## About
This program uses object-oriented programming to implement a four-square cipher algorithm. 
1. The user is prompted to enter both keys.
2. Then, the user is asked whether they want to encrypt or decrypt. 
3. If the user wants to encrypt, the user is asked for a message and then the encrypted result is displayed. If the user wants to decrypt, the user is asked for the original message and then the decrypted result is displayed. 

#### Other specifications
* The user may enter messages with even or odd number of characters.
* The user may enter messages with spaces, or uppercase or lowercase letters.
* All spaces are removed from all input strings before encryption or decryption.

### Running the Program
The program must run through the command line with the format:

> `javac CipherMain.java`

followed by:

> `java CipherMain`

All spaces are removed from the input string for both keys and the message. The user may enter a message with an even or odd amount of characters. Additionally, the user may enter messages with spaces, and with upper and lowercase characters. This program contains four classes and implements MVC architecture. The Square and Cipher classes are both model classes. The IO class acts as the view, and the Project 8 class is the controller.

## Software Architecture
* _**Square Class**_ - Represents one 5x6 matrix object.
* _**Cipher Class**_ - Implements encryption and decryption.
* _**IO Class**_ - Handles all input and output of the program.
* _**CipherMain**_ - Handles all of the main logic.
