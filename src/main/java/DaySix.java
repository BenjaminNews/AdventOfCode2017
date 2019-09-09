import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DaySix {

    private int[] memory;
    ArrayList<String> experiencedMemoryValues = new ArrayList<>();

    public DaySix(String[] input) {
        memory =  Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        experiencedMemoryValues.add(Arrays.toString(memory));
    }

    public int getMemoryReallocationPartOne() {
        int turns = 1;
        while(true) {
            int maxValuePosition = 0;
            maxValuePosition = getMaxValuePosition(maxValuePosition);
            reallocateMemory(maxValuePosition);
            if(experiencedMemoryValues.contains(Arrays.toString(memory))) {
                break;
            } else {
                experiencedMemoryValues.add(Arrays.toString(memory));
                turns++;
            }
        }
        return turns;
    }

    private int getMaxValuePosition(int maxValuePosition) {
        for (int i = 0; i < memory.length; i++) {
            maxValuePosition = memory[i] > memory[maxValuePosition] ? i : maxValuePosition;
        }
        return maxValuePosition;
    }

    private void reallocateMemory(int maxValuePosition) {
        int spreadValue = memory[maxValuePosition];
        memory[maxValuePosition++] = 0;
        for(int count = 0; count < spreadValue; count++, maxValuePosition++) {
            if(maxValuePosition >= memory.length) {
                maxValuePosition = 0;
            }
            memory[maxValuePosition]++;
        }
    }

    public int reallocateMemoryLoop() {
        experiencedMemoryValues.clear();
        return getMemoryReallocationPartOne() - 1;
    }

    public static void main(String[] args) {
        DaySix daySix = new DaySix(input.split("\\s+"));
        System.out.printf("Part one: %d", daySix.getMemoryReallocationPartOne());
        System.out.printf("%nPart two: %d", daySix.reallocateMemoryLoop());
    }

    private static final String input = "4\t10\t4\t1\t8\t4\t9\t14\t5\t1\t14\t15\t0\t15\t3\t5";
}
