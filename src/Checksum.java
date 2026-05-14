/**
 * Checksum is a class that can be constructed to utilize methods pertaining to checking an account number's validity.
 * The class operates on the Mod 10 Luhn Algorithm.
 */
public class Checksum {
    /**
     * Check Account Validity takes in a non-null String representing an account number. It removes all whitespace
     * characters from that String, then checks to make sure the remaining characters are all numeric. If any of those
     * remaining characters are non-numeric, the method returns false. The method uses the Mod 10 Luhn Algorithm to make
     * sure the account number has a valid check digit at the end. It will return true if the account number passes this
     * check, or false if it doesn't.
     * <p>For the purposes of this repo being a display of my ability to program, this method does not handle any of
     * the edge cases of the Luhn algorithm, such as 09 to 09 transposition. This would need to be remedied in a live
     * production environment.
     * @param accountNumber The String representing the account number.
     * @return Whether the given account number is a valid account number.
     */
    public boolean checkAccountValidity(String accountNumber){
        accountNumber = cleanupInput(accountNumber);

        if(!isNumber(accountNumber)){
            return false;
        }

        int sum = 0;
        int length = accountNumber.length();
        byte parity = (byte) (length % 2);
        // (char - '0') converts from ASCII values to 0-9, assuming char is representing 0-9
        int checkDigit = accountNumber.charAt(length - 1) - '0';
        for (int i = length - 2; i >= 0; i--) {
            int digit = accountNumber.charAt(i) - '0';
            // Odd digits get added normally
            if(i%2 != parity){
                sum += digit;
            }
            // Even digits get doubled. If the digit's doubled value is above 9, subtract 9 to make it one digit
            else if (digit >= 5){
                sum += digit * 2 - 9;
            }
            else{
                sum += digit * 2;
            }
        }

        // See if the check digit is equal to this Luhn checksum formula.
        return checkDigit == ((10 - (sum % 10)) % 10);
    }

    /**
     * Cleanup Input is a method that takes in a non-null String and removes any whitespace characters, including space,
     * tab, new line, carriage return, vertical tab, and form feed characters. It then returns a non-null copy of that
     * cleaned String.
     * <p>This is kept simple for the purposes of this repo, but could be expanded to handle other common input accidents,
     * such as hyphens or slashes.
     * @param input The String being sent in to be cleaned of whitespace characters.
     * @return The cleaned-up String free of whitespace characters.
     */
    public String cleanupInput(String input){
        //Remove all whitespace. "   1 2   5" is a valid account number after trimming to "125".
        input = input.replaceAll("\\s+", "");

        return input;
    }

    /**
     * Is Number is a method that takes in a non-null String and checks to make sure every character in that String is
     * a numeric character [0-9].
     * @param number The String to be sent in to be checked for non-numeric characters.
     * @return True if the String is entirely composed of numeric characters [0-9], False if the String contains anything else.
     */
    public boolean isNumber(String number){
        if(!number.matches("[0-9]+")){
            IO.println("Not a number!");
            return false;
        }

        return true;
    }
}