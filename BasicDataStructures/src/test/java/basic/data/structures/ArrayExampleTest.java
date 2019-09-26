package basic.data.structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayExampleTest {

    private Integer[] testingArray;
    private ArrayExample testClassForArray;

    @BeforeEach
    void setUp() {
        testingArray = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20).toArray(Integer[]::new);
        testClassForArray = new ArrayExample();
    }

    @AfterEach
    void tearDown() {
        testingArray = null;
        testClassForArray = null;
    }

    @Test
    void oddsArrayTest() {
        testClassForArray.setArray(testClassForArray.oddsArray(20));
        assertArrayEquals(testingArray, testClassForArray.getArray());

        testClassForArray.getArray()[0] = 0;
        assertNotEquals(testingArray, testClassForArray.getArray());
    }

    @Test
    void deleteByIndexTest() {
        testClassForArray = new ArrayExample(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);

        boolean delete = testClassForArray.deleteByIndex(0);
        assertTrue(delete);
        assertArrayEquals(Stream.of(4, 6, 8, 10, 12, 14, 16, 18, 20).toArray(Integer[]::new), testClassForArray.getArray());
    }

    @Test
    void arrayIsLinkedTypeTest() {
        // here we got two arrays:
        //      first - simple array (just array of odds numbers itself)
        //      second - array inside class. Empty for now.
        testClassForArray.setArray(new Integer[]{1, 2, 3});
        // now, if I set one array to another and change some value inside, this affected both.
        testClassForArray.setArray(testingArray);
        assertEquals(2, testClassForArray.getArray()[0]);
        testingArray[0] = 100;
        assertEquals(100, testClassForArray.getArray()[0]);
        // but, if I set to testingArray another array (or null), that will not affected array inside our class
        testingArray = null;
        assertEquals(100, testClassForArray.getArray()[0]);

        // but when we use Arrays.copyOf(), we create another object witch not depends on previous one.
        testingArray = Arrays.copyOf(testClassForArray.getArray(), testClassForArray.getArray().length);
        testingArray[0] = 500;
        assertEquals(100, testClassForArray.getArray()[0]);
    }

    @Test
    void getArrayTest() {
        testClassForArray = new ArrayExample(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        assertArrayEquals(testingArray, testClassForArray.getArray());
    }

    @Test
    void setArrayTest() {
        testClassForArray.setArray(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
        assertArrayEquals(testingArray, testClassForArray.getArray());
    }
}