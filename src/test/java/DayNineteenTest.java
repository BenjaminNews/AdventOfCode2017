import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class DayNineteenTest {
    private DayNineteen dayNineteen;

    private static final String input = "     |          \n" +
                                        "     |  +--+    \n" +
                                        "     A  |  C    \n" +
                                        " F---|----E|--+ \n" +
                                        "     |  |  |  D \n" +
                                        "     +B-+  +--+ \n";


    @Before
    public void setup() {
        dayNineteen = new DayNineteen(input);
    }

    @Test
    public void givenInput_return_ABCDEF() {
        assertEquals("ABCDEF", dayNineteen.traverseMap());
        assertEquals(38, dayNineteen.getStepCount());
    }
}