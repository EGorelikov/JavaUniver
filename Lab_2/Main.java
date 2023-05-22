import java.util.ArrayList;
import java.util.List;

// Класс Main - точка входа в программу
public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Sedan("Toyota Camry", 7, 200));
        cars.add(new SUV("Jeep Wrangler", 12, 4));

        TaxiPark taxiPark = new TaxiPark(cars);

        WriterInfo writer = new WriterInfo();
        writer.writeTaxiParkInfo(taxiPark);

        taxiPark.sortCarsByFuelConsumption();

        System.out.println("Sorted Cars:");
        writer.writeTaxiParkInfo(taxiPark);

        List<Car> carsInRange = taxiPark.findCarsBySpeedRange(180, 220);
        System.out.println("Cars in Speed Range:");
        for (Car car : carsInRange) {
            writer.writeCarInfo(car);
        }

        int totalCost = taxiPark.calculateTotalCost();
        System.out.println("Total Cost: " + totalCost);
    }
}