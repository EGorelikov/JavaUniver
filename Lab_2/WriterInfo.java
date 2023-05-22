// Класс WriterInfo - для вывода информации о классах
public class WriterInfo {
    public void writeCarInfo(Car car) {
        System.out.println(car.toString());
    }

    public void writeTaxiParkInfo(TaxiPark taxiPark) {
        for (Car car : taxiPark.getCars()) {
            writeCarInfo(car);
        }
    }
}