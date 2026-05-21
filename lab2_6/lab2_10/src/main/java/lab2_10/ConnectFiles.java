package lab2_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConnectFiles {
        public static void connect(String file1, String file2, String result) throws IOException {
            try (FileInputStream fis1 = new FileInputStream(file1);
                 FileInputStream fis2 = new FileInputStream(file2);
                 FileOutputStream fos = new FileOutputStream(result)) {

                // Копируем первый файл
                int a;
                while ((a = fis1.read()) != -1) {
                    fos.write(a);
                }

                // Копируем второй файл
                while ((a = fis2.read()) != -1) {
                    fos.write(a);
                }
            }
        }

        public static void main(String[] args) throws IOException {
            File f1 = new File("file1.txt");
            File f2 = new File("file2.bin");
            File f3 = new File("result.dat");

            try (FileOutputStream fos1 = new FileOutputStream(f1)) {
                fos1.write("hello world".getBytes());
            }
            try (FileOutputStream fos2 = new FileOutputStream(f2)) {
                fos2.write(new byte[]{1,2,3,4,5,6,7,8,9});
            }


            connect("file1.txt", "file2.bin", "result.dat");
            System.out.println("готово");
        }

}
