package nova.api.webcontent.helper;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeCalculations {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static String WriteMissionTime(String Tijd, ZoneId ZoneId) {

        LocalDateTime dateTime = LocalDateTime.parse(Tijd, formatter);

        // Local time zone
        ZonedDateTime LokaalTijd = ZonedDateTime.of(dateTime, ZoneId);

        // Convert to GMT
        ZoneId ZoneServer = java.time.ZoneId.of("UTC");
        ZonedDateTime ServerDateTime = LokaalTijd.withZoneSameInstant(ZoneServer);


        return ServerDateTime.format(formatter);
    }

    public static String ReadMissionTime(String GMTDateTime, ZoneId ZoneForeign) {

        LocalDateTime dateTime = LocalDateTime.parse(GMTDateTime, formatter);

        ZoneId ZoneGMT = ZoneId.of("UCT");
        ZonedDateTime GMTTijd = ZonedDateTime.of(dateTime, ZoneGMT);
        //System.out.println("GMT: " + GMTTijd);

        ZonedDateTime foreignDateTime = GMTTijd.withZoneSameInstant(ZoneForeign);
        //System.out.println("Foreign: " + foreignDateTime);

        return foreignDateTime.format(formatter);
    }

    public static void main(String[] args) {

        String str = "2023-06-28 02:10";

        System.out.println(WriteMissionTime(str, ZoneId.of("Australia/Adelaide")));
        System.out.println(str);
    }
}


