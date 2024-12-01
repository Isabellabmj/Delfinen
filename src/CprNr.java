import java.time.LocalDate;
import java.util.Random;

public class CprNr
{
    String nummeret;

    public CprNr()
    {}

    public CprNr(String n)
    {
        nummeret = n;
    }


    public CprNr(boolean generateRandom)
    {
        if (generateRandom)
        {
            this.nummeret = generateRandomCPR();
        }
        else
        {
            this.nummeret = "";
        }
    }



    public String getCprNr()
    {
        return nummeret;
    }

    public void setCprNr(String n)
    {
        nummeret = n;
    }

    public int getDag()
    {
        return Integer.parseInt(nummeret.substring(0,2));
    }

    public int getMaaned()
    {
        return Integer.parseInt(nummeret.substring(2,4));
    }

    /*public int getAar()
    {
        int aarhundrede = 0;

        if (nummeret.charAt(6) >='0' && nummeret.charAt(6) <= '3')
            aarhundrede = 1900;
        else
        if (nummeret.charAt(6) == '4' || nummeret.charAt(6) =='5')
            aarhundrede = 1800;
        else
            aarhundrede = 2000;

        return aarhundrede + Integer.parseInt(nummeret.substring(4,6));
    }*/

    public int getAar() {
        int yearPart = Integer.parseInt(nummeret.substring(4, 6));  // De sidste to cifre af året (yy)
        char centuryIndicator = nummeret.charAt(6);  // 7. ciffer i CPR-nummeret

        int aarhundrede;

        if (centuryIndicator >= '0' && centuryIndicator <= '3') {
            aarhundrede = 1900;
        } else if ((centuryIndicator == '4' || centuryIndicator == '9') && yearPart <= LocalDate.now().getYear() % 100) {
            aarhundrede = 2000;  // Når vi er efter år 2000
        } else if (centuryIndicator == '2' || centuryIndicator == '5' || centuryIndicator == '6') {
            aarhundrede = 1900;  // Default to 1900s for normal 2/5/6 indicators
        } else {
            aarhundrede = 1800;
        }

        int year = aarhundrede + yearPart;

        // Correct the century if age is below 10 or above 100
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        // Adjust the year based on the age
        if (age < 10) {
            year -= 100;  // If under 10, the year should be from the previous century
        } else if (age > 100) {
            year += 100;  // If over 100, the year should be from the next century
        }

        return year;
    }

    public Dato getDato()
    {
        Dato d = new Dato(getDag(), getMaaned(), getAar());
        return d;
    };

   public int getAlder()
    {
        LocalDate dd = LocalDate.now();
        Dato iDag = new Dato(dd.getDayOfMonth(),dd.getMonthValue(),dd.getYear());

        return (iDag.getDatoen() - getDato().getDatoen()) / 10000;
    }



    public boolean erMand()
    {
        if (Integer.parseInt(nummeret.substring(9,10)) % 2 !=0)
            return true;
        return false;
    }

    public boolean erKvinde()
    {
        return !erMand();

    }

    public boolean isValid()
    {
        if (nummeret.length() != 10)
            return false;

        for (int i = 0; i < 10; i++)
            if(nummeret.charAt(i) < '0' || nummeret.charAt(i) > '9')
                return false;

        if (!getDato().valid())
            return false;

        int udregnet = 0;
        int[] vaegte = {4,3,2,7,6,5,4,3,2,1};

        for (int i = 0; i < 10; i++)
            udregnet += vaegte[i] *  Integer.parseInt(""+nummeret.charAt(i));
        // valdemar gjorde sådan her: udregnet += vaegte[i] *nummeret.charAt(i) - '0';

        if (udregnet % 11 !=0)
            return false;

        return true;
    }

    public String toString()
    {
        return nummeret;
    }



    private String generateRandomCPR()
    {
        Random random = new Random();


        int day = 1 + random.nextInt(28);  // Random day between 1 and 28 (to avoid invalid dates)
        int month = 1 + random.nextInt(12);  // Random month between 1 and 12
        int year = 1920 + random.nextInt(110);  // Random year between 1900 and 1999
        String birthDate = String.format("%02d%02d%02d", day, month, year % 100);

        // Generate random 4-digit number (XXXX)
        int genderPart = random.nextInt(10000);  // Random number between 0000 and 9999
        String genderDigit = String.format("%04d", genderPart);

        // Combine the birthdate and gender part to form the CPR number
        String cprNumber = birthDate + "-" + genderDigit;

        // Validate and return the valid CPR number

        return cprNumber;

    }




}