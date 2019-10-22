import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayTwentyTest {

    private DayTwenty dayTwenty;

    @Before
    public void setup() {
        this.dayTwenty = new DayTwenty();
    }

    @Test
    public void partOne_givenInput_particleZeroRemainsClosestTo_Zero() {
        String input =  "p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n" +
                        "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0> ";
        dayTwenty.createParticles(input);
        assertEquals(0, dayTwenty.partOne(10_000));
    }

    @Test
    public void partTwo_givenInput_onlyOneParticleRemains() {
        String input =  "p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
                        "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
                        "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
                        "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>";
        dayTwenty.createParticles(input);
        assertEquals(4, dayTwenty.partTwo(1));
    }
}