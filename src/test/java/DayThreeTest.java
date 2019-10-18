import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DayThreeTest {

    @Test
    public void givenValueOf_1_packetIs_1_stepsAway() {
        assertEquals(0, DayThree.partOne(1, 1));
    }

    @Test
    public void givenValueOf_12_packetIs_3_stepsAway() {
        assertEquals(3, DayThree.partOne(12, 12));
    }

    @Test
    public void givenValueOf_23_packetIs_2_stepsAway() {
        assertEquals(2, DayThree.partOne(23, 23));
    }

    @Test
    public void givenValueOf_1024_packetIs_31_stepsAway() {
        assertEquals(31, DayThree.partOne(1024, 1024));
    }

    @Test
    public void givenValueOf_1_firstLargerPacketIs_2() {
        assertEquals(2, DayThree.setupPartTwo(255, 1));
    }

    @Test
    public void givenValueOf_2_firstLargerPacketIs_4() {
        assertEquals(4, DayThree.setupPartTwo(255, 2));
    }

    @Test
    public void givenValueOf_4_firstLargerPacketIs_5() {
        assertEquals(5, DayThree.setupPartTwo(255, 4));
    }

    @Test
    public void givenValueOf_5_firstLargerPacketIs_10() {
        assertEquals(10, DayThree.setupPartTwo(255, 5));
    }

    @Test
    public void givenValueOf_10_firstLargerPacketIs_11() {
        assertEquals(11, DayThree.setupPartTwo(255, 10));
    }

    @Test
    public void givenValueOf_11_firstLargerPacketIs_23() {
        assertEquals(23, DayThree.setupPartTwo(255, 11));
    }

    @Test
    public void givenValueOf_23_firstLargerPacketIs_25() {
        assertEquals(25, DayThree.setupPartTwo(255, 23));
    }

    @Test
    public void givenValueOf_25_firstLargerPacketIs_26() {
        assertEquals(26, DayThree.setupPartTwo(255, 25));
    }

    @Test
    public void givenValueOf_26_firstLargerPacketIs_54() {
        assertEquals(54, DayThree.setupPartTwo(255, 26));
    }

    @Test
    public void givenValueOf_54_firstLargerPacketIs_57() {
        assertEquals(57, DayThree.setupPartTwo(255, 54));
    }

    @Test
    public void givenValueOf_57_firstLargerPacketIs_59() {
        assertEquals(59, DayThree.setupPartTwo(255, 57));
    }

    @Test
    public void givenValueOf_59_firstLargerPacketIs_122() {
        assertEquals(122, DayThree.setupPartTwo(255, 59));
    }

    @Test
    public void givenValueOf_122_firstLargerPacketIs_133() {
        assertEquals(133, DayThree.setupPartTwo(255, 122));
    }

    @Test
    public void givenValueOf_133_firstLargerPacketIs_142() {
        assertEquals(142, DayThree.setupPartTwo(255, 133));
    }

    @Test
    public void givenValueOf_142_firstLargerPacketIs_147() {
        assertEquals(147, DayThree.setupPartTwo(255, 142));
    }

    @Test
    public void givenValueOf_147_firstLargerPacketIs_304() {
        assertEquals(304, DayThree.setupPartTwo(255, 147));
    }

    @Test
    public void givenValueOf_304_firstLargerPacketIs_330() {
        assertEquals(330, DayThree.setupPartTwo(255, 304));
    }

    @Test
    public void givenValueOf_330_firstLargerPacketIs_351() {
        assertEquals(351, DayThree.setupPartTwo(255, 330));
    }

    @Test
    public void givenValueOf_351_firstLargerPacketIs_362() {
        assertEquals(362, DayThree.setupPartTwo(255, 351));
    }

    @Test
    public void givenValueOf_362_firstLargerPacketIs_747() {
        assertEquals(747, DayThree.setupPartTwo(255, 362));
    }

    @Test
    public void givenValueOf_747_firstLargerPacketIs_806() {
        assertEquals(806, DayThree.setupPartTwo(255, 747));
    }
}