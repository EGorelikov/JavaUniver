import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class PatientsListReader {
    public static PatientsList readFromFile(String filePath) throws IOException, PatientDataException {
        PatientsList patientsList = new PatientsList();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) {
                    throw new PatientDataException("Invalid patient data: " + line);
                }
                String surname = data[0].trim();
                String gender = data[1].trim();
                int age = Integer.parseInt(data[2].trim());

                patientsList.addPatient(new Patient(surname, gender, age));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + filePath);
        } catch (IOException e) {
            throw new IOException("Error reading patients list from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new PatientDataException("Invalid age value in patients list.");
        }

        return patientsList;
    }
}
