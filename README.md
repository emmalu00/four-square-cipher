# four-square-cipher

## About
This program uses object-oriented programming to implement a four-square cipher algorithm. 
1. The user is prompted to enter both keys.
2. Then, the user is asked whether they want to encrypt or decrypt. 
3. If the user wants to encrypt, the user is asked for a message and then the encrypted result is displayed. If the user wants to decrypt, the user is asked for the original message and then the decrypted result is displayed. 

* The user may enter messages with even or odd number of characters.
* The user may enter messages with spaces, or uppercase or lowercase letters.
* All spaces are removed from all input strings before encryption or decryption.

### Running the Program
The program must be compiled through the command line with the following statement:

`javac CipherMain.java`

The program must then be run through the command line with the following statement:

`java CipherMain`

## Software Architecture

![Blank diagram-2](https://github.com/emmalu00/four-square-cipher/assets/106994328/a2e3e7c4-78c8-4c2f-824b-dd29661ef45a)
* _**Square Class**_ - Represents one 5x6 matrix object.
* _**Cipher Class**_ - Implements encryption and decryption.
* _**IO Class**_ - Handles all input and output of the program.
* _**CipherMain**_ - Handles all of the main logic.
