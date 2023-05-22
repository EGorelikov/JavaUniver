import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "patients.ser";

    public static void main(String[] args) {
        PatientManager patientManager = new PatientManager();

        // Чтение параметров пациентов из командной строки
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter patient details:");
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Patient patient = new Patient(lastName, gender, age);
            patientManager.addPatient(patient);
        }

        // Сохранение объектов в файл
        ObjectSerializer.serializeObject(patientManager, FILE_PATH);

        // Чтение объектов из файла
        PatientManager deserializedPatientManager = (PatientManager) ObjectSerializer.deserializeObject(FILE_PATH);

        // Подсчет среднего возраста и количества женщин
        deserializedPatientManager.calculateAverageAge();
    }
}