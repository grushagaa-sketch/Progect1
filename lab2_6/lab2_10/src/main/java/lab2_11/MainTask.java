package lab2_11;

public class MainTask {
    public static void main(String[] args) throws InterruptedException {
        //оценим возможности нашей вычислительной системы
        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("колво виртуальных ядер: "+countProc);

        //создаем несколько экземпляров задач
        TaskThread tt1 = new TaskThread("соо для потока 1");
        TaskThread tt2 = new TaskThread("соо для потока 2");
        TaskThread tt3 = new TaskThread("соо для потока 3");

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
