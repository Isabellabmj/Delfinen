import java.util.ArrayList;

public class Restance
{
    protected ArrayList<Medlem> restanceliste;

    public Restance()
    {
        this.restanceliste = new ArrayList<>();
    }

    public void addMedlemTilRestanceliste(Medlem medlem)
    {

      if(!restanceliste.contains(medlem))

        {
        restanceliste.add(medlem);
        }
    }

    public int calculateRestanceForMedlem(Medlem medlem)
    {
        // Here you can use the existing logic from Betalinger class
        return medlem.getBetalinger().udregnRestance(medlem);
    }

    // Get the list of members in arrears
    public ArrayList<Medlem> getRestanceListe()
    {
        return restanceliste;
    }

    // Check if a member is in arrears
    public boolean isMedlemInRestance(Medlem medlem)
    {
        return restanceliste.contains(medlem);
    }

}

