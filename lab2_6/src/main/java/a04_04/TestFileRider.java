package a04_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileRider {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("bookings.json");

            byte[] buffer = new byte[1024];//сколько максимально за раз хотим прочитать
            int r;//количество реально прочитанных байт
            while ((r = is.read(buffer)) != -1) {
                //сторим строку из массива, указываем какую его часть надо взять
                String str = new String(buffer,0,r, "UTF-8");
                System.out.print(str);
            }


            is.close();
        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден");
        }  catch(IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
