package model;

/**
 * A listener interface for receiving notifications about the total revenue.
 * The class  that is interested in such notifications implements this interface,
 * and the object created with that class is registered with addRevenueObserver. 
 * When a sale is concluded, that object's updateRevenue method is invoked.
 * @author Gabriel Blid
 */
public interface RevenueObserver {
    
    /**
     * Invoked when a sale is concluded
     * 
     * @param newTotal The new total revenue. 
     */
    public void updateRevenue(double newTotal);   
}
