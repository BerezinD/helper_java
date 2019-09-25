package basic.data.structures;

import java.util.Arrays;

public class ArrayExample {
    private Integer[] array;

    ArrayExample() {
    }

    ArrayExample(Integer... numbers) {
        this.array = Arrays.copyOf(numbers, numbers.length);
    }

    public Integer[] oddsArray(int maxCount) {
        if (maxCount < 1 || maxCount >= Integer.MAX_VALUE) {
            return new Integer[0];
        }
        final int middle = maxCount / 2;
        final Integer[] resultArray = new Integer[middle];
        int oddNumber = 0;
        for (int i = 0; i < middle; i++) {
            oddNumber += 2;
            resultArray[i] = oddNumber;
        }
        return resultArray;
    }

    public boolean deleteByIndex(int index) {
        if (index < 0 || index > array.length) {
            return false;
        } else {
            Integer[] result = new Integer[array.length - 1];
            int newIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    result[newIndex] = array[i];
                    newIndex++;
                }
            }
            array = result;
            return true;
        }
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }
}
