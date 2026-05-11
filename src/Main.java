void main() {
    while(true) {
        IO.println("Please enter your account number, or \"exit\" to exit: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.toLowerCase().trim().equals("exit")){
            IO.println("Have a good day!");
            return;
        }

        Checksum checksum = new Checksum();

        if (checksum.checkAccountValidity(input)) {
            IO.println("Valid account number!");
        } else {
            IO.println("Invalid account number!");
        }
    }
}