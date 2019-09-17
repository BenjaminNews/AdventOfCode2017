import static org.junit.Assert.*;

import org.junit.Test;

public class DayTenTest {

    @Test
    public void givenAnArrayWithValues_0_1_2_3_4_andAnIndexOf_0_andATwistSizeOf_3_return_2_1_0_3_4() {
        DayTen dayTen = new DayTen(5, "3, ", ", ");
        dayTen.twist();
        assertArrayEquals(new int[] {2, 1, 0, 3, 4}, dayTen.memoryValues());
        assertEquals(3, dayTen.getIndex());
    }

    @Test
    public void givenAnArrayWithValues_0_1_2_3_4_anIndexOf_0_andATwistSizeOf_3_4_return_4_3_0_1_2() {
        DayTen dayTen = new DayTen(5, "3, 4, ", ", ");
        dayTen.twist();
        assertArrayEquals(new int[] {4, 3, 0, 1, 2}, dayTen.memoryValues());
        assertEquals(3, dayTen.getIndex());
    }

    @Test
    public void givenAnArrayWithValues_0_1_2_3_4_anIndexOf_0_andATwistSizeOf_3_4_1_return_4_3_0_1_2() {
        DayTen dayTen = new DayTen(5, "3, 4, 1, ", ", ");
        dayTen.twist();
        assertArrayEquals(new int[] {4, 3, 0, 1, 2}, dayTen.memoryValues());
        assertEquals(1, dayTen.getIndex());
    }

    @Test
    public void givenAnArrayWithValues_0_1_2_3_4_anIndexOf_0_andATwistSizeOf_3_4_1_5_return_3_4_2_1_0_withScoreOf_12() {
        DayTen dayTen = new DayTen(5, "3, 4, 1, 5, ", ", ");
        assertEquals(12, dayTen.twist());
        assertArrayEquals(new int[] {3, 4, 2, 1, 0}, dayTen.memoryValues());
        assertEquals(4, dayTen.getIndex());
    }
}