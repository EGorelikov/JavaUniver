import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PhoneListReader {
    public static List<Phone> readFromFile(String filePath) throws IOException, PhoneDataException {
        List<Phone> phoneList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    int id = Integer.parseInt(data[0]);
                    String lastName = data[1];
                    String firstName = data[2];
                    String middleName = data[3];
                    String address = data[4];
                    String creditCardNumber = data[5];
                    double debit = Double.parseDouble(data[6]);
                    double credit = Double.parseDouble(data[7]);
                    double localCallTime = Double.parseDouble(data[8]);
                    double longDistanceCallTime = Double.parseDouble(data[9]);

                    phoneList.add(new Phone(id, lastName, firstName, middleName, address, creditCardNumber,
                            debit, credit, localCallTime, longDistanceCallTime));
                } else {
                    throw new PhoneDataException("Invalid data format in the file.");
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading phone list from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new PhoneDataException("Invalid number format in the file.");
        }

        return phoneList;
    }
}