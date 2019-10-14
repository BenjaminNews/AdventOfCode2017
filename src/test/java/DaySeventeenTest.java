import static org.junit.Assert.*;

import org.junit.Test;

public class DaySeventeenTest {

    @Test
    public void givenStepSizeOf_3_after_2017_insertions_nextValueIs_638() {
        assertEquals(638, DaySeventeen.getEndResult(3, 2017, 2017));
    }

    @Test
    public void givenStepSizeOf_3_after_1_insertions_valueInLocationOneIs_1() {
        assertEquals(1, DaySeventeen.getEndResultPartTwo(3, 1));
    }

    @Test
    public void givenStepSizeOf_3_after_2_insertions_valueInLocationOneIs_2() {
        assertEquals(2, DaySeventeen.getEndResultPartTwo(3, 2));
    }

    @Test
    public void givenStepSizeOf_3_after_3_insertions_valueInLocationOneIs_2() {
        assertEquals(2, DaySeventeen.getEndResultPartTwo(3, 3));
    }

    @Test
    public void givenStepSizeOf_3_after_4_insertions_valueInLocationOneIs_2() {
        assertEquals(2, DaySeventeen.getEndResultPartTwo(3, 4));
    }

    @Test
    public void givenStepSizeOf_3_after_5_insertions_valueInLocationOneIs_5() {
        assertEquals(5, DaySeventeen.getEndResultPartTwo(3, 5));
    }

    @Test
    public void givenStepSizeOf_3_after_6_insertions_valueInLocationOneIs_5() {
        assertEquals(5, DaySeventeen.getEndResultPartTwo(3, 6));
    }

    @Test
    public void givenStepSizeOf_3_after_7_insertions_valueInLocationOneIs_5() {
        assertEquals(5, DaySeventeen.getEndResultPartTwo(3, 7));
    }

    @Test
    public void givenStepSizeOf_3_after_8_insertions_valueInLocationOneIs_5() {
        assertEquals(5, DaySeventeen.getEndResultPartTwo(3, 8));
    }

    @Test
    public void givenStepSizeOf_3_after_9_insertions_valueInLocationOneIs_9() {
        assertEquals(9, DaySeventeen.getEndResultPartTwo(3, 9));
    }
}