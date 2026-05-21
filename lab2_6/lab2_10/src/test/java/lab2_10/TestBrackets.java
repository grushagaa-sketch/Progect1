package lab2_10;

//3. Написать метод, считывающий файл JSON (имя файла передается через аргумент),
// и определяющий корректность расставленных скобок {{}}, [] возвращает 0,
// если все правильно, или позицию проблемы (начиная с 1)
//Метод должен бросать исключения
//NullPointer если передали пустое имя файла
//Исключение, если файл не найден,
//Исключение, если файл не текстовый (проверка на буквы, цифры, знаки препинания)
//
//метод 3 задания протестировать на все исключения и на корректность работы

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestBrackets {

    @BeforeAll
    public static void init() throws IOException {
        Files.write(Paths.get("brackets_test1.txt"), "[{()}".getBytes());
        Files.write(Paths.get("brackets_test2.txt"), "ezsryxd(vghkbj)[ufcgkv],()  ".getBytes());
        Files.write(Paths.get("brackets_test3.txt"), "({)}".getBytes());
        Files.write(Paths.get("brackets_test4.txt"), "[]]]".getBytes());
    }



    @ParameterizedTest
    @CsvSource({
            "'brackets_test1.txt', 4",
            "'brackets_test2.txt', 0",
            "'brackets_test3.txt', 2",
            "'brackets_test4.txt', 2"
    })
    public void testCorrectJson(String str, int expectedRes) throws IOException {
        int res = Brackets.correctJson(str);
        Assertions.assertEquals(expectedRes, res);
    }

    @Test
    public void testFileNotFoundException() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> Brackets.correctJson("несуществующий_файл.txt"));
    }

    @Test
    public void testNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> Brackets.correctJson(null));
    }

    @Test
    public void testNotTextFileException() {
        Assertions.assertThrows(NotTextFileException.class,
                () -> Brackets.correctJson("нетекстовый_файл.txt"));
    }

}
