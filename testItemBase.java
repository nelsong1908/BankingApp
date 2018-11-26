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


public class testItemBase {
    private static final String NAME = "Coke";
    private static final double PRICE = 1.99;
    private static final double QUANTITY = 3.00;


    public static void main(String[] args) {
        ItemBase mystery = new ItemBase();
        testSetMethods(mystery);
    }
    private static void testSetMethods(ItemBase item) {
        System.out.println("Begin Method Testing");
        item.setItemName(NAME);
        if (item.getItemName() != NAME) {
            System.out.println("Failed setItemName() test");
        }
        item.setItemPrice(PRICE);
        if (item.getItemPrice() != PRICE) {
            System.out.println("Failed setItemPRICE() test");
        }
        item.setItemQuantity(QUANTITY);
        if (item.getItemQuantity() != QUANTITY) {
            System.out.println("Failed setItemQuantity() test");
        }
        item.setItemSubtotal(PRICE, QUANTITY);
        if (item.getItemSubtotal() != (PRICE * QUANTITY)) {
            System.out.println("Failed setItemSubtotal() test");
        }
        String itemReport = item.toString();
        System.out.println(itemReport);
        System.out.println("Leave programmer to examine above output");
        System.out.println("Testing Complete");
    }
}
