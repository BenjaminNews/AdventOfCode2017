import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DayOneTest {

    //PART ONE
    @Test
    public void given_1122_returns_3() {
        assertEquals(3, DayOne.getCountPartOne("1122"));
    }

    @Test
    public void given_1111_returns_4() {
        assertEquals(4, DayOne.getCountPartOne("1111"));
    }

    @Test
    public void given_1234_returns_0() {
        assertEquals(0, DayOne.getCountPartOne("1234"));
    }

    @Test
    public void given_91212129_returns_9() {
        assertEquals(9, DayOne.getCountPartOne("91212129"));
    }

    //PART TWO
    @Test
    public void given_1212_returns_6() {
        assertEquals(6, DayOne.getCountPartTwo("1212"));
    }

    @Test
    public void given_1221_returns_0() {
        assertEquals(0, DayOne.getCountPartTwo("1221"));
    }

    @Test
    public void given_123425_returns_4() {
        assertEquals(4, DayOne.getCountPartTwo("123425"));
    }

    @Test
    public void given_123123_returns_12() {
        assertEquals(12, DayOne.getCountPartTwo("123123"));
    }

    @Test
    public void given_12131415_returns_4() {
        assertEquals(4, DayOne.getCountPartTwo("12131415"));
    }
}