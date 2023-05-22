package by.gsu.pms;

import by.gsu.pms.ExpenseStat;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    private static final List<String> ACCOUNT_NAMES = List.of(
        "Kevin Parcel",
        "David Pratt",
        "Bertram Reynolds",
        "Julian Rice",
        "Claire Richard",
        "Jonathan Snellgrove",
        "David Warner",
        "Antony Wilkinson",
        "Amy Williams",
        "Andrew Wood",
        "Simon Wood",
        "Jeremy Wright");

    public static void main(String[] args) {
        var stats = makeRandomStats(ACCOUNT_NAMES, 7);

        for (var stat : stats) {
            if (stat != null) {
                stat.show();
                System.out.println();
            }
        }

        System.out.println("Setting transportation expenses on the last item...");
        stats.get(stats.size() - 1).setTransportationExpenses(666);
        System.out.println();

        System.out.println("Duration = " + (stats.get(0).getDayCount() + stats.get(1).getDayCount()));
        System.out.println();

        for (var stat : stats) {
            if (stat != null) {
                System.out.println(stat.toString());
            }
        }
        System.out.println();

        var totalExpensesSum = getTotalExpensesSum(stats);
        System.out.println("Total expenses sum = " + totalExpensesSum);
        System.out.println();

        var maxTotalExpensesAccountName = getMaxTotalExpensesAccountName(stats);
        System.out.println("Account with greatest total expenses: " + maxTotalExpensesAccountName);
        System.out.println();
    }

    private static String getMaxTotalExpensesAccountName(List<ExpenseStat> stats) {
        return stats.stream()
            .filter(stat -> stat != null)
            .max(Comparator.comparingInt(stat -> stat.getTotal()))
            .get()
            .getAccountName();
    }

    private static int getTotalExpensesSum(List<ExpenseStat> stats) {
        return stats.stream()
            .filter(stat -> stat != null)
            .map(stat -> stat.getTotal())
            .reduce((acc, value) -> acc + value)
            .get();
    }

    private static List<ExpenseStat> makeRandomStats(List<String> accountNames, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count may not be negative");
        }

        var random = makeRandom();

        var rates = getRandomInts(random, 100, 2000, count);
        var shuffledAccountNames = getShuffledList(random, accountNames, count);
        var expenses = getRandomInts(random, 0, 2000, count);
        var dayCounts = getRandomInts(random, 2, 31, count);

        var stats = new ArrayList<ExpenseStat>(count);
        for (int i = 0; i < count; i++) {
            if (i == 2) {
                stats.add(null);
            } else if (i == count - 1) {
                stats.add(new ExpenseStat());
            } else {
                stats.add(new ExpenseStat(
                    rates.get(i),
                    shuffledAccountNames.get(i),
                    expenses.get(i),
                    dayCounts.get(i)));
            }
        }

        return stats;
    }

    private static List<Integer> getRandomInts(Random random, int origin, int bound, int count) {
        if (origin >= bound) {
            throw new IllegalArgumentException("Origin may not be greater than or equal to bound");
        }
        var list = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(origin, bound));
        }
        return list;
    }

    private static <T> List<T> getShuffledList(Random random, List<T> list, int count) {
        if (count > list.size()) {
            throw new IllegalArgumentException("Count may not exceed list size");
        }
        if (count < 0) {
            throw new IllegalArgumentException("Count may not be negative");
        }
        var shuffledIndices = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            int shuffledIndex = getRandomIntUntil(random, 0, count, x -> !shuffledIndices.contains(x));
            shuffledIndices.add(shuffledIndex);
        }
        var shuffledItemsList = new ArrayList<>(List.copyOf(list));
        for (int i = 0; i < count; i++) {
            shuffledItemsList.set(i, list.get(shuffledIndices.get(i)));
        }
        return shuffledItemsList;
    }

    private static int getRandomIntUntil(Random random, int origin, int bound, Predicate<Integer> condition) {
        if (origin >= bound) {
            throw new IllegalArgumentException("Origin may not be greater than or equal to bound");
        }
        int i;
        do {
            i = random.nextInt(origin, bound);
        } while (!condition.test(i));
        return i;
    }

    private static Random makeRandom() {
        return new Random(makeSeedFromCurrentTime());
    }

    private static long makeSeedFromCurrentTime() {
        return System.currentTimeMillis();
    }
}