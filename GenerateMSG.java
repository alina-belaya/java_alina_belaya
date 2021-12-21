package date;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GenerateMSG {
    final static String[] new_year = {"Sending you the very best of wishes for the new year. May it be full of bright opportunities!",
            "Congratulations on a great year, and warm wishes to you and your family throughout the holiday season.",
            "Wishing you a joyous Holiday season and a happy and peaceful New Year.",
            "Happy New Year to you! May the upcoming year bring you holy blessings and peace!",
            "May the new year offers a fresh start to your life. May you have all your dreams fulfilled. Have a great year ahead!"};
    final static String[] valentines_day = {"Happy Valentine’s Day! Wishing you a beautiful day filled with love and happiness, you deserve it!",
            "Happy Valentine’s Day. Wishing one super sweet soul an equally sweet day!",
            "Wishing you a very Happy Valentine’s Day! Hoping it’s the best one yet."};
    final static String[] womens_day = {"Women can do anything! Congratulations on International Women's Day!",
            "Congratulations, lovely woman. Today you deserve our most beautiful flowers and poetry!",
            "Behind every successful woman is Herself. Have a wonderful Women's Day!"};
    final static String[] christmas = {"Happy Holidays! I hope all of your Christmas wishes come true.",
            "Merry Christmas! May you get chance to take in the beauty and true meaning of the season.",
            "Wishing you nothing but happiness this holiday season! Merry Christmas from all of us.",
            "Merry Christmas! May your happiness be large and your be bills small.",
            "May the true spirit of Christmas shine in your heart and light your path."};
    final static String[] defender_day = {"You hold a special place in my life and today is a day to celebrate all that you are and stand for. Happy Defender’s Day!",
            "A day to celebrate the warmth and strength a man brings in our lives. Happy Defender’s Day!",
            "Wishing all the men in my life Happy Defender’s Day. You are loved and appreciated today and always!"};
    final static String[] easter_day = {"Happy Easter! May this day be as special and beautiful as you.",
            "Thinking of you on this special day! Best wishes for Easter and the season ahead.",
            "Wishing you sunshine and a basket full of chocolate on this beautiful day. Happy Easter!"};

    public static String generateMessage(Person person, String occasion){
        return "Dear " + person.getName() + ",\r\n" + bDayMSG() + "\r\nFrom Alina.";
    }

    public static String generateMessage(String occasion){
        return hMSG(occasion) + "\r\nFrom Alina.";
    }

    public static String bDayMSG(){
        String path = new File("D://BdayCongratulations.txt").getAbsolutePath();
        return getRandomLine(path);
    }

    private static String getRandomLine(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Random random = new Random();
        return lines.get(random.nextInt(lines.size()));
    }

    public static String hMSG(String occasion){
        int index;
        Random random = new Random();
        switch (occasion){
            case "Новий рік":
                index = random.nextInt(new_year.length);
                return new_year[index];
            case "День Валентина":
                index = random.nextInt(valentines_day.length);
                return valentines_day[index];
            case "8 березня":
                index = random.nextInt(womens_day.length);
                return womens_day[index];
            case "Різдво":
                index = random.nextInt(christmas.length);
                return christmas[index];
            case "14 жовтня":
                index = random.nextInt(defender_day.length);
                return defender_day[index];
            case "Великдень":
                index = random.nextInt(easter_day.length);
                return easter_day[index];
            default: return "Congratulations!";
        }
    }
}
