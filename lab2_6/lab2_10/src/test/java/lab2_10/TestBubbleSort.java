package lab2_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestBubbleSort {

    @ParameterizedTest
    // @CsvFileSource(files = "test_data.csv")
    @CsvSource({
            "'5,2,8,1,9', '1,2,5,8,9'",
            "'5,4,3,2,1', '1,2,3,4,5'",
            "'1,2,3', '1,2,3'"
    }) // порядок аргументов в сигнатуре должен соответсвовать набору данных
    public void testSort(String expectedStr, String inputStr) {
        int[] input = parseArray(inputStr);
        int[] expected = parseArray(inputStr);
        BubbleSort.sort(input);
        Assertions.assertArrayEquals(expected, input);
    }

    private int[] parseArray(String str) {
        String[] a = str.split(",");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i].trim());
        }
        return arr;
    }

}
