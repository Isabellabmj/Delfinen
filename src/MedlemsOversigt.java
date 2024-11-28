import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MedlemsOversigt
{
    protected ArrayList<Medlem> medlemmerOversigt = new ArrayList<>();


    String[] piger =

            {
            "Emma", "Sofia", "Freja", "Ida", "Clara",
            "Ella", "Anna", "Sofie", "Maja", "Liva",
            "Laura", "Alma", "Olivia", "Karla", "Agnes",
            "Josefine", "Lærke", "Marie", "Nora", "Sara"
            };

    String[] drenge =
            {
            "William", "Noah", "Oscar", "Lucas", "Emil",
            "Victor", "Oliver", "Alfred", "Elias", "Aksel",
            "Carl", "Malthe", "Felix", "Liam", "Magnus",
            "August", "Christian", "Mikkel", "Alexander", "Mathias"
            };

    String[] efternavne =
            {
            "Jensen", "Nielsen", "Hansen", "Pedersen", "Andersen",
            "Christensen", "Larsen", "Sørensen", "Rasmussen", "Jørgensen",
            "Petersen", "Madsen", "Kristensen", "Olsen", "Thomsen",
            "Jakobsen", "Møller", "Mortensen", "Jepsen", "Iversen"
            };


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

            medlemmerOversigt.add(new Medlem(navn, foedselsdag, tlfNr, mail, medlemsID, oprettelsesDato));
        }
    }

    public ArrayList<Medlem> getMedlemmerOversigt()
    {
            return medlemmerOversigt;
    }



    @Override
    public String toString()
    {
       StringBuilder sb = new StringBuilder("Medlemmer: \n\n");

       for(int i = 0; i < medlemmerOversigt.size(); i++)
        {
            sb.append(medlemmerOversigt.get(i)).append("\n");
        }
       return sb.toString();
    }


}
