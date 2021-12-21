package date;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class BirthdayFile {

	public static Person run() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"resources/Birthdays.txt"));
			String line = reader.readLine();
			while (line != null) {
				Person p = fromLineToPerson(line);

				if (HolidayOrBDayNow.isBirthday(p)){
					return p;
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Person fromLineToPerson(String s) throws ParseException {
		Person p = new Person();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++){
			switch (i) {
				case 0 -> p.setName(words[i]);
				case 1 -> p.setSex(words[i]);
				case 2 -> p.setBirthdate(formatter.parse(words[i]));
				case 3 -> p.setEmail(words[i]);
				default -> System.out.println("In Birthday switch...case smth wrong");
			}
		}
		return p;
	}


}
