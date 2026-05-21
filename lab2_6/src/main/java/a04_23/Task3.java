package a04_23;


import java.io.*;
import java.nio.charset.Charset;

//3. Строку преобразовать в массив байт, на базе этого массива создать ByteArrayInputStream,
//на базе этого объекта сформировать InputStreamReader, в цикле считать и распечатать все символы
public class Task3 {
    public static void main(String[] args) {
        String text = "nvjkfnvakdnvkqjfnpjqr\nlfjn qpjbn[qib spijnb[irnj \ndpjfb[qij]";
        try (ByteArrayInputStream bis = new ByteArrayInputStream(text.getBytes());
             InputStreamReader reader = new InputStreamReader(bis)) {

            int r = 0;
            while ((r = reader.read())!=-1) {
                System.out.print((char)r);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
