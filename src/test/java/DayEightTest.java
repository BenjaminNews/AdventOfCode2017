import static org.junit.Assert.*;

import org.junit.Test;

public class DayEightTest {

    @Test
    public void givenInput_return_1() {
        String input = "b inc 5 if a > 1\n" +
                       "a inc 1 if b < 5\n" +
                       "c dec -10 if a >= 1\n" +
                       "c inc -20 if c == 10";

        DayEight dayEight = new DayEight(input);
        assertEquals(1, dayEight.getLargestNumber());
        assertEquals(10, dayEight.getHighestEverValue());
    }
}