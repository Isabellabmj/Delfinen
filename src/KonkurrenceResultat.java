import java.util.ArrayList;

public class KonkurrenceResultat
{
    protected ArrayList<Medlem> konkurrenceMedlem;
    protected String tid;
    protected String svoemmedisciplin;

    public KonkurrenceResultat()
    {}

    public ArrayList<Medlem> getKonkurrenceMedlem()
    {
        return konkurrenceMedlem;
    }

    public String getTid()
    {
        return tid;
    }

    public String getSvoemmedisciplin()
    {
        return svoemmedisciplin;
    }
}
