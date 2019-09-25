package basic.data.structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayExampleTest {

    private Integer[] testingArray;

    @BeforeEach
    void setUp() {
        testingArray = new Integer[10];
        testingArray = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20).toArray(Integer[]::new);
    }

    @AfterEach
    void tearDown() {
        testingArray = null;
    }


    @Test
    void oddsArrayTest() {
        ArrayExample testClassForArray = new ArrayExample();

        testClassForArray.setArray(testClassForArray.oddsArray(20));
        assertArrayEquals(testingArray, testClassForArray.getArray());

        testClassForArray.getArray()[0] = 0;
        assertNotEquals(testingArray, testClassForArray.getArray());

        testClassForArray = new ArrayExample(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        assertArrayEquals(testingArray, testClassForArray.getArray());

        boolean delete = testClassForArray.deleteByIndex(0);
        assertTrue(delete);
        assertArrayEquals(Stream.of(4, 6, 8, 10, 12, 14, 16, 18, 20).toArray(Integer[]::new), testClassForArray.getArray());
    }
}