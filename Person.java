package date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class Person {
    protected String name;
    protected String sex;
    protected Date birthdate;
    protected String email;

    Person(String name, String sex, Date birthdate, String email){
        this.name = name;
        this.sex = sex;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Person() {
        this.name = null;
        this.sex = null;
        this.birthdate = null;
        this.email = null;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex( String sex ) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(birthdate);
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public InternetAddress getEmail() throws AddressException {
        return new InternetAddress(email);
    }

    public int getAge() {

        Calendar today    = Calendar.getInstance();
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(birthdate);

        int yearDiff = today.get( Calendar.YEAR ) - birthday.get( Calendar.YEAR );

        if ( today.get(Calendar.MONTH) < birthday.get(Calendar.MONTH) )
            yearDiff = yearDiff - 1;
        else if (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH) &&
                today.get(Calendar.DATE)   < birthday.get(Calendar.DATE) ) {
            yearDiff = yearDiff - 1;
        }

        return yearDiff;
    }

    public String getZodiac() {
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(birthdate);
        int month = birthday.get(Calendar.MONTH);
        int day = birthday.get(Calendar.DATE);
        String astro_sign = null;

        if (month == Calendar.DECEMBER){
            if (day < 22)
                astro_sign = "????????????????";
            else
                astro_sign ="??????????????";
        }
        else if (month == Calendar.JANUARY){
            if (day < 20)
                astro_sign = "??????????????";
            else
                astro_sign = "??????????????";
        }
        else if (month == Calendar.FEBRUARY){
            if (day < 19)
                astro_sign = "??????????????";
            else
                astro_sign = "????????";
        }
        else if (month == Calendar.MARCH){
            if (day < 21)
                astro_sign = "????????";
            else
                astro_sign = "????????";
        }
        else if (month == Calendar.APRIL){
            if (day < 20)
                astro_sign = "????????";
            else
                astro_sign = "????????????";
        }
        else if (month == Calendar.MAY){
            if (day < 21)
                astro_sign = "????????????";
            else
                astro_sign = "????????????????";
        }
        else if( month == Calendar.JUNE){
            if (day < 21)
                astro_sign = "????????????????";
            else
                astro_sign = "??????";
        }
        else if (month == Calendar.JULY){
            if (day < 23)
                astro_sign = "??????";
            else
                astro_sign = "??????";
        }
        else if( month == Calendar.AUGUST){
            if (day < 23)
                astro_sign = "??????";
            else
                astro_sign = "????????";
        }
        else if (month == Calendar.SEPTEMBER){
            if (day < 23)
                astro_sign = "????????";
            else
                astro_sign = "????????????";
        }
        else if (month == Calendar.OCTOBER){
            if (day < 23)
                astro_sign = "????????????";
            else
                astro_sign = "????????????????";
        }
        else {
            if (day < 22)
                astro_sign = "????????????????";
            else
                astro_sign = "????????????????";
        }
        return astro_sign;
    }

    public String toString() {
        String s = "????'??: " + getName();
        // s += " B-date: " + getBirthdate() + "\n";
        s += " | ??????: " + getAge();
        s += " | ??????????: " + getSex();
        // s += " Email: " + getEmail() + "\n";
        s += " | ???????? ??????????????: " + getZodiac();
        return s;
    }

}
