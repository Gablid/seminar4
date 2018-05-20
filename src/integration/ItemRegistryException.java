package integration;

/**
 * Thrown when something goes wrong while performing an operation in 
 * the <code>ItemRegistry</code>. The message might contain more
 * information about the error condition.
 */
public class ItemRegistryException extends RuntimeException {

    /**
     * Creates a new instance representing the condition described
     * in the specified message.
     *
     * @param msg A message that describes what went wrong.
     */
    ItemRegistryException(String msg) {
        super("Cannot access item in database");
    }
}