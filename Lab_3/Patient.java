import java.io.Serializable;

// Класс Patient (пациент)
class Patient implements Serializable {
    private String lastName;
    private String gender;
    private int age;

    public Patient(String lastName, String gender, int age) {
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
