package albert.practice.datetime;

import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarExample {

    public Date setHourAndMinute1(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        /*
         * Field number for get and set indicating the hour of the day. HOUR_OF_DAY is used for the
         * 24-hour clock. E.g., at 10:04:15.250 PM the HOUR_OF_DAY is 22.
         */
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        return calendar.getTime();
    }

    public Date setHourAndMinute2(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        /*
         * Field number for get and set indicating the hour of the morning or afternoon. HOUR is
         * used for the 12-hour clock (0 - 11). Noon and midnight are represented by 0, not by 12.
         * E.g., at 10:04:15.250 PM the HOUR is 10.
         */
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);

        return calendar.getTime();
    }

    public static void main(String[] args) {
        CalendarExample test = new CalendarExample();
        int hour = 13, minute = 0;
        log.debug("date1 = " + test.setHourAndMinute1(hour, minute));
        log.debug("date2 = " + test.setHourAndMinute2(hour, minute));
    }
}
