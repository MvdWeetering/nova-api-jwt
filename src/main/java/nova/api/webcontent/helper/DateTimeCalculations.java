package nova.api.webcontent.helper;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeCalculations {


    public static String WriteMissionTime(LocalDateTime Tijd, DateTimeFormatter formatter, ZoneId ZoneId) {

        // Local time zone
        ZonedDateTime LokaalTijd = ZonedDateTime.of(Tijd, ZoneId);
        //System.out.println("From: " + LokaalTijd);

        // Convert to GMT
        ZoneId ZoneServer = java.time.ZoneId.of("UTC");
        ZonedDateTime ServerDateTime = LokaalTijd.withZoneSameInstant(ZoneServer);
        //System.out.println("To: " + ServerDateTime);

        return ServerDateTime.format(formatter);
    }

    public static String ReadMissionTime(LocalDateTime GMTDateTime,DateTimeFormatter formatter, ZoneId ZoneForeign) {

        // GMT
        ZoneId ZoneGMT = ZoneId.of("UCT");
        ZonedDateTime GMTTijd = ZonedDateTime.of(GMTDateTime, ZoneGMT);
        //System.out.println("GMT: " + GMTTijd);

        // Convert to Local
        ZonedDateTime foreignDateTime = GMTTijd.withZoneSameInstant(ZoneForeign);
        //System.out.println("Foreign: " + foreignDateTime);

        return foreignDateTime.format(formatter);
    }

    public static void main(String[] args) {

        String str = "2023-06-28 02:10";
////
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//
        System.out.println(WriteMissionTime(dateTime, formatter, ZoneId.of("Australia/Adelaide")));

//      System.out.println();
        System.out.println(str);
    }
}

