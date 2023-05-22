import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PhoneDirectory {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            List<Phone> phoneList = PhoneListReader.readFromFile(inputFile);

            // Сортировка списка по возрастанию фамилии
            Collections.sort(phoneList);

            // Вывод отсортированного списка в удобочитаемой форме
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (Phone phone : phoneList) {
                    writer.write(phone.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error writing phone list to file: " + e.getMessage());
            }

            System.out.println("Phone list sorted and saved to file: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error reading phone list from file: " + e.getMessage());
        } catch (PhoneDataException e) {
            System.out.println("Invalid phone data: " + e.getMessage());
        }
    }
}