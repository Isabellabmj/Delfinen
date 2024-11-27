import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MedlemsOversigt
{
    protected ArrayList<Medlem> medlemmerOversigt = new ArrayList<>();

    public MedlemsOversigt()
    {
        CreateMedlemmerOversigt();
    }


    public void CreateMedlemmerOversigt()

    {
        Random random = new Random();

        for(int i = 1; i <= 200; i++)
        {
            String navn = "Medlem " + i;
            int foedselsdag = random.nextInt(100000);
            int tlfNr = 1000000 + random.nextInt(90000000);
            String mail = navn.toLowerCase() + "@gmail.com";
            LocalDate oprettelsesDato = LocalDate.now().minusDays(random.nextInt(365 * 5));
            int medlemsID = 1000 + i;

            medlemmerOversigt.add(new Medlem(navn, foedselsdag, tlfNr, mail, oprettelsesDato, medlemsID));
        }
    }

    public ArrayList<Medlem> getMedlemmerOversigt()
    {
            return medlemmerOversigt;
    }

    public String toString()
    {
        return
                "Medlemmere: " + "\n" +
                        medlemmerOversigt.toString();
    }

}