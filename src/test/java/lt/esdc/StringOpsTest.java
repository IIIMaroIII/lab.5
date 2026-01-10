package lt.esdc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringOpsTest {
    StringOps ops = new StringOps();

    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_1() {
        // Arrange
//        boolean expected = true;

        // Act
        String phone1 = "+7 999 123-45-67";


        // Assert
        assertTrue(ops.isFitForRegex(phone1));


    }

    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_2() {
        // Arrange
//        boolean expected = true;

        // Act
        String phone2 = "8(999)123-45-67";

        // Assert
        assertTrue(ops.isFitForRegex(phone2));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_withoutPlusPrefix() {
        // Arrange
//        boolean expected = false;
        // Act
        String withoutPlus = "7 999 123-45-67";

        // Assert
        assertFalse(ops.isFitForRegex(withoutPlus));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongCountryCode() {
        String wrongCountryCode = "+8 999 123-45-67";
        assertFalse(ops.isFitForRegex(wrongCountryCode));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceAfterPlus7() {
        String missingSpace = "+7999 123-45-67";
        assertFalse(ops.isFitForRegex(missingSpace));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceBetweenGroups() {
        String missingSpaceBetweenGroups = "+7 999123-45-67";
        assertFalse(ops.isFitForRegex(missingSpaceBetweenGroups));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_spacesInsteadOfHyphens() {
        String spacesInsteadOfHyphens = "+7 999 123 45 67";
        assertFalse(ops.isFitForRegex(spacesInsteadOfHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooFewDigitsInAreaCode_plus7() {
        String tooFewDigits = "+7 99 123-45-67";
        assertFalse(ops.isFitForRegex(tooFewDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooManyDigitsInAreaCode_plus7() {
        String tooManyDigits = "+7 9999 123-45-67";
        assertFalse(ops.isFitForRegex(tooManyDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingParentheses_in8Format() {
        String missingParentheses = "8 999 123-45-67";
        assertFalse(ops.isFitForRegex(missingParentheses));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingClosingParenthesis_in8Format() {
        String missingClosingParen = "8(999123-45-67";
        assertFalse(ops.isFitForRegex(missingClosingParen));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingHyphens_in8Format() {
        String missingHyphens = "8(999)1234567";
        assertFalse(ops.isFitForRegex(missingHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongSeparatorAfterParentheses_in8Format() {
        String wrongSeparator = "8(999) 123-45-67"; // space not allowed by your regex
        assertFalse(ops.isFitForRegex(wrongSeparator));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_containsLetters() {
        String containsLetters = "+7 999 12a-45-67";
        assertFalse(ops.isFitForRegex(containsLetters));
    }
}