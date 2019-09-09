import static org.junit.Assert.*;

import org.junit.Test;

public class DayFiveTest {

    final String input = "0\n" +
            "3\n" +
            "0\n" +
            "1\n" +
            "-3";

    @Test
    public void given_input_0_3_0_1_negative_3_returns_5() {
        assertEquals(5, DayFive.getJumpsUntilEndOne(input));
    }

    @Test
    public void given_input_0_3_0_1_negative_3_returns_10() {
        assertEquals(10, DayFive.getJumpsUntilEndPartTwo(input));
    }
}