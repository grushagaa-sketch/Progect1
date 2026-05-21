package lab2_12.Graph;

public class TaskWork implements Runnable {
    private Thread[] dependencies;
    private int work_number;

    public TaskWork(int work_number, Thread[] dependencies) {
        this.dependencies = dependencies;
        this.work_number=work_number;
    }

    @Override
    public void run() {
        //дождаться окончания выполнения задач от которых зависим
        try {
            if (dependencies != null) {
                for (Thread thread : dependencies) {
                    thread.join();

                }
            }
            work();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void work() throws InterruptedException {
        System.out.println("начата работа "+work_number);
        //симулируем работу
        Thread.sleep(1000);
        System.out.println("завершена работа "+work_number);

    }
}

