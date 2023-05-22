package by.gsu.pms;

public class QuantityDiscountPurchase extends Purchase {
    private static final int DISCOUNT_THRESHOLD = 5;
    private double discountRate;

    public QuantityDiscountPurchase() {
    }

    public QuantityDiscountPurchase(String name, double price, int quantity, double discountRate) {
        super(name, price, quantity);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double getCost() {
        double totalCost = super.getCost();
        if (quantity > DISCOUNT_THRESHOLD) {
            return totalCost - (totalCost * discountRate / 100);
        } else {
            return totalCost;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discountRate;
    }
}
