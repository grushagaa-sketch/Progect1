package lab2_12;

public class MainSumm {
    public static double summ = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread task1 = new Thread(new TaskSumm());
        Thread task2 = new Thread(new TaskSumm());
        Thread task3 = new Thread(new TaskSumm());
        Thread task4 = new Thread(new TaskSumm());

        task1.start();
        task2.start();
        task3.start();
        task4.start();

        //останавливаем main до завершения всех task
        task1.join();
        task2.join();
        task3.join();
        task4.join();

        System.out.println("сумма " + summ);
    }

    public synchronized static void add(double innerSum) {
        summ += innerSum;
    }
}