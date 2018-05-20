package controller;

import model.Sale;
import integration.ItemDTO;
import integration.Printer;
import integration.RegistryCreator;
import integration.AccountingSystem;
import integration.InventorySystem;
import integration.ItemRegistry;
import integration.ItemNotFoundException;
import integration.ItemRegistryException;
import java.util.ArrayList;
import java.util.List;
import model.RevenueObserver;

public class Controller {
    private Sale sale;
    private ItemRegistry itemRegistry;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Printer printer;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    private RevenueObserver revenueObserver;

    /**
     * Creates a new instance
     * 
     * @param regCreator Used to get all classes that handle database calls.
     * @param printer Printer that prints the receipt.
     * @param accountingSystem external accounting system.
     * @param inventorySystem external inventory system.
     */
    public Controller(RegistryCreator regCreator, Printer printer,
         AccountingSystem accountingSystem, InventorySystem inventorySystem) {
        this.itemRegistry = regCreator.getItemRegistry();
        this.printer = printer;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem; 
    }
    
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all
     * information regarding the sale that is now started
     */
    public void startSale() {
        sale = new Sale();
        for (RevenueObserver revenueObserver : revenueObservers)
            sale.addRevenueObserver(revenueObserver);
    }
    
 /*   public void addRevenueObserver(RevenueObserver revenueObserver) {
        sale.addRevenueObservers(revenueObserver);
    } */
    
    /**
     * Creates a new instace with the registry only.
     * @param regCreator the object that creates registries.
     */
    public Controller(RegistryCreator regCreator) {
        this.itemRegistry = regCreator.getItemRegistry();
    }
    
    /**
     * Takes the entered name and finds the equal item and then adds it
     * to the sale and returns sale information
     * 
     * @param name the name of the searched item
     * @throws ItemNotFoundException if item is not found.
     */
    public String enterItemID(String name) throws ItemNotFoundException {
        ItemDTO item = itemRegistry.findItem(name);
        return sale.addItem(item);

    }
    
    /**
     * Takes an entered name and finds the equal item and adds the specified 
     * quantity to the sale and returns information about the sale
     * 
     * @param name the name of the item.
     * @param quantity the quantity of the item
     */
    public String enterItemIDAndQuantity(String name, int quantity) 
            throws ItemNotFoundException {
        ItemDTO item = itemRegistry.findItem(name);
        return sale.addItems(item, quantity);

    }
  
    /**
     * Calculates the taxes after all items has been registered
     * @return the total tax amount from the sale.
     */
    public double indicateAllItemsRegistered() {
        return sale.calculateTaxes();

    }
    
    /**
     * Calculates the change based on the running total and
     * the paid amount. Also prints a receipt and displays the change.
     * 
     * @param paidAmount the amount paid by the customer.
     * 
     * @return the change that the customer shall have. 
     */
    public double enterPaidCash(double paidAmount) {
        double changeAmount = sale.calculateChange(paidAmount);
        sale.printReceipt(printer);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        sale.notifyObservers();
        return changeAmount;
    }
    
    /**
     * The specifed observer that will be notified when a sale is concluded.
     * There will be notifications only for sales that are started after this
     * method is called.
     * 
     * @param revenueObserver The observer that shall be notified
     */
    public void addRevenueObserver(RevenueObserver revenueObserver) {
      revenueObservers.add(revenueObserver);
    }
    
}

