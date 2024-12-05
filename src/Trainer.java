public class Trainer extends Person {
    protected String diciplin;

    public Trainer(String navn, CprNr cpr, int telNr, String mail, String diciplin) {
        super(navn, cpr, telNr, mail);
        this.diciplin = diciplin;
    }

    public String getDiciplin()
    {
        return this.diciplin;
    }

    @Override
    public String toString() {
        return super.toString() + "Diciplin: " + diciplin + "\n";
    }
}