package by.gsu.pms;

public class ExpenseStat {
    private static final String MISSING_ACCOUNT_NAME = "missing";

    private int dailyAllowanceRate;
    private String accountName;
    private int transportationExpenses;
    private int dayCount;

    public ExpenseStat() {
        this(0, null, 0, 0);
    }

    /**
     * @param dailyAllowanceRate
     * @param accountName            may be null.
     * @param transportationExpenses
     * @param dayCount
     */
    public ExpenseStat(
        int dailyAllowanceRate,
        String accountName,
        int transportationExpenses,
        int dayCount
    ) {
        setDailyAllowanceRate(dailyAllowanceRate);
        setAccountName(accountName);
        setTransportationExpenses(transportationExpenses);
        setDayCount(dayCount);
    }

    public int getDailyAllowanceRate() {
        return this.dailyAllowanceRate;
    }

    public void setDailyAllowanceRate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Daily allowance rate may not be negative");
        }
        this.dailyAllowanceRate = value;
    }

    /**
     * @return account name, may be null.
     */
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * @param value may be null.
     */
    public void setAccountName(String value) {
        if (value == null) {
            this.accountName = null;
            return;
        }
        this.accountName = value.trim();
    }

    public int getTransportationExpenses() {
        return this.transportationExpenses;
    }

    public void setTransportationExpenses(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Transported expenses may not be negative");
        }
        this.transportationExpenses = value;
    }

    public int getDayCount() {
        return this.dayCount;
    }

    public void setDayCount(int value) {
        if (dayCount < 0) {
            throw new IllegalArgumentException("Day count may not be negative");
        }
        this.dayCount = value;
    }

    public int getTotal() {
        return this.transportationExpenses
            + this.dailyAllowanceRate
            * this.dayCount;
    }

    public void show() {
        System.out.println("rate = " + getDailyAllowanceRate() + '\n' +
            "account = " + getAccountNameOrMissing() + '\n' +
            "transport = " + getTransportationExpenses() + '\n' +
            "days = " + getDayCount() + '\n' +
            "total = " + getTotal()
        );
    }

    @Override
    public String toString() {
        return String.valueOf(getDailyAllowanceRate()) +
            ';' +
            getAccountNameOrMissing() +
            ';' +
            getTransportationExpenses() +
            ';' +
            getDayCount() +
            ';' +
            getTotal();
    }

    private String getAccountNameOrMissing() {
        return this.accountName == null
            ? MISSING_ACCOUNT_NAME
            : this.accountName;
    }
}
