package integration;

import integration.ItemDTO;

/**
 * Thrown when trying to add an item that does not exist
 */
public class ItemNotFoundException extends Exception {
    
    private String itemDoesNotExist;
    
    /**
     * Creates a new instance with a message specifiyng which item that does
     * not exist
     * 
     * @param itemDoesNotExist THe item that does not exist
     */
    public ItemNotFoundException(String itemDoesNotExist) {
        super("The item " + itemDoesNotExist 
                + " Does not exist in the database");
        this.itemDoesNotExist = itemDoesNotExist;
    }
    
    
    /**
     * @return the item that does not exist
     */
    public String getItemDoesNotExist() {
        return itemDoesNotExist;
    }
}
