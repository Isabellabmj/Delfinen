import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medlem extends Person
{

    protected LocalDate oprettelsesDato;
    protected int   medlemsId;
    protected boolean aktivStatus;
    protected boolean erMotionist;
    protected Betalinger betalinger;
    protected boolean erRestance = false;

    public Medlem(String navn, CprNr cpr, int tllNr,String mail, LocalDate oprettelsesDato, boolean aktivStatus, boolean erMotionist, int medlemsId, Betalinger betalinger, boolean erRestance)
    {
        super(navn, cpr,tllNr, mail);
        this.oprettelsesDato = oprettelsesDato;
        this.medlemsId = medlemsId;
        this.aktivStatus = aktivStatus;
        this.erMotionist = erMotionist;
        this.betalinger = betalinger;
        this.erRestance = erRestance;
    }


    public Betalinger getBetalinger()
    {
        return betalinger;
    }

    public int getMedlemsId()
    {
        return medlemsId;
    }

    public String getMedlemStatus()
    {
        if(aktivStatus == true)
        {
            return "Aktiv";
        }
        else
        {
            return "Passiv";
        }
    }

    public String getMedlemsType()
    {
        if(erMotionist == true)
        {
            return "Motionist";
        }
        else
        {
            return "Konkurrence";
        }

    }

    public int getAlder()
    {
        return cpr.getAlder();
    }

    public String getAlderKategori()
    {
        int alder = cpr.getAlder();
        if(alder < 18)
        {
            return "Junior";
        }
        else
        {
            return "Senior";
        }


    }

    public LocalDate getOprettelsesDato()
    {
        return oprettelsesDato;
    }

    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

       int betaling;
        if(erRestance == true)
        {
            betaling = betalinger.udregnRestance(this);
        }
        else
        {
            betaling = betalinger.udregnBetalinger(this);
        }


        String result = "Medlem: " + navn + "\n" +
                "CPR: " + cpr + "\n" +
                "Alder: " + cpr.getAlder() + "\n" +
                "Junior/Senior: " + getAlderKategori() + "\n" +
                "TlfNr: " + tlfNr + "\n" +
                "Mail: " + mail + "\n" +
                "Oprettelsesdato: " + oprettelsesDato + "\n" +
                "Aktiv/Passiv: " + getMedlemStatus() + "\n" +
                "Motionist/Konkurrence: " + getMedlemsType() + "\n" +
                "Betalinger: " + betalinger.udregnBetalinger(this) + " DKK" + "\n" +
                "MedlemsId: " + medlemsId + "\n" +
                "Årligt medlems kontingent: " + betalinger.udregnBetalinger(this) + " DKK" + "\n";

        if (erRestance == true)
        {
            result += "Restance og skylder " + (betaling) + " DKK" + "\n";
        }
        return result;

    }



}