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

        return medlem.getBetalinger().udregnRestance(medlem);
    }


    public ArrayList<Medlem> getRestanceListe()
    {
        return restanceliste;
    }


    public boolean isMedlemInRestance(Medlem medlem)
    {
        return restanceliste.contains(medlem);
    }

}

