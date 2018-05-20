package integration;

/**
 * A DTO that contains information about an item.
 */
public class ItemDTO {
    
    private final String name;
    private final double price;
    private final int quantity;
    private final double tax;
    private final String description;
    /**
     * Creates a new ItemDTO that contains information about an item
     * with the quantity of 1.
     * 
     * @param name The name of the item
     * @param description The description of the item
     * @param price The price of the item
     * @param tax The tax of the item
     */
    public ItemDTO(String name, String description, double price, double tax) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.quantity = 1;
    }
    /**
     * Creates a copy of an ItemDTO.
     * @param item  The ItemDTO that is copied.
     */
    public ItemDTO(ItemDTO item) {
        this.name = item.name;
        this.description = item.description;
        this.price = item.price;
        this.tax = item.tax;
        this.quantity = item.quantity;
    }
    
    /**
     * Creates a copy of an ItemDTO with a different quantity.
     * @param item  The ItemDTO that is copied.
     */
    public ItemDTO(ItemDTO item, int quantity) {
        this.name = item.name;
        this.description = item.description;
        this.price = item.price;
        this.tax = item.tax;
        this.quantity = quantity;
    }
    
    /**
     * @return the price of this item
     */ 
    public double getPrice() {
        return price;
    }
    
    /**
     * @return the tax of this item
     */ 
    public double getTax(){
        return tax;
    }
    
    /**
     * @return the description of this item
     */ 
    public String getDescription(){
        return description;
    }
    
     /**
     * @return the price of this item
     */ 
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * @return the name of this item
     */
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object other) {
        if(other == null || !(other instanceof ItemDTO)) {
            return false;
        }
        ItemDTO otherItem = (ItemDTO) other;
        return this.getName().equals(otherItem.getName());
    }
}
