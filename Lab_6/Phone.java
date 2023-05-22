class Phone implements Comparable<Phone> {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallTime;
    private double longDistanceCallTime;

    public Phone(int id, String lastName, String firstName, String middleName, String address, String creditCardNumber,
                 double debit, double credit, double localCallTime, double longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallTime = localCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public double getLocalCallTime() {
        return localCallTime;
    }

    public double getLongDistanceCallTime() {
        return longDistanceCallTime;
    }

    @Override
    public int compareTo(Phone otherPhone) {
        return this.lastName.compareTo(otherPhone.lastName);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Last Name: " + lastName + "\n" +
                "First Name: " + firstName + "\n" +
                "Middle Name: " + middleName + "\n" +
                "Address: " + address + "\n" +
                "Credit Card Number: " + creditCardNumber + "\n" +
                "Debit: " + debit + "\n" +
                "Credit: " + credit + "\n" +
                "Local Call Time: " + localCallTime + "\n" +
                "Long Distance Call Time: " + longDistanceCallTime + "\n";
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getId() {
        return id;
    }

    public double getDebit() {
        return debit;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public double getCredit() {
        return credit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}