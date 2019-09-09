import static org.junit.Assert.*;

import org.junit.Test;

public class DaySixTest {

    @Test
    public void given_0_2_7_0_returns_5() {
        DaySix daySix = new DaySix("0, 2, 7, 0".split(", "));
        assertEquals(5, daySix.getMemoryReallocationPartOne());
    }

    @Test
    public void given_0_2_7_0_returns_5_then_4() {
        DaySix daySix = new DaySix("0, 2, 7, 0".split(", "));
        assertEquals(5, daySix.getMemoryReallocationPartOne());
        assertEquals(4, daySix.reallocateMemoryLoop());
    }
}