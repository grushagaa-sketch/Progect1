package lab2_12;

// в параллельных потоках произвести вычисления, затем все полученные результаты суммировать

public class TaskSumm implements Runnable {

    @Override
    public void run() {
        double sum = 0;
        int n = 1;

        for (double i = 1; i < 1000000; ++i) {
            sum += i / n;
            n *= i;

        }
        MainSumm.add(sum);
        System.out.println(Thread.currentThread().threadId()+" : " + sum);


    }
}
