public class Betalinger
{
    protected boolean betalt = true;
    //protected Restance restance;
    protected int rabat;
    protected int medlemsKontigent;

    public Betalinger()
    {}

    public Betalinger(boolean betalt)
    {
        this.betalt = betalt;
        this.rabat = rabat;
    }

    public int udregnBetalinger(Medlem medlem) {
        int medlemsKontingent = 0;

        if (medlem.getMedlemStatus().equalsIgnoreCase("Aktiv")) {
            // For active members, determine the membership fee based on age
            int alder = medlem.getAlder();
            if (medlem.getAlderKategori().equalsIgnoreCase("Junior")) {
                medlemsKontingent = 1000;  // Junior membership fee
            } else if (alder >= 60) {
                medlemsKontingent = (int) (1600 * 0.75);  // 25% discount for seniors over 60
            } else {
                medlemsKontingent = 1600;  // Regular senior fee
            }
        } else {
            medlemsKontingent = 500;  // Passive members pay a smaller fee
        }

        return medlemsKontingent;  // Apply discount
    }

    public boolean getBetalt()
    {
        return betalt;
    }

    /*public Restance getRestance()
    {
        return restance;
    }*/

    public int getRabat()
    {
        return rabat;
    }


}
