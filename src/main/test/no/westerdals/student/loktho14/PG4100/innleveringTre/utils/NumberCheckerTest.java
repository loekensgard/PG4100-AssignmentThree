package no.westerdals.student.loktho14.PG4100.innleveringTre.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by Thorstein on 17.04.2016.
 */
public class NumberCheckerTest {
    private NumberChecker nc;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void test_if_number_is_valid() throws Exception {
        nc = new NumberChecker("12");
        assertEquals(12, nc.getNumber());

        exception.expect(NumberFormatException.class);
        nc = new NumberChecker("herman");

        exception.expect(ArithmeticException.class);
        nc = new NumberChecker("-12");
    }

    @Test
    public void test_if_number_is_prime() throws Exception {
        nc = new NumberChecker("7");
        assertTrue(nc.isPrime(7));
        nc = new NumberChecker("12");
        assertFalse(nc.isPrime(12));
    }

    @Test
    public void test_output_message() throws Exception {
        nc = new NumberChecker("12");
        assertEquals("12 er ikke et primtall", nc.toString(12));

        nc = new NumberChecker("7");
        assertEquals("7 er et primtall", nc.toString(7));
    }

}