package view;

import controller.Controller;
import integration.ItemNotFoundException;
import integration.ItemRegistryException;
import logging.LogHandler;

/**
 * placeholder for the view that contains hardcoded calls to the controller.
 */
public class View {  
    private Controller contr;
    private LogHandler logger = LogHandler.getLogger();
    
    /**
     * Creates a new instance.
     * 
     * @param contr  The controller that is used for all operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates user input that generates calls to 
     * the different system operations.
     */
    public void sampleExecution() {

        contr.addRevenueObserver(new TotalRevenueView());
        System.out.println("Starting sample execution");
        contr.startSale();
        System.out.println("After call to startSale()");
        contr.startSale();
        try {
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.enterItemIDAndQuantity("Pear", 2));
        System.out.println(contr.enterItemIDAndQuantity("Apple", 3));
        System.out.println(contr.enterItemIDAndQuantity("Pear", 2));
        System.out.println(contr.enterItemID("Pear"));
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.enterItemID("Melon"));
        System.out.println(contr.enterItemID("Banana"));
        } catch(ItemNotFoundException exception) {
            handleException("item does not exist: " + 
                    exception.getItemDoesNotExist(), exception);
        }
        System.out.println(contr.indicateAllItemsRegistered());
        System.out.println(contr.enterPaidCash(75));
        
        contr.startSale();
        try {
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.enterItemIDAndQuantity("Pear", 4));
        System.out.println(contr.enterItemIDAndQuantity("Banana", 3));
        System.out.println(contr.enterItemIDAndQuantity("Pear", 2));
        System.out.println(contr.enterItemID("Pear"));
        System.out.println(contr.enterItemID("Banana"));
        System.out.println(contr.enterItemID("Melon"));
        System.out.println(contr.enterItemID("Banana"));
        } catch(ItemNotFoundException exception) {
            handleException("item does not exist: " + 
                    exception.getItemDoesNotExist(), exception);
        }
        catch(ItemRegistryException exception) {
            handleException("The database cannot be accessed", exception);
        }
        System.out.println(contr.indicateAllItemsRegistered());
        System.out.println(contr.enterPaidCash(75));
        
    }
    
    public void handleException(String message, Exception exc) {
        System.out.println(message);
      //  System.out.println(exc);
        logger.logException(exc);
    }
}
