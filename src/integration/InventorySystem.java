package integration;

import model.Sale;

public class InventorySystem {
    private Sale sale;
    
    /**
     * Updates the external inventory system with the sale.
     * @param sale the sale that is about to end.
     */
    public void updateInventory(Sale sale) {
        this.sale = sale;
    }
}
