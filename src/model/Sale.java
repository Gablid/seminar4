package model;

import integration.ItemDTO;
import integration.Printer;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains all information regarding the current sale
 */
public class Sale {
    private final List<ItemDTO> items = new ArrayList<>();
    private double runningTotal;
    private double changeAmount;
    private double totalTaxes;
    
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    
    /**
     * The specified observer will be notified when this sale has
     * been concluded.
     * 
     * @param revenueObserver  The observer to notify
     */
    public void addRevenueObserver(RevenueObserver revenueObserver) {
        revenueObservers.add(revenueObserver);
    }
    public void notifyObservers() {
        for (RevenueObserver revenueObserver : revenueObservers)
            revenueObserver.updateRevenue(runningTotal);
    }
    
    /**
     * Checks if an item exists in the registered items.
     * 
     * @param itemToCheck the item that will be checked.
     * 
     * @return wether or not the item has the same name as the item to check.
     */
    private boolean itemExists(ItemDTO itemToCheck) {
        for(ItemDTO item : items)
            if(itemToCheck.equals(item))
                return true;
        return false;
    }
    
    /**
     * Checks if an item exists in the registered items.
     * 
     * @param itemToFind the item that is looked for.
     * 
     * @return the item that has the same name as itemToFind.
     */
    private ItemDTO findItem(ItemDTO itemToFind) {
        for(ItemDTO item : items)
            if(itemToFind.equals(item))
                return item;
        return null;
    }
    
    /**
     * Updates the quantity of an item in the current sale.
     * 
     * @param item the item that shall be updated.
     * @param quantity the new quantity of the item.
     */
    private void updateQuantity(ItemDTO item, int quantity) {
        items.set(items.indexOf(findItem(item)), 
        new ItemDTO(item, findItem(item).getQuantity() + quantity));
    }
    
    /**
     * Updates the list that holds the items of the current sale
     * and adds a new item to it. if the item is already registered, the
     * quantity of said item is increased. Otherwise a new item is added to the
     * total sale. Also creates a new sale information about the new item.
     * 
     * @param item item that shall be added to current sale.
     * 
     * @return sale information of the latest item's price, description
     * and also running total of the sale.
     */
    public String addItem(ItemDTO item) {
        if(!itemExists(item)){
        runningTotal += item.getPrice();
        items.add(item);
        }
        else {
            runningTotal += item.getPrice();
            updateQuantity(item, 1);
        }
        SaleInformation newSaleInfo = new SaleInformation(item.getPrice(),
                                      item.getDescription(), runningTotal);
        return newSaleInfo.toString();
    }
    
    /**
     * Updates the list that holds the current sale and adds multiple of the
     * same item to it. Also creates a new sale information about the new items 
     * and the running total of the sale.
     * 
     * @param item the item that shall be added.
     * @param quantity the quantity of the item.
     * 
     * @return information about the newest item's price, description and
     * the current running total of the sale.
     */
    public String addItems(ItemDTO item, int quantity) {
        if(!itemExists(item)) {
            runningTotal += item.getPrice() * quantity;
            items.add(new ItemDTO(item, quantity));
        }
        else {
            runningTotal += item.getPrice() * quantity;
            updateQuantity(item, quantity);
        }
        SaleInformation newSaleInfo = new SaleInformation(item.getPrice(),
                                      item.getDescription(), runningTotal);
        return newSaleInfo.toString();
    }
    
    /**
     * Calculates the taxes of the current sale based on the items that are
     * registered.
     * 
     * @return the total taxes.
     */
    public double calculateTaxes() {
        totalTaxes = 0;
        for(ItemDTO item : items) {
            totalTaxes += item.getPrice() * item.getTax() * item.getQuantity();
        }
        return totalTaxes;
    }
    
    /**
     * Calculates the change from the payment
     * 
     * @param paidAmount the amount paid.
     * 
     * @return the amount of change.
     */
    public double calculateChange(double paidAmount) {
        changeAmount = paidAmount - runningTotal;
        return changeAmount;
    }
    
    /**
     * Prints the receipt with the total sale information.
     * 
     * @param printer  the printer that will print the receipt
     */
    public void printReceipt (Printer printer) {
        Receipt receipt = new Receipt(this);
        printer.printReceipt(receipt);
    }
    
    public List<ItemDTO> getItems() {
        return items;
    }
    
    /**
     * @return  the running total
     */
    public double getRunningTotal() {
        return runningTotal;
    }
    
    /**
     * @return the change from the current sale
     */
    public double getChange() {
        return changeAmount;
    }
    
    /**
     * @return the total taxes from the current sale
     */
    public double getTotalTaxes() {
        return totalTaxes;
    }
    
    
}