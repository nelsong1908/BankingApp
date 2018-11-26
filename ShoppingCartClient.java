// **********************************************************************************************
// Program: ShoppingCartClient.java
// Name: Gerald Nelson
// VUnetID: nelsong3
// Section: Section 1
// Email: gerald.nelson@vanderbilt.edu 
// Class: CS 1101 - Vanderbilt University
// Date: 4/16/2018
// Honor statement: I attest that I understand the honor code for this class and have neither given 
//                  nor received any unauthorized aid on this assignment.
//
// Program Description:
//      Makes available the data and methods defined on a shopping cart and an item. In others,
//      it lets you go shopping, keeping track of the items and total balance.
//
// **********************************************************************************************


import java.util.Scanner;

public class ShoppingCartClient {
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";

    public static void main(String[] args) {

        String itemName = ""; char menuChoice; Scanner console = new Scanner(System.in);
        double quantity = 0.00; double price = 0.00; ShoppingCart myCart = new ShoppingCart();

        displayMainMenu();//displays menu
        menuChoice = getValidMenuChoice(console); // gets the menu choice
        processMenuChoice(console, menuChoice,myCart); //processes user's menu option
    }

    /**
     * displayMainMenu - displays main menu options.
     */
    private static void displayMainMenu() {
        System.out.println();
        System.out.print("SUZIE'S MAIN MENU\n" +
                "A - Add item to cart\n" +
                "D - Display cart\n" +
                "Q - Quit\n");
    }

    /**
     *
     * @param console - scanner object
     * @return - the menuchoice
     * Precondition: input must be either case insensitive 'A', 'D', or 'Q'
     *              and not contain any white space
     */
    private static char getValidMenuChoice(Scanner console) {
        boolean hasValidMenuChoice = false; String keyEntry = ""; char menuChoice = ' ';
        System.out.println();
        //runs a series checks to confirm a valid menuChoice
        while (!hasValidMenuChoice) {
            System.out.print("Choose an option: ");
            if (console.hasNextLine()) {
                keyEntry = console.nextLine();
                if (keyEntry.trim().length() == 0) {
                    System.out.println("Please choose a valid option"); }
                else if (!isValidMenuChoice(keyEntry)) {
                    System.out.println("Please choose a valid option"); }
                else {
                    menuChoice = keyEntry.charAt(0);
                    hasValidMenuChoice = true; } }
            else {
                menuChoice = 'Q';
                hasValidMenuChoice = true; } }return menuChoice;
    }

    /**
     * isValidMenuChoice - checks to see if the menuChoice meets data validation.
     * @param keyEntry - String representing the user's menuChoice
     * @return - whether the menuChoice is valid.
     */
    private static boolean isValidMenuChoice(String keyEntry) {
        keyEntry = keyEntry.toUpperCase();
        if (!keyEntry.equals("A") &&
                !keyEntry.equals("D")
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
     * @param myCart - a ShoppingCart object.
     */
    private static void processMenuChoice(Scanner console, char menuChoice, ShoppingCart myCart) {
        String text = "" + menuChoice; text = text.toUpperCase(); menuChoice = text.charAt(0);
        if (menuChoice == 'A') {
            addToCart(console, myCart);
            System.out.println();
            displayMainMenu();
            menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myCart);
        }
        else if (menuChoice == 'D') {
            myCart.displayCart();
            System.out.println();
            displayMainMenu();
            menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myCart);
        }
        else if (menuChoice == 'Q') { System.exit(0); }
    }

    /**
     * addToCart - adds an item to the cart
     * @param console - a scanner object
     * @param myCart - a shopping cart
     * Precondition: the cart cannot be full.
     */
    private static void addToCart(Scanner console, ShoppingCart myCart) {
        String itemName; double itemQuantity; double itemPrice;
        if(myCart.isFull()) {
            System.out.println("Cannot add item - shopping Cart is full.");
            System.out.println();
            char menuChoice = getValidMenuChoice(console);
            processMenuChoice(console, menuChoice, myCart);
        }
        else {
            System.out.println();
            System.out.println("** ADD AN ITEM TO CART **");
            itemName = getValidItemName(console);
            itemPrice = getValidDouble(console, PRICE);
            itemQuantity = getValidDouble(console, QUANTITY);
            myCart.addItem(itemName, itemPrice, itemQuantity);
            System.out.print("Item successfully added");
        }
    }

    /**
     * getValidItemName - gets an item name.
     * @param console - a scanner object.
     * @return - the item name.
     * Precondition: item name must be non-blank, non-empty.
     */
    private static String getValidItemName(Scanner console) {
        //Enter the item name:
        String itemName = "";
        boolean hasValidItemName = false;
        while (!hasValidItemName) {
            System.out.print("Enter the item name: ");
            if (console.hasNextLine()) {
                itemName = console.nextLine();
                if (itemName.trim().length() == 0) {
                    System.out.println("Please enter a valid item name");
                }
                else {
                    hasValidItemName = true;
                }
            }
            else {
                System.exit(0); } }
        return itemName; }

    /**
     * getValidDouble - gets a valid double amount from the user.
     * @param console - a scanner object
     * @param what - String specificying whether to prompt for price or quantity.
     * @return - return user's double amount
     * Precondition: non-blank, non-empty, >0.
     */
    private  static double getValidDouble(Scanner console, String what) {
        String prompt = ""; String discard = "";
        double dbl = 0.00;
        boolean hasValidDouble = false;
        //will set the correct prompt message.
        if (what.equals(PRICE)) { prompt = "Enter the price: ";
        } else { prompt = "Enter the quantity: "; }
        //runs data validation for non-blank, non-empty, non-zero.
        while(!hasValidDouble) {
            System.out.print(prompt);
            if (console.hasNextLine()) {
                String keyEntry = console.nextLine();
                Scanner keyScanner = new Scanner(keyEntry);
                if (keyEntry.trim().length() == 0) { //non-blank, non-empty check.
                    System.out.println("Error: Please enter a value > 0"); }
                else if (keyScanner.hasNextDouble()) {
                    dbl = keyScanner.nextDouble();
                    if (dbl > 0) {// >0 check.
                        hasValidDouble = true;
                    } else { System.out.println("Error: Please enter a value > 0"); }
                } else { System.out.println("Error: Please enter a value > 0"); }
            } else { System.exit(0); } }return dbl; }
}
