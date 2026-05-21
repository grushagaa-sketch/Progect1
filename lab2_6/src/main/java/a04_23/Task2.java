package a04_23;

import java.io.*;

//2. Прочитать текст из файла с помощью FileReader, если слово начинается
//с буквы А и заканчивается буквой Н, то перевести его в верхний регистр,
//результат записать с помощью FileWriter в новый файл
//   (использовать метод mark(30) и reset())
public class Task2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("transport.csv"));
             FileWriter fw = new FileWriter("Task2out.txt")) {

            boolean start=true;
            boolean inword=false;
            int cnt=0;
            while (true) {
                char c  = (char)br.read();
                if (start && (c=='А'||c=='а')) {
                    br.mark(30);//зафиксировали позицию, через 30 символов она пропадет
                    start = false;
                    inword=true;
                    cnt++;

                } else if (start) {
                    start=false;
                    fw.write(c);
                } else if (c==' ') {
                    inword=false;
                    start=true;
                    fw.write(c);
                } else if (inword && (c=='Н' || c=='н')) {
                    br.reset();
                    char[] massiv = new char[cnt];
                    br.read(massiv);
                    fw.write(new String(massiv).toUpperCase());
                    inword=false;
                    cnt=0;
                } else if(inword) {
                    cnt++;
                } else {
                    fw.write(c);
                }
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
