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
            // For active members, determine the membership fee based on age
            int alder = medlem.getAlder();
            if (medlem.getAlderKategori().equalsIgnoreCase("Junior"))
            {
                medlemsKontingent = 1000;  // Junior membership fee
            } else if (alder >= 60)
            {
                medlemsKontingent = (int) (1600 * 0.75);  // 25% discount for seniors over 60
            } else
            {
                medlemsKontingent = 1600;  // Regular senior fee
            }
        } else
        {
            medlemsKontingent = 500;  // Passive members pay a smaller fee
        }

        return medlemsKontingent;  // Apply discount
    }

    public boolean getBetalt()
    {
        return restance;
    }

    /*public Restance getRestance()
    {
        return restance;
    }*/

    public int udregnRestance(Medlem medlem)
    {
    int medlemsKontingent = 0;

        if (medlem.getMedlemStatus().equalsIgnoreCase("Aktiv"))
    {
        // For active members, determine the membership fee based on age
        int alder = medlem.getAlder();
        if (medlem.getAlderKategori().equalsIgnoreCase("Junior"))
        {
            medlemsKontingent = -1000;  // Junior membership fee
        } else if (alder >= 60)
        {
            medlemsKontingent = (int) (1600 * 0.75);  // 25% discount for seniors over 60
        } else
        {
            medlemsKontingent = -1600;  // Regular senior fee
        }
    } else
    {
        medlemsKontingent = -500;  // Passive members pay a smaller fee
    }

        return medlemsKontingent;  // Apply discount
}

}
