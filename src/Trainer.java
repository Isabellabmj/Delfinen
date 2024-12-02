import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trainer extends Person
{


    protected String disciplin;

    public Trainer(String navn, CprNr cpr, int telNr, String mail, String diciplin)
    {
        super(navn, cpr,telNr, mail);
        this.disciplin = diciplin;

    }



    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return "Medlem: " + navn + "\n" +
                "Fødselsdag: " + cpr + "\n" +
                "TlfNr: " + tlfNr + "\n" +
                "Mail: " + mail + "\n" +
                "Diciplin: " + disciplin + "\n"
                ;

    }



}