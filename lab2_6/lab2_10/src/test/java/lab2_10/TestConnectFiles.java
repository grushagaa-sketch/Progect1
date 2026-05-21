package lab2_10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConnectFiles {
    static final String FILE1 = "test_file1.txt";
    static final String FILE2 = "test_file2.bin";
    static final String FILE3 = "test_result.dat";


    @BeforeAll
    public static void init() throws IOException {
        // подготовка данных для тестирования
        new FileOutputStream(FILE1).write("wezrxytcugihopk".getBytes());
        new FileOutputStream(FILE2).write(new byte[]{1,2,7,5,8});

        try(FileInputStream fis1 = new FileInputStream(FILE1);
            FileInputStream fis2 = new FileInputStream(FILE2);
            FileOutputStream fos3 = new FileOutputStream(FILE3)) {
            int b;
            while ((b=fis1.read())!=-1) fos3.write(b);
            while ((b=fis2.read())!=-1) fos3.write(b);
        }
    }

    @Test
    public void testSize() {
        //проверка размера
        long size1=new File(FILE1).length();
        long size2=new File(FILE2).length();
        long size3=new File(FILE3).length();
        assertEquals(size3,size1+size2);
    }

    @Test
    public void testFirstPart() throws IOException {
        //совпадения 1 файла и 1 части 3 файла

        byte[] first;
        try (FileInputStream fis1 = new FileInputStream(FILE1)) {
            first = new byte[fis1.available()];
            fis1.read(first);
        }

        byte[] part;
        try (FileInputStream fis3 = new FileInputStream(FILE3)) {
            part = new byte[first.length];
            fis3.read(part);
        }
        assertArrayEquals(first,part);
    }
}
