import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Tilmelding
{
    private List<Medlem> opretMedlem;
    private int naesteMedlemsID;
    private Scanner scanner;

    public Tilmelding()
    {
        opretMedlem = new ArrayList<>();
        naesteMedlemsID = 1;
        scanner = new Scanner(System.in);
    }

    public void start()
    {
        boolean koerer = true;

        while (koerer)
        {
            System.out.println("\n Medlemsmenu");
            System.out.println("1. Opret nyt medlem");
            System.out.println("2. Vis alle medlemmer");
            System.out.println("3. Afslut");
            System.out.println("Vælg en funktion");
            int valg = scanner.nextInt();

            switch (valg)
            {
                case 1 -> opretMedlem();
                case 2 -> visMedlemmer();
                case 3 ->
                {
                    koerer = false;
                    System.out.println("Farvel");
                }
                default -> System.out.println("Ugyldigt valg, prøv igen");


            }
        }
    }

    private void opretMedlem()
    {
        System.out.println("Indtast navn");
        scanner.nextLine();
        String navn = scanner.nextLine();

        System.out.println("Indtast Cpr-nummer (ddmmyy-xxxx");
        String CprNr = scanner.nextLine();
        CprNr cpr = new CprNr(CprNr);

        System.out.println("Indtast telefon nummer");
        int tlfNr = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Indtast e-mail adresse");
        String mail = scanner.nextLine();

        LocalDate oprettelsesDato = LocalDate.now();

        System.out.println("er medlem aktiv? (true/false?)");
        boolean aktivStatus = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Er medlem motionist? (true/false?)");
        boolean erMotionist = scanner.nextBoolean();
        scanner.nextLine();

        Betalinger betalinger = new Betalinger();

        boolean erRestance = false;

        //String brugerID = UUID.randomUUID().toString().substring(0,8);

        Medlem nytMedlem = new Medlem(navn, cpr, tlfNr, mail, oprettelsesDato, aktivStatus, erMotionist, naesteMedlemsID, betalinger, erRestance);
        opretMedlem.add(nytMedlem);

        System.out.println("Nyt medlem oprettet");
        System.out.println(nytMedlem);

        naesteMedlemsID++;

    }

    private void visMedlemmer()
    {
        if(opretMedlem.isEmpty())
        {
            System.out.println("Ingen medlemmer er oprettet");
        }
        else
        {
            System.out.println("Liste over medlemmer: ");
            for(Medlem medlem : opretMedlem)
            {
                System.out.println(medlem);
            }
        }
    }
    public static void main(String[] args)
    {
        Tilmelding nyTilmelding = new Tilmelding();
        nyTilmelding.start();
    }
        //mangler at få tildelt et bruger ID og at blive tilføjet til tekstfilen

}

