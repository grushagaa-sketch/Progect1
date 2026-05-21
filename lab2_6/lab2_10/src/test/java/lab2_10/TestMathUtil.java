package lab2_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMathUtil {

    static MathUtil mathUtil;

    @BeforeAll
    public static void init() {
        // подготовка данных для тестирования
        mathUtil = new MathUtil();
    }


    @Test
    public void testSum() {
        Assertions.assertEquals(2, mathUtil.sum(1,1));
    }

    @ParameterizedTest
    // @CsvFileSource(files = "test_data.csv")
    @CsvSource({
            "5,    10,   2", // 1-й набор аргументов
            "1,    2,   2", // 2-й набор аргументов
            "0,  1, 100",  // 3-й набор аргументов
            "0,  0, 101",  // 4-й набор аргументов
            "-8,  16, -2"  // 5-й набор аргументов
    }) // порядок аргументов в сигнатуре должен соответсвовать набору данных
    public void testDivide(int expected, int a, int b) {
        Assertions.assertEquals(expected, MathUtil.divide(a,b));
    }

    @Test
    public void testDivideException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MathUtil.divide(10,0));
    }

    @Test
    public void testSort() {
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5},
                MathUtil.sort(new int[] {1,2,3,4,5}));
    }
}
