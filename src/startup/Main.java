package startup;

import controller.Controller;
import view.View;
import integration.RegistryCreator;
import integration.Printer;
import integration.AccountingSystem;
import integration.InventorySystem;


/**
 * @author Gabriel Blid
 */
public class Main {
    
    public static void main(String[] args) {
        RegistryCreator regCreator = new RegistryCreator();
        Printer printer = new Printer();
        AccountingSystem accountingSystem = new AccountingSystem();
        InventorySystem inventorySystem = new InventorySystem();
        Controller contr = new Controller(regCreator, printer, 
                                          accountingSystem, inventorySystem);
        View view = new View(contr);
        
        view.sampleExecution();
        
    }
}