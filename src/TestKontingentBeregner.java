import org.junit.Test;
import static org.junit.Assert.*;

public class TestKontingentBeregner {

    @Test
    public void testPassivtMedlemskab()
    {
        int resultat = KontingentBeregning.beregnKontingen(false, 30);
        assertEquals(500, resultat);
    }

    @Test
    public void testUngdomsMedlemskab()
    {
        int resultat = KontingentBeregning.beregnKontingen(true, 17);
        assertEquals(1000, resultat);
    }

    @Test
    public void testSeniorMedlemskab()
    {
        int resultat = KontingentBeregning.beregnKontingen(true, 30);
        assertEquals(1600, resultat);
    }

    @Test
    public void testSeniorMedlemskabMedRabat()
    {
        int resultat = KontingentBeregning.beregnKontingen(true, 65);
        assertEquals(1200, resultat);
    }

}
