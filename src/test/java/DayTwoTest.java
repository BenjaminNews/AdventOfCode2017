import static org.junit.Assert.*;

import org.junit.Test;

public class DayTwoTest {

    //Part one
    @Test
    public void given_input_returns_18() {
        String input =  "5 1 9 5\n" +
                        "7 5 3\n" +
                        "2 4 6 8";
        assertEquals(18, DayTwo.getChecksumPartOne(input));
    }

    //Part two
    @Test
    public void given_input_returns_9() {
        String input = "5 9 2 8\n" +
                       "9 4 7 3\n" +
                       "3 8 6 5";
        assertEquals(9, DayTwo.getChecksumPartTwo(input));
    }
}