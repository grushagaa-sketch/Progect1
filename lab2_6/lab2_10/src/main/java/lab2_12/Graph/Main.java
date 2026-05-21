package lab2_12.Graph;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start = new Date().getTime();

        Thread[] works = new Thread[12];
        works[0]= new Thread(new TaskWork(1,null));
        works[1]= new Thread(new TaskWork(2,null));
        works[2]= new Thread(new TaskWork(3,new Thread[]{works[0]}));
        works[3]= new Thread(new TaskWork(4,new Thread[]{works[0]}));
        works[4]= new Thread(new TaskWork(5,new Thread[]{works[1]}));
        works[5]= new Thread(new TaskWork(6,new Thread[]{works[1]}));
        works[6]= new Thread(new TaskWork(7,new Thread[]{works[1]}));
        works[7]= new Thread(new TaskWork(8,new Thread[]{works[3], works[4]}));
        works[8]= new Thread(new TaskWork(9,new Thread[]{works[2], works[7]}));
        works[9]= new Thread(new TaskWork(10,new Thread[]{works[6]}));
        works[10]= new Thread(new TaskWork(11,new Thread[]{works[5], works[8]}));
        works[11]= new Thread(new TaskWork(12,new Thread[]{works[9], works[10]}));

        for (Thread th: works) {
            th.start();
        }
        for (Thread th: works) {
            th.join();
        }

        Long end = new Date().getTime();
        System.out.println((end-start)/1000.);

    }

}
