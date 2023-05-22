import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class PatientsListWriter {
    public static void writeToFile(PatientsList patientsList, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Patient patient : patientsList.getPatients()) {
                writer.write(patient.getSurname() + "," + patient.getGender() + "," + patient.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing patients list to file: " + e.getMessage());
        }
    }
}