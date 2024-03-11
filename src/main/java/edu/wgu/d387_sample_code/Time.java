package edu.wgu.d387_sample_code;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public String[] getTime(){
        String[] times = new String[3];
        ZoneId eastern =ZoneId.of("America/New_York");
        ZoneId mountain =ZoneId.of("America/Denver");
        ZoneId utc = ZoneId.of("UTC");

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        ZonedDateTime zonedDateTimeUTC=localDateTime.atZone(utc);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();
        String text = localDateTimeUTC.format(formatter) + " UTC";
        times[2] = text;

        ZonedDateTime zonedDateTimeEastern=zonedDateTimeUTC.withZoneSameInstant(eastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        String text1 = localDateTimeEastern.format(formatter) + " ET";
        times[0] = text1;

        ZonedDateTime zonedDateTimeMountain=zonedDateTimeUTC.withZoneSameInstant(mountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
        String text2 = localDateTimeMountain.format(formatter) + " MT";
        times[1] = text2;


        return times;
    }
}
