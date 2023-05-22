// Класс Car - базовый класс для легковых автомобилей
public class Car {
    private String model;
    private int fuelConsumption;

    public Car(String model, int fuelConsumption) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
    }

    // Геттеры и сеттеры для доступа к полям

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    // Переопределение метода toString()

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
