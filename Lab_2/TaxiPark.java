import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Класс TaxiPark - представляет таксопарк
public class TaxiPark {
    private List<Car> cars;

    public TaxiPark(List<Car> cars) {
        this.cars = cars;
    }

    // Метод для подсчета стоимости автопарка
    public int calculateTotalCost() {
        int totalCost = 0;
        for (Car car : cars) {
            totalCost += calculateCarCost(car);
        }
        return totalCost;
    }

    // Вспомогательный метод для подсчета стоимости автомобиля
    private int calculateCarCost(Car car) {
        // Логика расчета стоимости автомобиля
        // ...

        return 0; // Заглушка, заменить на реальную логику
    }

    // Метод для сортировки автомобилей по расходу топлива
    public void sortCarsByFuelConsumption() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Integer.compare(car1.getFuelConsumption(), car2.getFuelConsumption());
            }
        });
    }

    // Метод для поиска автомобиля с заданным диапазоном скорости
    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof Sedan && ((Sedan) car).getMaxSpeed() >= minSpeed && ((Sedan) car).getMaxSpeed() <= maxSpeed) {
                result.add(car);
            }
            // Добавить другие типы автомобилей, если необходимо
        }
        return result;
    }

    public List<Car> getCars() {
        return cars;
    }
}