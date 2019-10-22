import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayTwentyTest {

    @Test
    public void partOne_givenInput_particleZeroRemainsClosestTo_Zero() {
        String input =  "p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n" +
                        "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0> ";
        DayTwenty dayTwenty = new DayTwenty(input);
        assertEquals(0, dayTwenty.partOne(10_000));
    }

    @Test
    public void partTwo_givenInput_onlyOneParticleRemains() {
        String input =  "p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
                        "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
                        "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
                        "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>";
        DayTwenty dayTwenty = new DayTwenty(input);
        assertEquals(4, dayTwenty.partTwo(1));
    }
}