package by.gsu.pms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    private static final String FILE_PATH = "src/input.txt";

    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[6];

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String purchaseType = data[0];

                switch (purchaseType) {
                    case "GENERAL_PURCHASE":
                        String name = data[1];
                        double price = Double.parseDouble(data[2]);
                        int quantity = Integer.parseInt(data[3]);
                        purchases[index] = new Purchase(name, price, quantity);
                        break;
                    case "DISCOUNT_PURCHASE":
                        name = data[1];
                        price = Double.parseDouble(data[2]);
                        quantity = Integer.parseInt(data[3]);
                        double discount = Double.parseDouble(data[4]);
                        purchases[index] = new DiscountPurchase(name, price, quantity, discount);
                        break;
                    case "QUANTITY_DISCOUNT_PURCHASE":
                        name = data[1];
                        price = Double.parseDouble(data[2]);
                        quantity = Integer.parseInt(data[3]);
                        double discountRate = Double.parseDouble(data[4]);
                        purchases[index] = new QuantityDiscountPurchase(name, price, quantity, discountRate);
                        break;
                }

                index++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Print the array content
        System.out.println("Array Content:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        // Find the maximum cost purchase
        Purchase maxCostPurchase = findMaxCostPurchase(purchases);
        System.out.println("Maximum Cost Purchase:");
        System.out.println(maxCostPurchase);

        // Check if all purchases are equal
        boolean allEqual = areAllPurchasesEqual(purchases);
        System.out.println("Are All Purchases Equal? " + allEqual);
    }

    private static Purchase findMaxCostPurchase(Purchase[] purchases) {
        Purchase maxCostPurchase = null;
        double maxCost = Double.MIN_VALUE;

        for (Purchase purchase : purchases) {
            if (purchase.getCost() > maxCost) {
                maxCost = purchase.getCost();
                maxCostPurchase = purchase;
            }
        }

        return maxCostPurchase;
    }

    private static boolean areAllPurchasesEqual(Purchase[] purchases) {
        Purchase firstPurchase = purchases[0];

        for (int i = 1; i < purchases.length; i++) {
            if (!firstPurchase.equals(purchases[i])) {
                return false;
            }
        }

        return true;
    }
}
