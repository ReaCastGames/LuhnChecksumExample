public class Checksum {
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

    public String cleanupInput(String input){
        //Remove all whitespace. "   1 2   5" is a valid account number after trimming to "125".
        input = input.replaceAll("\\s+", "");

        return input;
    }

    public boolean isNumber(String number){
        if(!number.matches("[0-9]+")){
            IO.println("Not a number!");
            return false;
        }

        return true;
    }
}