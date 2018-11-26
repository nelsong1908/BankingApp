// **********************************************************************************************
// Program: ShoppingCart.java
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
//      An application that behaves like a shopping cart.
//
// **********************************************************************************************


public class ShoppingCart {
    private static final int MAXSIZE = 10;
    private static ItemBase[] ShoppingCart = new ItemBase[MAXSIZE];
    private static int itemCount;

    public ShoppingCart() {
        itemCount = 0;
    }


    /**
     * addItem - adds an item to the shopping cart.
     * @param itemName - a string object
     * @param price - a double
     * @param quantity - a double
     * @return - the current item count given that a new item has been added to the cart.
     */
    public int addItem(String itemName, double price, double quantity) {
        ItemBase item = new ItemBase(itemName, price, quantity);
        ShoppingCart[itemCount] = item;
        itemCount++;
        return itemCount;
    }

    /**
     * isFull - checks whether the cart is full.
     * @return - true or false
     */
    public boolean isFull() {
        if(itemCount == 10) {
            return true;
        }
        return false;
    }

    /**
     * isEmpty - checks whether the cart is empty
     * @return - true or false
     */
    public boolean isEmpty() {
        if(itemCount == 0) {
            return true;
        }
        return false;
    }

    /**
     * displayCart - displays summary info on the shopping card.
     */
    public void displayCart() {
        String itemReport = "";
        double totalBalance = 0.00;
        //tells us the cart is empty.
        if (isEmpty()) { System.out.print("Shopping Cart is empty"); }
        //will print item info and subtotal
        else {
            System.out.println();
            System.out.println("Below is your order...");
            System.out.println();
            for (int i = 0; i < itemCount; i++) {
               itemReport = ShoppingCart[i].toString();
                System.out.println(itemReport); }
            for (int i = 0; i < itemCount; i++) {
                double subtotal = ShoppingCart[i].getItemSubtotal();
                totalBalance += subtotal; }
            System.out.println();
            System.out.printf("Total Amount due =======>\t$%.2f", totalBalance);
        }
    }
}
