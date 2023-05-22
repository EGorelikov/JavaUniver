import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Patient[] patients = new Patient[10];

        // Заполнение массива объектами класса Patient
        patients[0] = new Patient("Smith", "Male", 35);
        patients[1] = new Patient("Johnson", "Female", 28);
        patients[2] = new Patient("Williams", "Male", 42);
        patients[3] = new Patient("Brown", "Female", 31);
        patients[4] = new Patient("Jones", "Male", 39);
        patients[5] = null;
        patients[6] = new Patient(); // Объект созданный конструктором по умолчанию
        patients[7] = new Patient("Davis", "Male", 37);
        patients[8] = new Patient("Miller", "Female", 29);
        patients[9] = new Patient("Wilson", "Male", 45);

        // Упорядочивание массива по возрастанию целочисленных параметров и строковых
        Arrays.sort(patients, (p1, p2) -> {
            if (p1 != null && p2 != null) {
                if (p1.getAge() != p2.getAge()) {
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    return p1.getLastName().compareToIgnoreCase(p2.getLastName());
                }
            } else {
                return p1 == null ? -1 : 1;
            }
        });

        // Вывод массива три раза
        for (int i = 0; i < 3; i++) {
            System.out.println("Array " + (i + 1) + ":");
            for (Patient patient : patients) {
                if (patient != null) {
                    System.out.println("Last Name: " + patient.getLastName() + ", Gender: " + patient.getGender() + ", Age: " + patient.getAge());
                } else {
                    System.out.println("null");
                }
            }
            System.out.println();
        }

        // Подсчет среднего возраста и количества женщин
        Patient patientObj = new Patient();
        double averageAge = patientObj.calculateAverageAge(patients);
        int femaleCount = patientObj.countFemalePatients(patients);

        System.out.println("Average Age: " + averageAge);
        System.out.println("Female Count: " + femaleCount);
    }
}
