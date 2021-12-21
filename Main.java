package date;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Holiday holiday = HolidayFile.run();
        Person persona = BirthdayFile.run();

        FrameCreate.frameMain(holiday, persona);
    }
}
