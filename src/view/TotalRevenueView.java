package view;

import model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    
    private double revenue = 0;
    
    @Override
    public void updateRevenue(double newTotal) {
        revenue += newTotal;
        printCurrentState();
    }
    
    /**
     * Shows the total revenue
     */
    private void printCurrentState() {
        System.out.println("the current revenue is: " + revenue);
    }
}
