package lab2_11.Integral;

public class Integral implements Runnable {
    private int thread_number;
    private double a;
    private double b;
    private int pices_cnt;
    private static double[] thread_results = new double[13];
    private static long[] thread_times = new long[13];


    public Integral(int thread_number,double a, double b, int pices_cnt) {
        this.thread_number=thread_number;
        this.a=a;
        this.b=b;
        this.pices_cnt=pices_cnt;

    }

    public static void write_results(int thread_number, double res, long time) {
        thread_results[thread_number] = res;
        thread_times[thread_number] = time;
    }

    private static double func(double x) {
        return x * Math.pow((Math.E), -2*Math.PI*x);
    }

    private double summ(double a, double b, int pices_cnt) {
        double result = 0;
        double h = (b-a)/(double)pices_cnt;
        for (int i = 0; i<pices_cnt; i++) {
            result += func(a+i*h+h/2) *h;
        }

        return result;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();

        double res = summ(a, b, pices_cnt);
        //System.out.println(res);

        long endTime = System.nanoTime();
        long time = endTime - startTime;

        write_results(thread_number,res, time);

        //System.out.println("Время выполнения в наносекундах: " + time);
    }

    public static double[] getThread_results() {
        return thread_results;
    }

    public static long[] getThread_times() {
        return thread_times;
    }
}
