package integration;

import model.Sale;

public class AccountingSystem {
    private Sale sale;
    
    /**
     * Sends information to the external accounting system.
     * @param sale information about the sale.
     */
    public void updateAccounting(Sale sale) {
        this.sale = sale;
    }
}
