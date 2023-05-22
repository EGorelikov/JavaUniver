import java.util.ArrayList;
import java.util.List;

class PatientsList {
    private List<Patient> patients;

    public PatientsList() {
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public int getFemaleCount() {
        int femaleCount = 0;
        for (Patient patient : patients) {
            if (patient.getGender().equalsIgnoreCase("female")) {
                femaleCount++;
            }
        }
        return femaleCount;
    }

    public double getAverageAge() {
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("No patients in the list.");
        }

        int sum = 0;
        for (Patient patient : patients) {
            sum += patient.getAge();
        }

        return (double) sum / patients.size();
    }

    public List<Patient> getPatients() {
        return patients;
    }
}