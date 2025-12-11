/*
* This program generates all possible letter combinations
* corresponding to numbers on a phone.
* 
* @author  Julianne Leblanc-Peltier
* @version 1.0
* @since   December 11, 2025
*/

import java.util.ArrayList;

final class Main {
    private Main() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** variables */
    public static final char[][] phoneLetters = { {"0"}, {"0"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, {"T", "U", "V"}, {"W", "X", "Y", "Z"}};
    ArrayList<String> combinations = new ArrayList<String>();

    public static ArrayList listMnemonics(final int phoneNumber, int counter, int counter2) {
        // generate possible letter combinations // calculate total possibilites & counter
        String currentCombination = "";
         
        // if the total possible combinations is equal to the index of the array list "combinations", then return to print all combinations.
        if (pow(phoneNumber.length(), phoneNumber.length()) == combinations.length()) {
            return combinations;
        } else {
            // counter for position(#) of char in phoneNumber
            for (int i = 0; i < phoneNumber.length(); i++) {
                // sets index as the i char in phoneNumber
                int index = phoneNumber.charAt(i);

                combinations += phoneLetters(index, i);


                // counts position(#) of elements in 2nd array
                for (int[] innerArray : phoneNumber) {
                    // current position in array
                    int count2D += innerArray.length;
                    currentCombination += innerArray(count2D);
                    combinations.add(currentCombination);
                }

                combinations.add
                listMnemonics(phoneNumber, counter, counter2);

            }

        }



    }

    public static void main(final String[] args) {
        // main stub, get user input here
        int counter = 0;
        int counter2 = 0;
        boolean inputError = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program generates all possible letter combinations corresponding to numbers on a phone number from an inputted int number string.");

        while (inputError) {
            System.out.println("Enter Phone Number: ");
            String stringOfNumbers = userInput.nextLine();
            try {
                int numbersAsInt = Integer.parseInt(stringOfNumbers);
            } catch (NumberFormatException e) {
                System.out.printf("Error! Please enter a valid input!");
            }
            inputError = false;
        }

        ArrayList<String> letterResults = listMnemonics(numbersAsInt, counter, counter2);

        System.out.println(letterResults);

        System.out.println("\nDone! :)");
    }
}