import static org.junit.Assert.*;

import org.junit.Test;

public class DayElevenTest {

    @Test
    public void given_input_ne_ne_ne_returns_3() {
        assertEquals(3, DayEleven.getDistance("ne,ne,ne"));
    }

    @Test
    public void given_input_ne_ne_sw_sw_returns_0() {
        assertEquals(0, DayEleven.getDistance("ne,ne,sw,sw"));
    }

    @Test
    public void given_input_ne_ne_s_s_returns_2() {
        assertEquals(2, DayEleven.getDistance("ne,ne,s,s"));
    }

    @Test
    public void given_input_se_sw_se_sw_sw_returns_3() {
        assertEquals(2, DayEleven.getDistance("se,sw,se,sw,sw"));
    }
}