public abstract class Person
{

    protected String navn;
    // protected int foedselsdag;

    protected CprNr cpr;
    protected int tlfNr;
    protected String mail;

    public Person(String navn, CprNr cpr, int telNr, String mail)
    {
        this.navn = navn;
        this.cpr = cpr;
        this.tlfNr = telNr;
        this.mail = mail;
    }

    public String getNavn()
    {
        return navn;
    }

    public CprNr getCpr()
    {
        return cpr;
    }

    public int getTelNr()
    {
        return tlfNr;
    }

    public String getMail()
    {
        return mail;
    }

}
