import static org.junit.Assert.*;

import org.junit.Test;

public class DaySeventeenTest {

    @Test
    public void givenStepSizeOf_3_after_2017_insertions_nextValueIs_638() {
        assertEquals(638, DaySeventeen.getEndResult(3, 2017, 2017));
    }

}