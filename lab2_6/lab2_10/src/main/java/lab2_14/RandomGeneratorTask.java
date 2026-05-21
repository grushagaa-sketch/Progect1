package lab2_14;

public class RandomGeneratorTask extends Thread {
    int max;
    boolean isStopped;
    int i;

    public RandomGeneratorTask() {
        this.max=1000;
        this.isStopped=false;
        this.i=1;
    }


    @Override
    public void run() {
        //бесконечный цикл от 1 до макс(1000) (закольцевать)
        //между итерациями пауза 500 миллисекунд
        while(!isStopped) {
            synchronized (this) {
                if (i>=max) i=1;
            }
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public int get() {
        return i;
    }


    public void setMax(int a) {
        this.max=a;
    }


    public void stop_thread() {
        this.isStopped=true;
    }
}
