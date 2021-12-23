package date;

import java.io.*;
import java.text.*;
import java.util.*;


public class HolidayFile {

    public static Holiday run() throws IOException {
        easter();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "resources/Holidays.txt"));
            String line = reader.readLine();
            while (line != null) {
                Holiday h = fromLineToHoliday(line);

                if (HolidayOrBDayNow.isHoliday(h)){
                    return h;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Holiday fromLineToHoliday(String s) throws ParseException {
       Holiday h = new Holiday();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
        String[] words = s.split("-");
        for (int i = 0; i < words.length; i++){
            switch (i) {
                case 0 -> h.setHolidayName(words[i]);
                case 1 -> h.setHolidayDate(formatter.parse(words[i]));
                default -> System.out.println("In Holiday switch...case smth wrong");
            }
        }
        return h;
    }

    public static void easter() throws IOException {
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        int year = cal.get(Calendar.YEAR);
        Holiday easterDay = new Holiday("Великдень", getEasterDay(year));

        if (!isInFile(easterDay.toString())){
            try (FileWriter fw = new FileWriter("resources/Holidays.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(easterDay);
            } catch (IOException ignored) {
            }
        }
    }

    private static Date getEasterDay(int year) {
        int n = 0, p = 0, n_old;

        int pp = (19*(year % 19) + 15) % 30;
        int b = (2*(year % 4) + 4*(year % 7) + 6*pp + 6) % 7;
        int f = (pp + b);

        if (f <= 9){
            n_old = 22 + f;
            if (n_old + 13 > 31) {
                n = (n_old + 13) - 31;
                p = 4;
            }
        } else {
            n_old = f - 9;
            if (n_old + 13 > 30) {
                n = (n_old + 13) - 30;
                p = 5;
            } else {
                n = n_old + 13;
                p = 4;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, p - 1);
        cal.set(Calendar.DATE, n);

        return cal.getTime();
    }

    private static boolean isInFile(String book) throws IOException {
        try (FileReader fileInvc = new FileReader("resources/Holidays.txt");
             BufferedReader readervc = new BufferedReader(fileInvc)) {
            String readvc = readervc.readLine();
            while (readvc != null) {
                if (readvc.contains(book)) {
                    return true;
                }
                readvc = readervc.readLine();
            }
            return false;
        }
    }


}
