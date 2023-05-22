package by.gsu.pms;

public class Purchase {
    private String name;
    private double price;
    public int quantity;

    public Purchase() {
    }

    public Purchase(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + quantity + ";" + getCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return Double.compare(purchase.price, price) == 0 && name.equals(purchase.name);
    }
}
