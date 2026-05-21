package a04_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestUTFFileReader {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("bookings.json");

            int r;
            while ((r = is.read()) != -1) {
                //вытаскиваем первый бит
                if ((r&128)==0) {//побитовая конъюнкция
                    //значит первый бит 0
                    //символ состоит из одного байта
                    System.out.print((char) r);
                } else if ((r & 192) == 192) {
                    //символ состоит из двух байт
                    //читаем второй байт
                    int r2 = is.read();
                    int c = ((r&0x1F) << 6) | (r2 & 0x3F);
                    System.out.print((char) c);


                }

            }


            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

}
