package integration;

import model.Receipt;

public class Printer {
    
    /**
     * Prints the receipt.
     * @param is the receipt that shall be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceiptString());
    }  
}
