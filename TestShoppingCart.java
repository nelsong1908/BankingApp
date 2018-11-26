// **********************************************************************************************
// Program: BasicInputOutput.java
// Name: Gerald Nelson
// VUnetID: nelsong3
// Section: Section 1
// Email: gerald.nelson@vanderbilt.edu 
// Class: CS 1101 - Vanderbilt University
// Date: 1/24/2018
// Honor statement: I attest that I understand the honor code for this class and have neither given 
//                  nor received any unauthorized aid on this assignment.
//
// Program Description:
//      The assignment is get an integer from input, then square that integer and end with a new line.
//
// **********************************************************************************************


public class TestShoppingCart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        testMethods(cart);

    }
    private static void testMethods(ShoppingCart cart) {
        System.out.println("Begin Boolean Method Testing");
        if (!cart.isEmpty()) {
            System.out.println("isEmpty() failed");
        }
        System.out.println();
        cart.displayCart();
        System.out.println();
        System.out.println("The above should display ~= 'The cart is empty'");

        cart.addItem("Coke", 1.99, 2);
        if (cart.isEmpty()) {
            System.out.println("Either isEmpty() or addItem() failed");
        }
        if (cart.isFull()) {
            System.out.println("isFull() failed");
        }
        cart.displayCart();
        System.out.println();
        System.out.println("Should display 1 cokes in the cart." +
                " Will confirm whether addItem() has failed");

        for (int i = 0; i < 9; i++) {
            cart.addItem("Coke", 1.99, 2);
        }
        if (!cart.isFull()) {
            System.out.println("isFull() failed");
        }
        cart.displayCart();
        System.out.println();
        System.out.println("Should display 10 cokes in the cart");

    }
}
