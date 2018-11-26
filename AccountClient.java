// **********************************************************************************************
// Program Description:
//      Makes available the data and methods defined on a bank account. In other words,
//      it is a banking app.
//
// **********************************************************************************************


import java.util.Scanner;

public class AccountClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int accountNumber = getValidAccountNumber(console);
        Account myAccount = new Account(accountNumber);
        displayAccountNumber(accountNumber);
        displayMainMenu();
        char menuChoice = getValidMenuChoice(console);
        processMenuChoice(console, menuChoice, myAccount);

    }

    /**
     * displayAccountNumber - displays chosen account number.
     * @param accountNumber - an account number
     */
    private static void displayAccountNumber(int accountNumber) {
        System.out.print("Your account " + accountNumber + " is created with " +
                "zero balance. ");
        System.out.print("You can do the following operations.\n" +
                "\n");
    }

    /**
     * displayMainMenu() - displays the main menu options
     */
    private static void displayMainMenu() {

        System.out.print("Bank Account Operations\n" +
                "A - Add money to account\n" +
                "T - Take out money from account\n" +
                "B - Show Balance\n" +
                "Q - Quit\n" +
                "\n");
    }

    /**
     * getValidAccountNumber - gets valid account number from user.
     * @param console - a scanner object.
     * @return - returns an account number.
     */
    private static int getValidAccountNumber(Scanner console) {
        String discard = ""; //flushes bad input
        int integer = 0;
        boolean hasValidInteger = false; //becomes true once the input checks out on all reqs.
        //Will check for non-blank, non-empty, and >0.
        while(!hasValidInteger) {
            System.out.println("Please create your account. " +
                    "Type a positive integer as account number.");
            if (console.hasNextLine()) {
                String keyEntry = console.nextLine();
                Scanner keyScanner = new Scanner(keyEntry);
                if (keyEntry.trim().length() == 0) { //non-blank, non-empty check
                    System.out.println("Please enter a value > 0"); }
                else if (keyScanner.hasNextInt()) {
                    integer = keyScanner.nextInt();
                    if (integer >= 0) { //>0 check
                        hasValidInteger = true; }
                    else {
                        System.out.println("Please enter a positive integer"); }
                }
                else {
                    System.out.println("Please enter a a positive integer"); }
            }
            else {
                System.exit(0); }
        }return integer;
    }

    /**
     *  getValidMenuChoice - returns a meunChoice from the user.
     * @param console - a scanner object
     * @return - a char representing the user choice
     * Precondition: Input must be non-blank, non-empty.
     *               Helper methods will run further checks.
     */
    private static char getValidMenuChoice(Scanner console) {
        boolean hasValidMenuChoice = false;
        String keyEntry = "";
        char menuChoice = ' ';
       //runs a series checks to confirm a valid menuChoice
        while (!hasValidMenuChoice) {
            System.out.print("Choose an option: ");
            if (console.hasNextLine()) {
                keyEntry = console.nextLine();
                if (keyEntry.trim().length() == 0) {
                    System.out.println("Please choose a valid option");
                }
                else if (!isValidMenuChoice(keyEntry)) {
                    System.out.println("Please choose a valid option");
                }
                else {
                    menuChoice = keyEntry.charAt(0);
                    hasValidMenuChoice = true;
                }
            }
            else {
                menuChoice = 'Q';
                hasValidMenuChoice = true;

            }
        }
        return menuChoice;
    }

    /**
     * isValidMenuChoice - checks to see if the menuChoice meets data validation.
     * @param keyEntry - String representing the user's menuChoice
     * @return - whether the menuChoice is valid.
     * Precondition - input must be either non-case-sentitve A, T, B, or Q.
     */
    private static boolean isValidMenuChoice(String keyEntry) {
        keyEntry = keyEntry.toUpperCase();
        if (!keyEntry.equals("A") &&
                !keyEntry.equals("T")
                && !keyEntry.equals("B")
                && !keyEntry.equals("Q")) {
            return false;
        }
        else return true;


    }

    /**
     * processMenuChoice - runs the appropriate account manipulation method depending
     * on the user's choice.
     * @param console - a scanner object.
     * @param menuChoice - a char for user's menuChoice.
     * @param myAccount - an account number.
     */
    private static void processMenuChoice(Scanner console, char menuChoice, Account myAccount) {
        String text = "" + menuChoice;
        text = text.toUpperCase();
        menuChoice = text.charAt(0);

        if (menuChoice == 'A') {
            credit(console, myAccount);
            displayMainMenu();
            menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myAccount);
        }
        else if (menuChoice == 'T') {
            debit(console, myAccount);
            displayMainMenu();
            menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myAccount);
        }
        else if (menuChoice == 'B') {
            displayAccount(myAccount);
            displayMainMenu();
            menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myAccount);
        }
        else if (menuChoice == 'Q') {
            System.exit(0);
        }
    }

    /**
     * credit - adds money to the account
     * @param console -  scanner object
     * @param myAccount - banking account
     */
    private static void credit(Scanner console, Account myAccount) {
        double amount;
        System.out.println();
        System.out.println("Please enter credit amount:");
        amount = getValidAmount(console);
        myAccount.credit(amount);
        System.out.println();
    }

    /**
     * debit - debits an account.
     * @param console - a scanner object
     * @param myAccount - bank account
     * Precondition: debit must not be greater than account balance and not be a negative number.
     */
    private static void debit(Scanner console, Account myAccount) {
        double amount;
        System.out.println();
        System.out.println("Please enter debit amount:");
        amount = getValidAmount(console);
        if (amount > myAccount.getBalance()) {
            System.out.print("Amount withdrawn exceeds the current balance!\n");
            System.exit(0);
        }
        else {
            myAccount.debit(amount);
            System.out.println();}
    }

    /**
     * displayAccount - displays current balance.
     * @param myAccount - a bank account.
     */
    private static void displayAccount(Account myAccount) {
        System.out.println();
        System.out.println("The balance for account number " + myAccount.getAccountNumber()
               + " is "+ myAccount.getBalance() + ".");
        System.out.println();
        //The balance for account number 12345 is 0.0.
    }

    /**
     * getValidAmount - gets an amount from the user.
     * @param console -  a scanner object.
     * @return - an double amount.
     * Precondition - amount must be a double greater than 0.
     */
    private static double getValidAmount(Scanner console) {
        String discard = ""; //flushes bad input
        double dbl = 0.00;
        boolean hasValidDouble = false; //becomes true once the input checks out on all reqs.
        //Will check for non-blank, non-empty, and >0.
        while(!hasValidDouble) {
            if (console.hasNextLine()) {
                String keyEntry = console.nextLine();
                Scanner keyScanner = new Scanner(keyEntry);
                if (keyEntry.trim().length() == 0) { //non-blank, non-empty check
                    System.out.println("Please enter a value > 0"); }
                else if (keyScanner.hasNextDouble()) {
                    dbl = keyScanner.nextDouble();
                    if (dbl > 0) { //>0 check
                        hasValidDouble = true; }
                    else {
                        System.out.println("Please enter a value > 0"); }
                }
                else {
                    System.out.println("Please enter a value > 0"); }
            }
            else {
                System.exit(0); }
        }return dbl;
    }
}
