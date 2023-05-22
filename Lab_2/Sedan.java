// Класс Sedan - подкласс Car
public class Sedan extends Car {
    private int maxSpeed;

    public Sedan(String model, int fuelConsumption, int maxSpeed) {
        super(model, fuelConsumption);
        this.maxSpeed = maxSpeed;
    }

    // Геттер и сеттер для доступа к полю maxSpeed

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // Переопределение метода toString()

    @Override
    public String toString() {
        return "Sedan{" +
                "model='" + getModel() + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
