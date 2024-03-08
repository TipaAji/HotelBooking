package edu.wgu.d387_sample_code;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public LocalTime[] getTime(){
        LocalTime[] times = new LocalTime[3];
        ZoneId eastern =ZoneId.of("America/New_York");
        ZoneId mountain =ZoneId.of("America/Denver");
        ZoneId utc = ZoneId.of("UTC");

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        ZonedDateTime zonedDateTimeUTC=localDateTime.atZone(utc);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();
        String text = localDateTimeUTC.format(formatter);
        times[2] = LocalTime.parse(text, formatter);

        ZonedDateTime zonedDateTimeEastern=zonedDateTimeUTC.withZoneSameInstant(eastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        String text1 = localDateTimeEastern.format(formatter);
        times[0] = LocalTime.parse(text1, formatter);

        ZonedDateTime zonedDateTimeMountain=zonedDateTimeUTC.withZoneSameInstant(mountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
        String text2 = localDateTimeMountain.format(formatter);
        times[1] = LocalTime.parse(text2, formatter);


        return times;
    }
}
