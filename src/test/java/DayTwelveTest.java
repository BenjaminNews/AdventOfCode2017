import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTwelveTest {

    @Test
    public void givenInput_returnPipeOfLength_6() {
        DayTwelve dayTwelve = new DayTwelve();
        String input =  "0 <-> 2\n" +
                        "1 <-> 1\n" +
                        "2 <-> 0, 3, 4\n" +
                        "3 <-> 2, 4\n" +
                        "4 <-> 2, 3, 6\n" +
                        "5 <-> 6\n" +
                        "6 <-> 4, 5";

        dayTwelve.setup(input);
        assertEquals(6, dayTwelve.getPipeLength());
    }

    @Test
    public void givenInput_aGroupCountOf_two() {
        DayTwelve dayTwelve = new DayTwelve();
        String input =  "0 <-> 2\n" +
                        "1 <-> 1\n" +
                        "2 <-> 0, 3, 4\n" +
                        "3 <-> 2, 4\n" +
                        "4 <-> 2, 3, 6\n" +
                        "5 <-> 6\n" +
                        "6 <-> 4, 5";

        dayTwelve.setup(input);
        assertEquals(2, dayTwelve.getGroups());
    }
}