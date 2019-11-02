import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayTen {
    private int[] list;
    private int pos = 0;
    private int skipSize = 0;

    public int twist(int setSize, String input, String splitterator) {
        List<Integer> lengths = Arrays.stream(input.split(splitterator)).map(Integer::parseInt).collect(Collectors.toList());
        list = IntStream.iterate(0, n -> n + 1).limit(setSize).toArray();
        twistSubSet(lengths);
        return list[0] * list[1];
    }

    private void twistSubSet(List<Integer> lengths) {
        for (int length : lengths) {
            spin(length);
            pos += length + skipSize;
            skipSize++;
        }
    }

    public String twistPartTwo(int setSize, String input, int[] additionalLengths) {
        List<Integer> lengths = input.chars().boxed().collect(Collectors.toList());
        Collections.addAll(lengths, Arrays.stream(additionalLengths).boxed().toArray(Integer[]::new));
        list = IntStream.iterate(0, n -> n + 1).limit(setSize).toArray();
        for(int x = 0; x < 64; x++) {
            twistSubSet(lengths);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < list.length; i += 16) {
            int XORList = list[i] ^ list[i + 1];
            for(int x = i + 2; x < i + 16; x++) {
                XORList ^= list[x];
            }
            result.append(Integer.toHexString(XORList).length() == 1 ? "0" + Integer.toHexString(XORList) : Integer.toHexString(XORList));
        }
        return result.toString();
    }

    private void spin(int length) {
        for (int i = 0; i < length / 2; i++) {
            int start = (pos + i) % list.length;
            int end = (pos + length - 1 - i) % list.length;
            int tmp = list[start];
            list[start] = list[end];
            list[end] = tmp;
        }
    }

    public static void main(String[] args) {
        DayTen dayTen = new DayTen();
        System.out.println(dayTen.twist(256, input, ","));
        dayTen = new DayTen();
        System.out.println(dayTen.twistPartTwo(256, input, new int[] { 17, 31, 73, 47, 23 }));
    }

    private static final String input = "34,88,2,222,254,93,150,0,199,255,39,32,137,136,1,167";
}