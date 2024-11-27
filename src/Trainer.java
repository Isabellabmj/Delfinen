import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Trainer extends Person
{
    protected String disciplin;


    public Trainer()
    {}

    public Trainer(String navn, int foedselsdag, int tlfNr, String mail, String disciplin)
    {
        super(navn, foedselsdag, tlfNr, mail);
        this.disciplin = disciplin;

    }

    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Medlem: "+ navn + "\n"+
                "Fødselsdag "+ foedselsdag + "\n"+
                "Telefonnr: " + tlfNr + "\n"+
                "E-mail " + mail + "\n"+
                "Disciplin" + disciplin + "\n";

    }


}

