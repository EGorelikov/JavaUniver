class Patient {
    private String surname;
    private String gender;
    private int age;

    public Patient(String surname, String gender, int age) {
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}