/*
* This program generates all possible letter combinations
* corresponding to numbers on a phone.
* 
* @author  Julianne Leblanc-Peltier
* @version 1.0
* @since   December 11, 2025
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

final public class Main {
    private Main() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** public variables */
    final char[][] phoneLetters = { {'0'}, {'0'}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
    ArrayList<String> combinations = new ArrayList<String>();
    ArrayList<Integer> index = new ArrayList<Integer>();

    public static ArrayList listMnemonics(final int phoneNumber, ArrayList<Integer> index) {
        // generate possible letter combinations
        // calculate total possibilites & counter
        String currentCombination = "";
         
        // if the total possible combinations is equal to the index of the array list "combinations", then return to print all combinations.
        if (Math.pow(phoneNumber.length(), phoneNumber.length()) == combinations.length()) {
            return combinations;
        } else {
            // print combination x for all y char in phoneNumber
            // i = current position in index.
            for (int i = 0; i < index.length(); i++) {
                // sets int var number to equal the value of the current int in phoneNumber
                int number = phoneNumber.charAt(i);
                // sets currentCombination to the value of phoneLetters by identifying which number of phoneNumber it is, then by the lowk no clue lol
                currentCombination += phoneLetters(number, index[i]);
                index.set(i, index[i] + 1);
            }
            combinations.add(currentCombination);
            listMnemonics(phoneNumber, index);
        }
    }

    public static void main(final String[] args) {
        // main stub, get user input here
        boolean inputError = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program generates all possible letter combinations corresponding to numbers on a phone number from an inputted int number string.");

        while (inputError == true) {
            System.out.println("Enter Phone Number: ");
            String stringOfNumbers = userInput.nextLine();
            try {
                int numbersAsInt = Integer.parseInt(stringOfNumbers);
                inputError = false;
            } catch (NumberFormatException e) {
                System.out.printf("Error! Please enter a valid input!");
            }
        }

        for (int i = 0; i < numbersAsInt.length(); i++) {
            // adds multiple 0's to index, creates counter for all possible combinations.
            index.add(i, 0);
        }
        ArrayList<String> letterResults = listMnemonics(numbersAsInt, index);

        System.out.println(letterResults);

        System.out.println("\nDone! :)");
        userInput.close();
    }
}
