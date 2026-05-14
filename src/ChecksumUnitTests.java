import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChecksumUnitTests {

    boolean checkAccountNumberIsValid(String accountNumber){
        Checksum checksum = new Checksum();
        return checksum.checkAccountValidity(accountNumber);
    }

    @Test
    void validAccountSevenDigits() {
        Assertions.assertTrue(checkAccountNumberIsValid("1597533"));
    }

    @Test
    void validAccountElevenDigits(){
        Assertions.assertTrue(checkAccountNumberIsValid("79927398713"));
    }

    @Test
    void validAccountSixteenDigits(){
        Assertions.assertTrue(checkAccountNumberIsValid("4556737586899855"));
    }

    @Test
    void invalidAccountSevenDigits(){
        Assertions.assertFalse(checkAccountNumberIsValid("2739871"));
    }

    @Test
    void invalidAccountElevenDigits(){
        Assertions.assertFalse(checkAccountNumberIsValid("49927398717"));
    }

    @Test
    void invalidAccountSixteenDigits(){
        Assertions.assertFalse(checkAccountNumberIsValid("4024007109022143"));
    }

    @Test
    void validWhitespaceRemoved(){
        Assertions.assertTrue(checkAccountNumberIsValid("   159 75 3   3 "));
    }

    @Test
    void invalidAlphabetCharactersUsedAtBeginning(){
        Assertions.assertFalse(checkAccountNumberIsValid("asdf1234"));
    }

    @Test
    void invalidAlphabetCharactersUsedAtEnd(){
        Assertions.assertFalse(checkAccountNumberIsValid("1234asdf"));
    }

    @Test
    void invalidSpecialCharactersUsedAtBeginning(){
        Assertions.assertFalse(checkAccountNumberIsValid("!@#1234"));
    }

    @Test
    void invalidSpecialCharactersUsedAtEnd(){
        Assertions.assertFalse(checkAccountNumberIsValid("1234!@#"));
    }
}