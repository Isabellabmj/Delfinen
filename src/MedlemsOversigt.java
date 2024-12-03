import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class MedlemsOversigt
{

    protected ArrayList<Medlem> medlemmerOversigt = new ArrayList<>();
    protected Restance restance;


    public MedlemsOversigt()
    {
        this.medlemmerOversigt = new ArrayList<>();
        this.restance = new Restance();
        createMedlemmereOversigt();
    }


    public void createMedlemmereOversigt()
    {
        Random random = new Random();



        for (int i = 1; i <= 250; i++)
        {

            CprNr cpr = new CprNr(true);

            String[] pigenavne = {
                    "Emma", "Sofia", "Ida", "Freja", "Clara",
                    "Laura", "Maja", "Anna", "Ella", "Nora",
                    "Karla", "Luna", "Victoria", "Olivia", "Alma"
            };

            String[] drengenavne = {
                    "William", "Noah", "Oliver", "Emil", "Oscar",
                    "Lucas", "Victor", "Alfred", "Elias", "Carl",
                    "Aksel", "Malthe", "Alexander", "Magnus", "Felix"
            };

            String[] efternavne = {
                    "Jensen", "Nielsen", "Hansen", "Pedersen", "Andersen",
                    "Christensen", "Larsen", "Sørensen", "Rasmussen", "Jørgensen",
                    "Madsen", "Kristensen", "Poulsen", "Johansen", "Olsen"
            };

            int lastDigit = cpr.getGender();
            boolean erUlige = (lastDigit % 2 != 0);
            String fornavn;


            if (erUlige)
            {
                fornavn = drengenavne[random.nextInt(drengenavne.length)];
            } else
                fornavn = pigenavne[random.nextInt(pigenavne.length)];

            String efternavn = efternavne[random.nextInt(efternavne.length)];

            String navn = fornavn + " " + efternavn;



            int tlfNr = 10000000 + random.nextInt(90000000);
            String mail = fornavn.toLowerCase() + random.nextInt(22222) +"@gmail.com";
            LocalDate oprettelsesDato = LocalDate.now().minusDays(random.nextInt(365 * 5));
            boolean erAktiv = random.nextBoolean();
            boolean erMotionist = random.nextBoolean();
            int medlemsId = 1000 + i;
            boolean restance = random.nextBoolean();

            medlemmerOversigt.add(new Medlem(navn, cpr, tlfNr, mail, oprettelsesDato, erAktiv, erMotionist, medlemsId, new Betalinger(),restance));
        }
    }

    public ArrayList<Medlem> getMedlemmerOversigt()
    {
        return medlemmerOversigt;
    }


    public void addMedlemmerToMedlemmerOversigt(Medlem m)
    {
        medlemmerOversigt.add(m);
    }

    public int getAntalMedlemmere()
    {
        return medlemmerOversigt.size();
    }

    public Restance getRestance()
    {
        return restance;
    }

    public void addAlleMedlemmeretoRestanceList()
    {
        for (int i = 0; i < medlemmerOversigt.size(); i++)
        {
            Medlem m = medlemmerOversigt.get(i);  // Get the Medlem at index i
            if (m.erRestance)
            {
                restance.addMedlemTilRestanceliste(m);
                System.out.println("Added to RestanceListe: " + m.getNavn());
            }
        }
    }



    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Medlemmere:\n\n");

        for (int i = 0; i < medlemmerOversigt.size(); i++)
        {
            sb.append(medlemmerOversigt.get(i)).append("\n");
        }
        return sb.toString();
    }



}