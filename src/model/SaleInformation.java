package model;

/**
 * Contains some information about a recently scanned item and the running total.
 */
public class SaleInformation {
    private final double price;
    private final String description;
    private final double runningTotal;
    
    /**
     * Creates a new instance.
     * 
     * @param price the price of the item.
     * @param description the description of the item.
     * @param runningTotal the current running total for the sale.
     */
    public SaleInformation(double price, String description, 
                                         double runningTotal) {
        this.price = price;
        this.description = description;
        this.runningTotal = runningTotal;          
    }
    
    @Override
    public boolean equals(Object other) {
        if(other == null || !(other instanceof SaleInformation)) {
            return false;
        }
        SaleInformation otherInfo = (SaleInformation) other;
        return (this.price == otherInfo.price && 
                this.description.equals(otherInfo.description) && 
                this.runningTotal == otherInfo.runningTotal);
    }
    
    @Override
    public String toString() {
        return price + "kr, " + description + ", " + runningTotal + "kr";
    }
}
