import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

public class DayTenTest {

    private DayTen dayTen;

    @Before
    public void setup() {
        this.dayTen = new DayTen();
    }

    @Test
    public void givenAnArrayWithValues_0_1_2_3_4_andAnIndexOf_0_andATwistSizeOf_3_returnScoreOf_2() {
        assertEquals(12,  dayTen.twist(5, "3, 4, 1, 5", ", "));
    }

    @Test
    public void givenEmptyInput_returns_a2582a3a0e66e6e86e3812dcb672a272() {
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", dayTen.twistPartTwo(256, "", new int[] { 17, 31, 73, 47, 23 }));
    }

    @Test
    public void givenInput_AoC_2017_returns_33efeb34ea91902bb2f59c9920caa6cd() {
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", dayTen.twistPartTwo(256, "AoC 2017", new int[] { 17, 31, 73, 47, 23 }));
    }

    @Test
    public void givenInput_1_2_3_returns_3efbe78a8d82f29979031a4aa0b16a9d() {
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", dayTen.twistPartTwo(256, "1,2,3", new int[] { 17, 31, 73, 47, 23 }));
    }

    @Test
    public void givenInput_1_2_4_returns_63960835bcdc130f0b66d7ff4f6a5a8e() {
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", dayTen.twistPartTwo(256, "1,2,4", new int[] { 17, 31, 73, 47, 23 }));
    }
}