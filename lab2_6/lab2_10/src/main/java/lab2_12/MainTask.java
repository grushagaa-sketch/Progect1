package lab2_12;

import lab2_11.TaskThread;

import java.io.FileWriter;
import java.io.IOException;

public class MainTask {
    public static void main(String[] args) throws InterruptedException, IOException {
        //оценим возможности нашей вычислительной системы
        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("количество виртуальных ядер: " + countProc);

        Object mutex = new Object();

        try (FileWriter writer = new FileWriter("message.txt")) {

            //создаем несколько экземпляров задач
            Thread tt1 = new Thread(new Task("соо для потока 1", mutex, writer));
            Thread tt2 = new Thread(new Task("соо для потока 2", mutex, writer));
            Thread tt3 = new Thread(new Task("соо для потока 3", mutex, writer));

            //запуск задач в параллельных потоках start, неявный вызов run
            tt1.start();
            tt2.start();
            tt3.start();
            //следующая строка начинает выполняться сразу после старта
            System.out.println("запустили 3 потока");

            //ждем их выполнения
            tt1.join();
            tt2.join();
            tt3.join();
            System.out.println("все задачи выполнены");
        }
    }
}
