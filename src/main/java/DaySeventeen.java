import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaySeventeen {

    public static int getEndResult(int stepSize, int stepTotal, int getIndex) {
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss z");
        List<Integer> values = new ArrayList<Integer>();
        int index = 0;
        values.add(0);
        for(int i = 1; i <= stepTotal; i++) {
            if(values.size() == 1) {
                index = 1;
                values.add(i);
            } else {
                 if (index + stepSize == values.size()) {
                    index = 1;
                    values.add(index, i);
                } else if(index + stepSize > values.size()) {
                    index = (index + stepSize) % (values.size()) + 1;
                    values.add(index, i);
                } else if(index + stepSize == 0) {
                    index = 0;
                    values.add(index, i);
                } else {
                    index += stepSize + 1;
                    values.add(index, i);
                }
            }
            if(i % 100_000 == 0) {
                System.out.println(formatter.format(System.currentTimeMillis()) + " " + i);
            }
        }
        return values.get(values.indexOf(getIndex) + 1);
    }

    public static void main(String[] args) {
        System.out.printf("Part one: %d", DaySeventeen.getEndResult(354, 2017, 2017));
        System.out.printf("%nPart two: %d", DaySeventeen.getEndResult(354, 50_000_000, 0));
    }
}
