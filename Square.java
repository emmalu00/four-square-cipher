/**
* Square.java
* Emma Lucas
* This class represents a Square object.
*/

public class Square 
{
    private char[][] matrix = new char[6][5];

    /**
    * Constructor used for filling plain1 and plain2 squares.
    */
    public Square(boolean backwards)
    {
        char letter = 'A';
        if (backwards) { letter = 'Z';}
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[i].length; ++j)
            {
                matrix[i][j] = letter;
                if (backwards) { letter--; }
                else letter ++;
            }
        }  
    }

    /**
    * Constructor that takes in the key and fills cipher1 and cipher2 squares.
    */
    public Square(String key)
    {
        key = removeDups(key).toUpperCase();
        int row, col;
        char letter = 'A';
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[i].length; ++j)
            {
                if (key.length() <= (i * matrix.length) + j)
                {
                    while(strContains(key, letter)) { letter++; }
                    matrix[i][j] = letter;
                    letter++;
                }
                else { matrix[i][j] = key.charAt((i * matrix.length) + j); }
            }
        }
    } 

    /**
    * Gets the character at a specific position of the matrix
    * @param r - row index
    * @param c - column index
    * @return the character at that row and column position in the matrix
    */
    public char getChar(int r, int c)
    {
        return matrix[r][c];
    }

    /**
    * Gets the matrix position of the passed in character
    * @param c - character to be found
    * @return integer array that holds the row and column positions of
    * that character in the matrix
    */
    public int[] getPos(char c)
    {
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == Character.toUpperCase(c))
                {   
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        pos[0] = -1;
        pos[1] = -1;
        return pos;
    }
    
    /**
    * Idenfities whether or not a string contains a character
    * @param s - string
    * @param c - character to search for in the string
    * @return true if the string contains the character, false otherwise
    */
    public boolean strContains(String s, char c)
    {
        s = s.toUpperCase();
        Character.toUpperCase(c);
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == c) {return true;}
        }
        return false;
    } 

    /**
    * Removes all duplicate letters in a string
    * @param key - string which is they key
    * @return the key without any duplicate letters
    */
    public String removeDups(String key)
    {
        key = key.toUpperCase();
        String newKey = "";
        for (int i = 0; i < key.length(); ++i)
        {
            if (!newKey.contains(String.valueOf(key.charAt(i))) && key.charAt(i) != ' ')
			{
				newKey += key.charAt(i);
			}
        }
        return newKey;
    }

} 