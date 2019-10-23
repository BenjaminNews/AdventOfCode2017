import static org.junit.Assert.*;

import org.junit.Test;

public class DayTwentyTwoTest {

    @Test
    public void givenInput_after_70_bursts_leavesInfectedCountOf_41() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo();
        String input =  "..#\n" +
                        "#..\n" +
                        "...";
        dayTwentyTwo.setup(input, 70);
        assertEquals(41, dayTwentyTwo.partOne(70));
    }

    @Test
    public void givenInput_after_100_bursts_leavesInfectedCountOf_26() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo();
        String input =  "..#\n" +
                        "#..\n" +
                        "...";
        dayTwentyTwo.setup(input, 100);
        assertEquals(26, dayTwentyTwo.partTwo(100));
    }

    @Test
    public void givenInput_after_10_000_000_bursts_leavesInfectedCountOf_2511944() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo();
        String input =  "..#\n" +
                        "#..\n" +
                        "...";
        dayTwentyTwo.setup(input, 10_000);
        assertEquals(2511944, dayTwentyTwo.partTwo(10_000_000));
    }
}