public class Betalinger
{
    protected boolean restance;
    protected int medlemsKontigent;

    public Betalinger()
    {}

    public Betalinger(int medlemsKontigent)
    {
        this.medlemsKontigent = medlemsKontigent;

    }

    public int udregnBetalinger(Medlem medlem)
    {
        int medlemsKontingent = 0;

        if (medlem.getMedlemStatus().equalsIgnoreCase("Aktiv"))
        {

            int alder = medlem.getAlder();
            if (medlem.getAlderKategori().equalsIgnoreCase("Junior"))
            {
                medlemsKontingent = 1000;
            } else if (alder >= 60)
            {
                medlemsKontingent = (int) (1600 * 0.75);
            } else
            {
                medlemsKontingent = 1600;
            }
        } else
        {
            medlemsKontingent = 500;
        }

        return medlemsKontingent;
    }

    public boolean getBetalt()
    {
        return restance;
    }


    public int udregnRestance(Medlem medlem)
    {
    int medlemsKontingent = 0;

        if (medlem.getMedlemStatus().equalsIgnoreCase("Aktiv"))
    {

        int alder = medlem.getAlder();
        if (medlem.getAlderKategori().equalsIgnoreCase("Junior"))
        {
            medlemsKontingent = -1000;
        } else if (alder >= 60)
        {
            medlemsKontingent = (int) (1600 * 0.75);
        } else
        {
            medlemsKontingent = -1600;
        }
    } else
    {
        medlemsKontingent = -500;
    }

        return medlemsKontingent;
}

}


