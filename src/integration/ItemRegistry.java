package integration;

import java.util.ArrayList;
import java.util.List;
import integration.ItemNotFoundException;
import integration.ItemRegistryException;

/**
 * Contains all calls to the store with the items that can be purchased.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList<>();
    
    ItemRegistry() {
        addItems();
    }
    /**
     * Search for an item that matches the search criteria.
     * 
     * @param name This object contains the information about the item.
     * @throws ItemNotFoundException if the item is not found in the item list.
     * @throws ItemRegistryException if the database call failed.
     * 
     * @return The item from the registry with matching identifier
     */
    public ItemDTO findItem(String name) throws ItemNotFoundException, 
            ItemRegistryException {
        try {
            for(ItemDTO item: items) {
                if(item.getName().equals(name))
                    if(name == "Apple")
                        throw new ItemRegistryException(name);
                    else    
                        return new ItemDTO(item);
            }
        } catch(ItemRegistryException exception) {
            System.out.println(exception);
        }
        throw new ItemNotFoundException(name);
    }
 
    
    /**
     * Adds more items to the registry
     */
    public void addItems() {
        items.add(new ItemDTO("Apple", "a red apple", 5, 0.1));
        items.add(new ItemDTO("Pear", "a green pear", 4, 0.1));
        items.add(new ItemDTO("Banana", "a yellow banana", 3, 0.1));
    }
    
    /**
     * 
     * @param index index that the item is received fro
     * 
     * @return The item in the registry list 
     */
    public ItemDTO getItem(int index){
        return items.get(index);
    }
}