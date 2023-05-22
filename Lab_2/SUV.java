// Класс SUV - подкласс Car
public class SUV extends Car {
    private int offRoadCapability;

    public SUV(String model, int fuelConsumption, int offRoadCapability) {
        super(model, fuelConsumption);
        this.offRoadCapability = offRoadCapability;
    }

    // Геттер и сеттер для доступа к полю offRoadCapability

    public int getOffRoadCapability() {
        return offRoadCapability;
    }

    public void setOffRoadCapability(int offRoadCapability) {
        this.offRoadCapability = offRoadCapability;
    }

    // Переопределение метода toString()

    @Override
    public String toString() {
        return "SUV{" +
                "model='" + getModel() + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", offRoadCapability=" + offRoadCapability +
                '}';
    }
}