package a04_23;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;


//1. Используя PrintWriter и ByteArrayOutputStream сформировать
//массив байт, содержащий текст из нескольких строчек.
//Получить массив и записать его в файл в кодировке cp1251
public class Task1 {
    public static void main(String[] args) {
        String text = "nvjkfnvakdnvkqjfnpjqr\nlfjn qpjbn[qib spijnb[irnj \ndpjfb[qij]";
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PrintWriter pw = new PrintWriter(bos, true, Charset.forName("cp1251"));
            FileOutputStream fos = new FileOutputStream("task1.txt")) {

            pw.write(text);
            pw.flush();

            byte[] array = bos.toByteArray();

            fos.write(array);
            fos.flush();//сброс всех буфферов

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
