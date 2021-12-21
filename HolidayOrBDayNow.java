package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HolidayOrBDayNow {

    public static boolean isBirthday(Person p) throws ParseException {
        Date current = todayDate();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        String StringBirthdate = p.getBirthdate();
        Date DateBirthdate = formatter.parse(StringBirthdate);
        return checkDate(DateBirthdate, current);

    }

    public static boolean isHoliday(Holiday h) throws ParseException {
        Date current = todayDate();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");

        String StringHolidayDate = h.getHolidayDate();
        Date DateHolidayDate = formatter.parse(StringHolidayDate);
        return checkDate(DateHolidayDate, current);

    }

    private static boolean checkDate(Date birthdate, Date current) {
        return checkDate(birthdate, current.getDate(),
                current.getMonth());
    }

    private static boolean checkDate(Date bDate, int date, int month) {
        return bDate.getDate() == date
                && bDate.getMonth() == month;
    }

    private static Date todayDate() {
        return new Date();
    }

}
