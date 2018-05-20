package integration;

/**
 *  This Class is responsible for instantiating all registries
 */
public class RegistryCreator {
    private final ItemRegistry itemRegistry = new ItemRegistry();
    
    /**
     * @return get the item registry.
     */
    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }
}
