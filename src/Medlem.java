import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Medlem extends Person
{
    protected int medlemID;
    protected LocalDate oprettelsesDato;

    public Medlem()
    {}

    public Medlem(String navn, int foedselsdag, int tlfNr, String mail, int medlemID, LocalDate oprettelsesDato)
    {
        super(navn, foedselsdag, tlfNr, mail);
        this.medlemID = medlemID;
        this.oprettelsesDato = oprettelsesDato;

    }

    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Medlem: "+ navn + "\n"+
                "Fødselsdag "+ foedselsdag + "\n"+
                "Telefonnr: " + tlfNr + "\n"+
                "E-mail " + mail + "\n"+
                "Medlems ID " + medlemID + "\n"+
                "OprettelsesDato " + oprettelsesDato + "\n";
        
    }


}
