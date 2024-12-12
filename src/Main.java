import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {


        MedlemsOversigt medlemsOversigt = new MedlemsOversigt();
        medlemsOversigt.addAlleMedlemmeretoRestanceList();

        MedlemmerPersistens medlemsPersistens = new MedlemmerPersistens();
        medlemsPersistens.writeMedlemmerPersistens(medlemsOversigt.getMedlemmerOversigt());

        RestancePersistens restancePersistens = new RestancePersistens(medlemsOversigt);
        restancePersistens.writeRestancePersistens();

        // Opret TraenerPersistens objekt og skriv trænere til fil

        TrainerOversigt traenerOversigt = new TrainerOversigt();
        TrainerPersistens traenerPersistens = new TrainerPersistens(traenerOversigt.getTraenerListe());
        traenerPersistens.writeTraenerToFile();

        GUI gui = new GUI();
        gui.setVisible(true);

    }
}