import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input, and returns a set of words, a single word,
 * or a number as needed. 
 * 
 * By Alex Plaza
 * June 2014
 */
public class InputReader
{
    private Scanner reader; // this Scanner reads text
    private Scanner readeri; // this Scanner reads integers.

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
        readeri = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a set of words.
     *
     * @return  A set of Strings, where each String is one of the 
     *          words typed by the user
     */
    public HashSet<String> getInput() 
    {
        System.out.print("> ");   // print prompt
        String inputLine = reader.nextLine().trim().replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] wordArray = inputLine.split(" ");  // split at spaces

        // add words from array into hashset 
        HashSet<String> words = new HashSet<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
    
    /**
     * reads and return the input name.
     */
    public String inputName()
    {
           System.out.print("> ");
           String inputName = reader.nextLine();
           return inputName;
    }
    
    /**
     * reads and return the input integer.
     */
    public int inputOption()
    {
         System.out.print("> ");
        int inputOption = readeri.nextInt();
        return inputOption;
    }
}

