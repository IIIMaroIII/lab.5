package lt.esdc;

import java.util.Arrays;

public class StringOps {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        new StringOps().init();
    }

    public void init() {
//        findEvenRepeatableWords(); //✅
//        upperFirstLetterOfEachSentence(); //✅
//        countAndSortWordsByTotalOccurrences(); //✅
        palindromeSubstr();
    }

    public void findEvenRepeatableWords() {
        String input = "Sun Sun Sun Sun shines shines sun bright bright ".trim();
        String[] arr = input.toLowerCase().split("\\W+");
        System.out.println(BLUE + "Original sentence: " + input);

        int occurancesCounter = 0;
        for (String word : arr) {
            for (String eachWord : arr) {

                if (word.equals(eachWord)) {
                    occurancesCounter++;
                }
            }
            if (occurancesCounter % 2 != 0) {
                System.out.format(GREEN + "✅ The word <%s> has occurred %d times\n", word, occurancesCounter);
                return;
            }

        }
        System.out.println(RED + "⚠️ We haven't found any even occurrences.\n");

    }

    public void upperFirstLetterOfEachSentence() {
        String input = "the city wakes up. when the sun lights the streets and the houses. people leave their houses. the sun continues to shine over the city".trim();
        String[] arr = input.split("\\.+");

        String[] tmp = new String[arr.length];

        int i = 0;
        for (String sentence : arr) {
            String trimmedSentence = sentence.trim();
            char toUpperFirstChar = Character.toUpperCase(trimmedSentence.charAt(0));
            String newSentence = trimmedSentence.replaceFirst("^\\w", String.valueOf(toUpperFirstChar));
            System.out.println("new sentence: " + newSentence);
            tmp[i] = newSentence;

            i++;
        }

        System.out.println(GREEN + "👉 A given string: " + BLUE + input);
        System.out.println(GREEN + "🏁 Result: " + BLUE + String.join(". ", tmp));
    }

    //The city wakes up when the sun lights the streets and the houses. People leave their houses, and the sun continues to shine over the city.
    public void countAndSortWordsByTotalOccurrences() {
        String text = ("The sun shines brightly over the city, houses and people, and the sun rises above the buildings as well as. " +
                "As soon as the people..." +
                "The city wakes up when the sun lights the streets and the houses. " +
                "People leave their houses, and the sun continues to shine over the city.").trim();
        System.out.println(BLUE + "Original text: " + GREEN + text);

        String listOfWords = "city the sun houses people streets as".trim();
        System.out.println(BLUE + "List of words: " + GREEN + listOfWords + RESET);

        String[] arrFromText = text.toLowerCase().split("\\W+");
        String[] arrFromWordsList = listOfWords.toLowerCase().split("\\W+");

        // Init the temporary String[][], which will contain filled in String[] by word from the list
        // The length of the String[] will indicate how many times the word from the list
        // has occurred in the text;

        String[][] tmp = new String[arrFromWordsList.length][];

        // How many arrays have to inside the String[][];
        int totalArraysInsideResult = 0;

        for (String wordFromList : arrFromWordsList) {
            // Counter for occurrence;
            int occurancesCounter = 0;

            for (String wordInText : arrFromText) {
                if (wordFromList.equals(wordInText)) {
                    // If the word from the list occurred in the text then ++;
                    occurancesCounter++;
                }
            }

            // Skip if there are not any occurrences;
            if (occurancesCounter == 0) continue;

            // Initializing the arr of occurrences;
            String[] arr = new String[occurancesCounter];
            // Filling in;
            Arrays.fill(arr, wordFromList);
            // At the index <totalArraysInsideResult> setting up the current array;
            tmp[totalArraysInsideResult] = arr;
            totalArraysInsideResult++;

        }

        // If any occurrences were found
        if (totalArraysInsideResult == 0) {
            System.out.println(RED + "Sorry, we haven't found any occurrences!" + RESET);
        }

        // Getting rid of <null>;
        String[][] result = Arrays.copyOf(tmp, totalArraysInsideResult);

        // Sorting in reverse order
        Arrays.sort(result, (a, b) -> Integer.compare(b.length, a.length));

        // Printing the result of searching
        for (String[] innerArray : result) {
            System.out.format("The word %s occurred in the given text 👉 %s times %n", GREEN + innerArray[0] + RESET, BLUE + innerArray.length + RESET);
        }

    }

    public void palindromeSubstr() {
        String input = "In the level notes I found eye, then level, and finally racecar written in bold, eye.";
        System.out.println(BLUE + "Original text: " + GREEN + input);
        String[] arrOfWords = input.toLowerCase().trim().split("\\W+");

        int palindromeCounter = 0;
        String tmp = "";

        for (String word : arrOfWords) {
            int wordLength = word.length();
            int counter = 0;

            for (int i = 0; i < wordLength; i++) {
                char prevSymbol = word.charAt(i);
                char nextSymbol = word.charAt(wordLength - i - 1);
                if (prevSymbol == nextSymbol) counter++;

                // If the word is palindrome;
                if (counter == wordLength && counter > 1) {
                    tmp += word + ",";
                }


            }
        }
        String[] result = tmp.split("\\W+");
        Arrays.sort(result);
        System.out.println(RED + "Sorted array of palindromes: " + Arrays.toString(result) + RESET);
        if (result.length == 0) {
            System.out.println(RED + "❌ We have found none of palindrome in the given text" + RESET);
        }
        String longestPalindrome = result[result.length - 1];
        System.out.format(BLUE + "✅ We have found the longest palindrome %s which is %s chars long", GREEN + longestPalindrome + BLUE, GREEN + longestPalindrome.length() + BLUE);

    }

    public void specificPhoneNumberFormat() {
        // +7 999 123-45-67
        // 8(999)123-45-67
    }
}