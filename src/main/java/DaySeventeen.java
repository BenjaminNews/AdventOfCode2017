import java.util.ArrayList;
import java.util.List;

public class DaySeventeen {

    private static int index = 0;

    public static int getEndResult(int stepSize, int stepTotal, int getIndex) {
        List<Integer> values = new ArrayList<>(stepTotal);
        values.add(0);
        for(int size = values.size(); size <= stepTotal; size++)
            values.add(spin(stepSize, size), size);
        return values.get(values.indexOf(getIndex) + 1);
    }

    public static int getEndResultPartTwo(int stepSize, int stepTotal) {
        int firstValue = 0;
        for(int size = 1; size <= stepTotal; size++) {
            if(index == 0) {
                index = 1;
                firstValue = size;
            } else {
                if(spin(stepSize, size) == 1)
                    firstValue = size;
            }
        }
        return firstValue;
    }

    private static int spin(int stepSize, int size) {
        if (index + stepSize < size)
            index += stepSize + 1;
        else if (index + stepSize > size)
            index = (index + stepSize) % (size) + 1;
        else
            index = 1;
        return index;
    }

    public static void main(String[] args) {
        System.out.printf("Part one: %d%n", DaySeventeen.getEndResult(354, 2017, 2017));
        System.out.printf("Part two: %d", DaySeventeen.getEndResultPartTwo(354, 50_000_000));
    }
}
