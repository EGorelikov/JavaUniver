import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class PhoneListWriter {
    public static void writeToFile(List<Phone> phoneList, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Phone phone : phoneList) {
                writer.write(phone.getId() + "," + phone.getLastName() + "," + phone.getFirstName() + ","
                        + phone.getMiddleName() + "," + phone.getAddress() + "," + phone.getCreditCardNumber() + ","
                        + phone.getDebit() + "," + phone.getCredit() + "," + phone.getLocalCallTime() + ","
                        + phone.getLongDistanceCallTime());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing phone list to file: " + e.getMessage());
        }
    }
}