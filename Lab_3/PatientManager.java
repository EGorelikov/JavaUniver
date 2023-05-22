import java.util.ArrayList;
import java.util.List;

// Класс для работы с пациентами
class PatientManager {
    private List<Patient> patients;

    public PatientManager() {
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void calculateAverageAge() {
        int totalAge = 0;
        int count = 0;

        for (Patient patient : patients) {
            totalAge += patient.getAge();
            if (patient.getGender().equalsIgnoreCase("female")) {
                count++;
            }
        }

        double averageAge = (double) totalAge / patients.size();

        System.out.println("Average Age: " + averageAge);
        System.out.println("Number of Females: " + count);
    }
}