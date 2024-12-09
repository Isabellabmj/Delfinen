import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {

        MedlemsOversigt medlemsOversigt = new MedlemsOversigt();
        medlemsOversigt.addAlleMedlemmeretoRestanceList();


        RestancePersistens restancePersistens = new RestancePersistens(medlemsOversigt);
        restancePersistens.writeRestancePersistens();

        System.out.println(medlemsOversigt);
        System.out.println(restancePersistens);

        Medlem peyton = new Medlem("Peyton", new CprNr("250394-2502"), 10239834, "jkldsaljk@gmail.com", LocalDate.now(), true, true, 93930, new Betalinger(12342), true);
        System.out.println(peyton);

        // public Medlem(String navn, CPR cpr, int telNr, String mail, LocalDate oprettelsesDato, boolean aktivStatus, boolean erMotionist, int medlemsId, Betalinger betalinger, boolean erRestance)

        // Opret Traener-oversigt
        TrainerOversigt traenerOversigt = new TrainerOversigt();

        // Opret TraenerPersistens objekt og skriv trænere til fil
        TrainerPersistens traenerPersistens = new TrainerPersistens(traenerOversigt.getTraenerListe());
        traenerPersistens.writeTraenerToFile();

        MedlemmerPersistens medlemsPersistens = new MedlemmerPersistens();
        medlemsPersistens.writeMedlemmerPersistens(medlemsOversigt.getMedlemmerOversigt());


    }
}