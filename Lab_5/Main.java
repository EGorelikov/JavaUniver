import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "patients.txt";

        try {
            // Создание списка пациентов и добавление данных
            PatientsList patientsList = new PatientsList();
            patientsList.addPatient(new Patient("Smith", "male", 30));
            patientsList.addPatient(new Patient("Johnson", "female", 40));
            patientsList.addPatient(new Patient("Davis", "female", 35));

            // Запись списка пациентов в файл
            PatientsListWriter.writeToFile(patientsList, filePath);
            System.out.println("Patients list saved to file: " + filePath);

            // Чтение списка пациентов из файла
            PatientsList readPatientsList = PatientsListReader.readFromFile(filePath);

            // Вывод информации о пациентах
            System.out.println("Number of females: " + readPatientsList.getFemaleCount());
            System.out.println("Average age: " + readPatientsList.getAverageAge());

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (PatientDataException e) {
            System.out.println("Invalid patient data: " + e.getMessage());
        }
    }
}