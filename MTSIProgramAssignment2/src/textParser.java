import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Matt Robinson
 */
public class textParser {

    /**
     * Main method
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner create = new Scanner(System.in);
        System.out.print("Please enter the name of the text file: ");
        String filename = create.nextLine();
        File file = new File(filename);
        Scanner input = new Scanner(file);

        // Counters
        int wordCount = 0;
        int below5 = 0;
        int above5 = 0;
        int evenCount = 0;
        int oddCount = 0;

        //Hash map created to control duplicates
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (input.hasNext()) {

            //stores each word from text
            String word = input.next().toLowerCase();
            word = removeAccents(word);
            
            //Handles case of a word thats first character is a parentheses
            if (word.contains("(")) {
                word = word.substring(1);
            }

            //Removes all of the special characters from the txt file
            word = word.split("[^a-zA-Z0-9]")[0];
            
            //New word added to map only if its the first occurrence
            //Only new words are counted toward the below/above 5 letter count and the
            //even/odd letter count
            if (!map.containsKey(word) && word.length() > 0) {
                map.put(word, 1);
                wordCount++;

                if (word.length() < 5) {
                    below5++;
                }
                else if (word.length() > 5) {
                    above5++;
                }

                if (word.length() % 2 == 0) {
                    evenCount++;
                }
                else {
                    oddCount++;
                }

            }
            //counter increases in map for repeat words
            else if (word.length() > 0) {
                map.put(word, map.get(word) + 1);
            }
        }

        //Prints all required data to console
        System.out.println("Number of Individual words: " + wordCount);
        System.out.println("Number of words that have more than 5 letters: "
            + above5);
        System.out.println("Number of words that have less than 5 letters: "
            + below5);
        System.out.println(
            "Amount of words that have an even amount of letters: "
                + evenCount);
        System.out.println(
            "Amount of words that have an odd amount of letters: " + oddCount);
        //System.out.print(map);

    }


    /**
     * 
     * @param str
     *            - string whose accents are being removed
     * @return a string with no accents
     */
    public static String removeAccents(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll(
            "\\p{InCombiningDiacriticalMarks}+", "");
    }

}
