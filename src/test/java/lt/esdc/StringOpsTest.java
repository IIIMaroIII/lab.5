package lt.esdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

class StringOpsTest {

    // isFitForRegex_shouldReturnTrue_forValidPhoneNumSunbers
    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_1Sun() {
        // Arrange
        // Act
        String phone1 = "+7 999 123-45-67";


        // Assert
        assertTrue(StringOps.isFitForRegex(phone1));


    }

    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_2Sun() {
        // Arrange
        // Act
        String phone2 = "8(999)123-45-67";

        // Assert
        assertTrue(StringOps.isFitForRegex(phone2));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_withoutPlusPrefixSun() {
        // Arrange
        // Act
        String withoutPlus = "7 999 123-45-67";

        // Assert
        assertFalse(StringOps.isFitForRegex(withoutPlus));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongCountryCodeSun() {
        String wrongCountryCode = "+8 999 123-45-67";
        assertFalse(StringOps.isFitForRegex(wrongCountryCode));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceAfterPlus7Sun() {
        String missingSpace = "+7999 123-45-67";
        assertFalse(StringOps.isFitForRegex(missingSpace));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceBetweenGroupsSun() {
        String missingSpaceBetweenGroups = "+7 999123-45-67";
        assertFalse(StringOps.isFitForRegex(missingSpaceBetweenGroups));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_spacesInsteadOfHyphensSun() {
        String spacesInsteadOfHyphens = "+7 999 123 45 67";
        assertFalse(StringOps.isFitForRegex(spacesInsteadOfHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooFewDigitsInAreaCode_plus7Sun() {
        String tooFewDigits = "+7 99 123-45-67";
        assertFalse(StringOps.isFitForRegex(tooFewDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooManyDigitsInAreaCode_plus7Sun() {
        String tooManyDigits = "+7 9999 123-45-67";
        assertFalse(StringOps.isFitForRegex(tooManyDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingParentheses_in8FormatSun() {
        String missingParentheses = "8 999 123-45-67";
        assertFalse(StringOps.isFitForRegex(missingParentheses));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingClosingParenthesis_in8FormatSun() {
        String missingClosingParen = "8(999123-45-67";
        assertFalse(StringOps.isFitForRegex(missingClosingParen));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingHyphens_in8FormatSun() {
        String missingHyphens = "8(999)1234567";
        assertFalse(StringOps.isFitForRegex(missingHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongSeparatorAfterParentheses_in8FormatSun() {
        String wrongSeparator = "8(999) 123-45-67"; // space not allowed by your regex
        assertFalse(StringOps.isFitForRegex(wrongSeparator));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_containsLettersSun() {
        String containsLetters = "+7 999 12a-45-67";
        assertFalse(StringOps.isFitForRegex(containsLetters));
    }

    // findEvenRepeatableWords
    @Test
    void findEvenRepeatableWords_ifInputNull() {
        // Arrange
        String input = null;
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_ifInputIsBlank() {
        // Arrange
        String input = "";
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_ifOneWordIsSubstringOfAnother() {
        // Arrange
        String input = "he the the";
        String expected = "he";
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void findEvenRepeatableWords_shouldReturnBrightSun() {
        //Arrange
        String expected = "bright";
        String input = "Sun sun brIght bright bRigHt shines shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findEvenRepeatableWords_containsOddRepetitionsReturnNull() {
        //Arrange
        String expected = null;
        String input = "Sun sun bright bright shines shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_containsDifferentSeparators_shouldReturnSunSun() {
        //Arrange
        String expected = "sun";
        String input = "Sun ) sun sUn ( bright ; bright - shines , shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findEvenRepeatableWords_separatorsInTheBeginningOfAline_shouldReturnSun() {
        //Arrange
        String expected = "sun";
        String input = "( ) ) ( Sun ) sun sUn ( bright ; bright - shines , shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    // upperFirstLetterOfEachSentence
    @Test
    void upperFirstLetterOfEachSentence_ifInputIsNull() {
        //Arrange
        String input = null;
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ifInputIsBlank() {
        //Arrange
        String input = "";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsAnyCharactersExceptAlphabetic() {
        //Arrange
        String input = ". !@#$()-";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsAnyCharactersExceptAlphabeticButWithDotInTheMiddle() {
        //Arrange
        String input = ". !@#.$()-";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_OnlyWhiteSpaces() {
        //Arrange
        String input = "          ";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }


    @Test
    void upperFirstLetterOfEachSentence_ContainsSeparatorsAtTheBeginning() {
        //Arrange
        String input = ".  the sun shines. brightly over the city. houses and people.";
        String expected = "The sun shines. Brightly over the city. Houses and people.";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsCommas() {
        //Arrange
        String input = ".  the sun, shines. brightly, over the city. houses and, people.";
        String expected = "The sun, shines. Brightly, over the city. Houses and, people.";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_textIsNull() {
        //Arrange
        String text = null;
        String listOfWords = "sun  the shines over";
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertNull(actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_listIsNull() {
        //Arrange
        String text = "sun  the shines over";
        String listOfWords = null;
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertNull(actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_listIsEmptyString() {
        //Arrange
        String text = "sun  the shines over";
        String listOfWords = "";
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertNull(actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_textIsEmptyString() {
        //Arrange
        String text = "";
        String listOfWords = "sun  the shines over";
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertNull(actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_test1_return_sun8_the6_over3_shines1() {
        //Arrange
        String text = "The sun sun sun sun sun sun sun shines brightly over over over the the the city, houses and people, and the sun rises above the buildings as well as. ";
        String listOfWords = "sun  the shines over";
        String[] expected = new String[]{"The word <sun> occurred in the given text <8> times", "The word <the> occurred in the given text <6> times", "The word <over> occurred in the given text <3> times", "The word <shines> occurred in the given text <1> times"};
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertArrayEquals(expected, actual);

    }

    @Test
    void countAndSortWordsByTotalOccurrences_test2_return_sun0_the0_over0_shines0() {
        //Arrange
        String text = "brightly city, houses and people, and rises above buildings as well as. ";
        String listOfWords = "sun  the shines over";
        String[] expected = new String[]{"The word <sun> occurred in the given text <0> times", "The word <the> occurred in the given text <0> times", "The word <shines> occurred in the given text <0> times", "The word <over> occurred in the given text <0> times"};
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_textOnlyContainsSeparators_return_sun0_the0_over0_shines0() {
        //Arrange
        String text = ";';;!! .. .. ,, ..... ";
        String list = "sun  the shines over";
        String[] expected = new String[]{"The word <sun> occurred in the given text <0> times", "The word <the> occurred in the given text <0> times", "The word <shines> occurred in the given text <0> times", "The word <over> occurred in the given text <0> times"};
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, list);
        //Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void countAndSortWordsByTotalOccurrences_withDifferentCapitalization_return_sun8_the6_over3_shines1() {
        //Arrange
        String text = "The sun sUN sun Sun sUn suN SUN ShINes brightly over oVEr oVeR the tHE thE city, houses and people, and the sun rises above the buildings as well as. ";
        String listOfWords = "sUn  tHe sHINEs oVEr";
        String[] expected = new String[]{"The word <sun> occurred in the given text <8> times", "The word <the> occurred in the given text <6> times", "The word <over> occurred in the given text <3> times", "The word <shines> occurred in the given text <1> times"};
        //Act
        String[] actual = StringOps.countAndSortWordsByTotalOccurrences(text, listOfWords);
        //Assert
        assertArrayEquals(expected, actual);

    }

    @Test
    void palindromeSubstr_ifTextIsNull() {
        //Arrange
        String text4 = null;
        //Act
        String actual = StringOps.palindromeSubstr(text4);
        //Assert
        assertNull(actual);
    }

    @Test
    void palindromeSubstr_ifTextIsEmpty() {
        //Arrange
        String text4 = "";
        //Act
        String actual = StringOps.palindromeSubstr(text4);
        //Assert
        assertNull(actual);
    }

    @Test
    void palindromeSubstr_noneOfWordsIsPalindrome() {
        //Arrange
        String text4 = "In the  notes I found , then , and finally written in bold, .";
        //Act
        String actual = StringOps.palindromeSubstr(text4);
        //Assert
        assertNull(actual);
    }

    @Test
    @DisplayName("Returns 'racecar' cause its the only longest palindrome")
    void palindromeSubstr_testCase_returns_racecar(TestReporter reporter) {
        //Arrange
        String text4 = "In the i eye racecar radar civic notes I found , then , and finally written in bold, .";
        String expected = "racecar";
        //Act
        String actual = StringOps.palindromeSubstr(text4);
        // Report
        reporter.publishEntry("Returned value: ", actual);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void palindromeSubstr_testCase_radar() {
        //Arrange
        String text4 = "In the i eye racecar radar civic notes I found , then , and finally written in bold, .";
        String expected = "racecar";
        //Act
        String actual = StringOps.palindromeSubstr(text4);
        //Assert
        assertEquals(expected, actual);
    }
}