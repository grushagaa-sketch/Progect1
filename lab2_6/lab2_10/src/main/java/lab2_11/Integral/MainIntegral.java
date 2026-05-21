package lab2_11.Integral;

public class MainIntegral {
    public static void main(String[] args) throws InterruptedException {
        double a = 0;
        double b = 100;
        int pices_cnt=1000000;
        int n = 12;
        double step = (b - a) / n;

        Thread th = new Thread(new Integral(0,a, b, pices_cnt));
        th.start();
        th.join();


        Thread[] threads = new Thread[12];

        for (int i = 0; i < n; i++) {

            double left = a + i * step;
            double right = left + step;
            int parts = pices_cnt / n;

            threads[i] = new Thread(new Integral(i+1, left, right, parts));
        }


        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }

        double[] results = Integral.getThread_results();
        long[] times = Integral.getThread_times();


        double integral1 = results[0];
        double integral12 = 0;

        long time1 = times[0];
        long time12 = 0;
        for (int i=1; i<n+1; i++) {
            integral12+=results[i];
            time12+=times[i];
        }

        System.out.println(integral1);
        System.out.println(integral12);

        System.out.println(time1);
        System.out.println(time12);
    }
}
