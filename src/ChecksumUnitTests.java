import org.junit.jupiter.api.Assertions;

class ChecksumUnitTests {

    @org.junit.jupiter.api.Test
    void validAccountSevenDigits() {
        Checksum checksum = new Checksum();
        String accountNumber = "1597533";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertTrue(validAccount);
    }

    @org.junit.jupiter.api.Test
    void validAccountElevenDigits(){
        Checksum checksum = new Checksum();
        String accountNumber = "79927398713";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertTrue(validAccount);
    }

    @org.junit.jupiter.api.Test
    void validAccountSixteenDigits(){
        Checksum checksum = new Checksum();
        String accountNumber = "4556737586899855";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertTrue(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidAccountSevenDigits(){
        Checksum checksum = new Checksum();
        String accountNumber = "2739871";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidAccountElevenDigits(){
        Checksum checksum = new Checksum();
        String accountNumber = "49927398717";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidAccountSixteenDigits(){
        Checksum checksum = new Checksum();
        String accountNumber = "4024007109022143";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void validWhitespaceRemoved(){
        Checksum checksum = new Checksum();
        String accountNumber = "   159 75 3   3 ";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertTrue(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidAlphabetCharactersUsedAtBeginning(){
        Checksum checksum = new Checksum();
        String accountNumber = "asdf1234";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidAlphabetCharactersUsedAtEnd(){
        Checksum checksum = new Checksum();
        String accountNumber = "1234asdf";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidSpecialCharactersUsedAtBeginning(){
        Checksum checksum = new Checksum();
        String accountNumber = "!@#1234";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }

    @org.junit.jupiter.api.Test
    void invalidSpecialCharactersUsedAtEnd(){
        Checksum checksum = new Checksum();
        String accountNumber = "1234!@#";
        boolean validAccount = checksum.checkAccountValidity(accountNumber);
        Assertions.assertFalse(validAccount);
    }
}