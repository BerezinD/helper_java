package basic.data.structures;

public class ArrayExample {
    private Integer[] arrayOfNumbers;

    public Integer[] oddsArray(int maxCount) {
        if (maxCount < 1 || maxCount >= Integer.MAX_VALUE) {
            return new Integer[0];
        }
        final int middle = maxCount/2;
        final Integer[] resultArray = new Integer[middle];
        int oddNumber = 0;
        for (int i=0; i < middle; i++) {
            oddNumber += 2;
            resultArray[i] = oddNumber;
        }
        return resultArray;
    }

    public Integer[] getArrayOfNumbers() {
        return arrayOfNumbers;
    }

    public void setArrayOfNumbers(Integer[] arrayOfNumbers) {
        this.arrayOfNumbers = arrayOfNumbers;
    }
}
