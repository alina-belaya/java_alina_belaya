package date;

import java.text.SimpleDateFormat;
import java.util.Date;

class Holiday{
    protected String holidayName;
    protected Date holidayDate;

    Holiday(String holidayName, Date holidayDate){
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    public Holiday(){
        this.holidayDate = null;
        this.holidayName = null;
    }

    public void setHolidayName(String holidayName){
        this.holidayName = holidayName;
    }

    public String getHolidayName(){
        return holidayName;
    }

    public void setHolidayDate(Date holidayDate){
        this.holidayDate = holidayDate;
    }

    public String getHolidayDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
        return formatter.format(holidayDate);
    }

    @Override
    public String toString() {
        return holidayName + "-" + getHolidayDate();
    }
}
