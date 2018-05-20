package model;

import integration.ItemDTO;

/**
 * the receipt from the sale.
 */
public class Receipt {
    private final Sale sale;
    
    /**
     * Creates a new instance
     * 
     * @param sale  The sale that is proved by this receipt.
     */
    Receipt(Sale sale) {
        this.sale = sale;
    }
    
    /**
     * Creates a well-formatted String with the entire content of the receipt.
     * 
     * @return The well-formatted receipt string.
     */
    public String createReceiptString(){
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "\nRECEIPT");
        
        for(ItemDTO item : sale.getItems()) {
            builder.append(item.getQuantity()).append(" st ");
            builder.append(item.getDescription()).append(" ");
            builder.append("(").append(item.getPrice()).append("kr)    ");
            builder.append(item.getPrice() * item.getQuantity()).append("kr");
            builder.append("\n");
        }
        endSection(builder);
        
        builder.append("Total Cost with taxes: ");
        appendLine(builder, Double.toString(sale.getRunningTotal()));
        builder.append("Change: ");
        appendLine(builder, Double.toString(sale.getChange()));
        endSection(builder);
        
        return builder.toString();
    }
    
    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }
    
    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}