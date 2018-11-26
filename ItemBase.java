// **********************************************************************************************
// Program: ItemBase.java
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
//      An application that holds the data for some item.
//
// **********************************************************************************************


public class ItemBase {
    //field variables
    private String itemName;
    private double itemPrice;
    private double itemQuantity;
    private double itemSubtotal;

    public ItemBase() {
        itemName = "empty";
        itemPrice = 0;
        itemQuantity = 0;
        itemSubtotal = 0;
    }

    public ItemBase(String item, double price, double quantity) {
        itemName = item;
        itemPrice = price;
        itemQuantity = quantity;
        itemSubtotal = price * quantity;
    }

    /**
     * setItemName - sets itemName to given parameter String
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * setItemPrice - set itemPrice to given price parameter
     * @param itemPrice
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * itemQuantity - set quantity to given parameter
     * @param itemQuantity
     */
    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * setItemSubtotal - set subtotal.
     * @param itemPrice
     * @param itemQuantity
     */
    public void setItemSubtotal(double itemPrice, double itemQuantity) {
        this.itemSubtotal = itemPrice * itemQuantity;
    }

    /**
     * getItemName - return itemName
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * getItemPrice - return item price
     * @return
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * getItemQuantity - return item quantity
     * @return
     */
    public double getItemQuantity() {
        return itemQuantity;
    }

    /**
     * getItemSubtotal - return item subtotal
     * @return
     */
    public double getItemSubtotal() {
        return itemSubtotal;
    }

    /**
     * toString - return a formatted string representing all data currently held by itemBase
     * class
     * @return
     */
    public String toString() {
        String printString = "";
        printString += String.format("%.1f %s @ $%.2f each = \t$%.2f",
                itemQuantity, itemName, itemPrice, itemSubtotal);
        return printString;
    }
}
