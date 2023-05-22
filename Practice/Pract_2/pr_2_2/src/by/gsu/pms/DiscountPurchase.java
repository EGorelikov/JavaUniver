package by.gsu.pms;

public class DiscountPurchase extends Purchase {
    private double discount;

    public DiscountPurchase() {
    }

    public DiscountPurchase(String name, double price, int quantity, double discount) {
        super(name, price, quantity);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        double totalCost = super.getCost();
        return totalCost - (totalCost * discount / 100);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discount;
    }
}
