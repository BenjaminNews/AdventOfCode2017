import static org.junit.Assert.*;

import org.junit.Test;

public class DaySixteenTest {

    @Test
    public void givenInput_return_baedc() {
        DaySixteen daySixteen = new DaySixteen();
        assertEquals("baedc", daySixteen.getResult("s1,x3/4,pe/b", "abcde", 1));
    }
}