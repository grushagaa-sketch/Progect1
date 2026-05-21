package lab2_14;

import java.util.Scanner;

public class ConsolInputTask extends Thread {
    private final RandomGeneratorTask randomGeneratorTask;
    boolean isStopped;

    public ConsolInputTask(RandomGeneratorTask randomGeneratorTask) {
        this.randomGeneratorTask = randomGeneratorTask;
        this.isStopped=false;
    }

    public void run() {
        randomGeneratorTask.start();
        Scanner scanner= new Scanner(System.in);
        while (!isStopped) {
            System.out.println("введите действие(get/max/stop): ");
            String action = scanner.nextLine();
            switch (action) {
                case "get": {
                    System.out.println(randomGeneratorTask.get());
                    break;
                }

                case "max": {
                    System.out.println("введите максимальное значение: ");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    synchronized (randomGeneratorTask) {
                        randomGeneratorTask.setMax(value);
                    }
                    break;}

                case "stop": {
                    scanner.close();
                    System.out.println("сеанс завершен");
                    isStopped=true;
                    randomGeneratorTask.stop_thread();
                    break;}

                default:
                    System.out.println("вы ввели некорректное действие");
            }
        }
    }
}
