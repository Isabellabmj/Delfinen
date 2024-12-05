import org.junit.Test;
import static org.junit.Assert.*;

public class TestKontingentBeregner {

    @Test
    public void testPassivtMedlemskab() {
        // Test for passivt medlemskab
        int resultat = KontingentBeregning.beregnKontingen(false, 30);
        assertEquals(500, resultat);
    }

    @Test
    public void testUngdomsMedlemskab() {
        // Test for aktiv ungdomssvømmer under 18
        int resultat = KontingentBeregning.beregnKontingen(true, 17);
        assertEquals(1000, resultat);
    }

    @Test
    public void testSeniorMedlemskab() {
        // Test for aktiv seniormedlem (18-59 år)
        int resultat = KontingentBeregning.beregnKontingen(true, 30);
        assertEquals(1600, resultat);
    }

    @Test
    public void testSeniorMedlemskabMedRabat() {
        // Test for aktiv seniormedlem over 60 med rabat
        int resultat = KontingentBeregning.beregnKontingen(true, 65);
        assertEquals(1200, resultat);
    }
}
