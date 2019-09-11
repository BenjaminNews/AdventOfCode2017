import static org.junit.Assert.*;

import org.junit.Test;

public class DayFifthteenTest {

    @Test
    public void given_generateAValueOf_65_andGeneratorBValueOf_8921_returns588Matches_after40MillionGenerations() {
        assertEquals(588, DayFifthteen.getResult(65, 8921, 40_000_000));
    }

    @Test
    public void given_generateAValueOf_65_andGeneratorBValueOf_8921_returns309Matches_after5MillionGenerations() {
        assertEquals(309, DayFifthteen.getResultPartTwo(65, 8921, 5_000_000));
    }
}