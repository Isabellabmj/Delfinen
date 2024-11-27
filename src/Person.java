public abstract class Person
{
    protected String navn;
    protected int foedselsdag;
    protected int tlfNr;
    protected String mail;

    public Person()
    {}

    public Person(String navn, int foedselsdag, int tlfNr, String mail)
    {
        this.navn = navn;
        this.foedselsdag = foedselsdag;
        this.tlfNr = tlfNr;
        this.mail = mail;
    }

    public String getNavn()
    {
        return navn;
    }

    public int getFoedselsdag()
    {
        return foedselsdag;
    }

    public int getTlfNr()
    {
        return tlfNr;
    }

    public String getMail()
    {
        return mail;
    }


}
