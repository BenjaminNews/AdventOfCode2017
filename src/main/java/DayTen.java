import java.util.Arrays;
import java.util.stream.IntStream;

public class DayTen {

    private int[] memoryValues;
    private int[] flipValues;
    private int[] reverseArray;

    private int index = 0;
    private int skipSize = 0;

    public DayTen (int memoryValues, String flipValues, String splitterator) {
        this.memoryValues = IntStream.range(0, memoryValues).toArray();
        this.flipValues = Arrays.stream(flipValues.split(splitterator)).mapToInt(Integer::parseInt).toArray();
    }

    public int twist() {
        for(int flipValue : flipValues) {
            if (index + flipValue < memoryValues.length) {
                reverseArrayWhichExistsWithoutWrap(flipValue);
            } else {
                reverseArrayWhichWraps(flipValue);
            }

            index = index + flipValue + skipSize++;

            if (index > memoryValues.length) {
                index = index - memoryValues.length;
            }
        }
        return memoryValues[0] * memoryValues[1];
    }

    private void reverseArrayWhichExistsWithoutWrap(int flipValue) {
        reverseArray = Arrays.copyOfRange(memoryValues, index, index + flipValue);
        reverseTheArray();
        updateValues();
    }

    private void reverseArrayWhichWraps(int flipValue) {
        int endPositionOfWrap = (index + flipValue) - memoryValues.length;
        getWrappedArrayContents(flipValue, endPositionOfWrap);
        reverseTheArray();
        updateValues();
    }

    private void getWrappedArrayContents(int flipValue, int endPositionOfWrap) {
        int[] startOfArrayToTwist = Arrays.copyOfRange(memoryValues, index, memoryValues.length);
        int[] endOfArrayToTwist = Arrays.copyOfRange(memoryValues, 0, endPositionOfWrap);
        reverseArray = new int[flipValue];
        System.arraycopy(startOfArrayToTwist, 0, reverseArray, 0, startOfArrayToTwist.length);
        System.arraycopy(endOfArrayToTwist, 0, reverseArray, startOfArrayToTwist.length, endOfArrayToTwist.length);
    }

    private void reverseTheArray() {
        int arrayLength = reverseArray.length;
        for (int i = 0; i < arrayLength / 2; i++) {
            int temp = reverseArray[i];
            reverseArray[i] = reverseArray[arrayLength - 1 - i];
            reverseArray[arrayLength - 1 - i] = temp;
        }
    }

    private void updateValues() {
        for(int insertPoint = index, arrayToInsertFromIndex = 0; arrayToInsertFromIndex < reverseArray.length; insertPoint++, arrayToInsertFromIndex++) {
            memoryValues[insertPoint] = reverseArray[arrayToInsertFromIndex];
            if(insertPoint + 1 == memoryValues.length) {
                insertPoint = -1;
            }
        }
    }

    public int[] memoryValues() {
        return memoryValues;
    }

    public int getIndex() {
        return this.index;
    }

    public static void main(String[] args) {
        DayTen dayTen = new DayTen(256, input, ",");
        int result = dayTen.twist();
        System.out.printf("Part one: %d", result);
    }

    private static final String input = "34,88,2,222,254,93,150,0,199,255,39,32,137,136,1,167";
}
