import static org.junit.Assert.*;

import org.junit.Test;

public class DayFourTest {

    //Part one
    @Test
    public void given_input_aa_bb_cc_dd_ee_returns_valid() {
        assertTrue(DayFour.getValidityPartOne("aa bb cc dd ee"));
    }

    @Test
    public void given_input_aa_bb_cc_dd_aa_returns_invalid() {
        assertFalse(DayFour.getValidityPartOne("aa bb cc dd aa"));
    }

    @Test
    public void given_input_aa_bb_cc_dd_aaa_returns_valid() {
        assertTrue(DayFour.getValidityPartOne("aa bb cc dd aaa"));
    }

    //Part two
    @Test
    public void given_input_abcde_fghij_returns_valid() {
        assertTrue(DayFour.getValidityPartTwo("abcde fghij"));
    }

    @Test
    public void given_input_abcde_xyz_ecdab_returns_invalid() {
        assertFalse(DayFour.getValidityPartTwo("abcde xyz ecdab"));
    }

    @Test
    public void given_input_a_ab_abc_abd_abf_abj_returns_valid() {
        assertTrue(DayFour.getValidityPartTwo("a ab abc abd abf abj"));
    }

    @Test
    public void given_input_iiii_oiii_ooii_oooi_oooo_returns_valid() {
        assertTrue(DayFour.getValidityPartTwo("iiii oiii ooii oooi oooo"));
    }

    @Test
    public void given_input_oiii_ioii_iioi_iiio_returns_invalid() {
        assertFalse(DayFour.getValidityPartTwo("oiii ioii iioi iiio"));
    }
}