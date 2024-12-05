public class KontingentBeregning
{
    public static int beregnKontingen(boolean aktiv, int alder)
    {
        if(!aktiv)
        {
            return 500;
        }
        else if(alder < 18)
        {
            return 1000;
        }
        else if(alder > 60)
        {
            return (int) (1600*0.75);
        }
        else
        {
            return 1600;
        }
    }
}
