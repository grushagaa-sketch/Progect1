package a04_04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileWriter {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("test.txt");

            String mes = "Привет!";
            byte[] data = mes.getBytes("UTF-8");

            os.write(data);

            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
