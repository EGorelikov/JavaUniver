import java.util.Scanner;

class CalculatorThread extends Thread {
    private int start;
    private int end;
    private int step;
    private int operation;
    private int result;

    public CalculatorThread(int start, int end, int step, int operation) {
        this.start = start;
        this.end = end;
        this.step = step;
        this.operation = operation;
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i += step) {
            if (i % 4 == 0) {
                switch (operation) {
                    case 1:
                        result += i; // сложение
                        break;
                    case 2:
                        result -= i; // вычитание
                        break;
                    case 3:
                        result *= i; // умножение
                        break;
                }
            }
        }
    }
}

class ThreadGenerator {
    private int numThreads;
    private int operation;
    private int startRange;
    private int endRange;

    public ThreadGenerator(int numThreads, int operation, int startRange, int endRange) {
        this.numThreads = numThreads;
        this.operation = operation;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void execute() throws InterruptedException {
        CalculatorThread[] threads = new CalculatorThread[numThreads];
        int rangePerThread = (endRange - startRange + 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int threadStart = startRange + i * rangePerThread;
            int threadEnd = (i == numThreads - 1) ? endRange : threadStart + rangePerThread - 1;

            threads[i] = new CalculatorThread(threadStart, threadEnd, 1, operation);
            threads[i].start();
        }

        for (CalculatorThread thread : threads) {
            thread.join();
        }
    }

    public int getResult() {
        int finalResult = 0;

        for (CalculatorThread thread : threads) {
            finalResult += thread.getResult();
        }

        return finalResult;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число a: ");
        int a = scanner.nextInt();

        System.out.print("Введите количество потоков: ");
        int numThreads = scanner.nextInt();

        System.out.println("Выберите операцию (1 - сложение, 2 - вычитание, 3 - умножение): ");
        int operation = scanner.nextInt();

        System.out.print("Введите начало числового интервала: ");
        int startRange = scanner.nextInt();

        System.out.print("Введите конец числового интервала: ");
        int endRange = scanner.nextInt();

        ThreadGenerator threadGenerator = new ThreadGenerator(numThreads, operation, startRange, endRange);

        try {
            threadGenerator.execute();
            int result = threadGenerator.getResult();
            System.out.println("Итоговый результат: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}