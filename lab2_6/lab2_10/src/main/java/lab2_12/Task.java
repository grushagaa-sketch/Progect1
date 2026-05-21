package lab2_12;

import java.io.IOException;
import java.io.Writer;

public class Task implements Runnable {
    private String message;
    private Object mutex;
    private Writer writer;

    public Task(String message, Object mutex, Writer writer) {
        //super();
        this.message = message;
        this.mutex=mutex;
        this.writer = writer;
    }

    //метод, запускаемый в отдельном потоке
    @Override
    public void run() {
        try {
            filePrint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        print();
    }

    //private synchronized void print() = synchronized(this) {...

    //необходимо обеспечить ионопольный доступ к консоли на время выполнения функции
    private void print() {

        //какие-то вычисления

        //synchronized (mutex) {
        synchronized (Task.class) {
            //этим блоком смоет управлять только один поток
            //захватываем mutex
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
            }
            System.out.println();
            //освобождаем mutex
        }
    }

    private void filePrint() throws IOException {

        //печатаем в файл

        synchronized (mutex) {
        //synchronized (Task.class) {
            //этим блоком смоет управлять только один поток
            //захватываем mutex
            for (int i = 0; i < message.length(); i++) {
                writer.write(message.charAt(i));
            }
            writer.write('\n');
        }
    }
}
