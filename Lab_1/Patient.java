class Patient {
    private String lastName;
    private String gender;
    private int age;

    public Patient() {
        this.lastName = "";
        this.gender = "";
        this.age = 0;
    }

    public Patient(String lastName, String gender, int age) {
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public double calculateAverageAge(Patient[] patients) {
        int sum = 0;
        int count = 0;

        for (Patient patient : patients) {
            if (patient != null) {
                sum += patient.age;
                count++;
            }
        }

        return (double) sum / count;
    }

    public int countFemalePatients(Patient[] patients) {
        int femaleCount = 0;

        for (Patient patient : patients) {
            if (patient != null && patient.gender.equalsIgnoreCase("female")) {
                femaleCount++;
            }
        }

        return femaleCount;
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
}

