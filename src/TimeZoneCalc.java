import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Uses Java's built-in Date and Time API to find a person's
 * local time and check if it is a good time to call them.
 */

public class TimeZoneCalc {

        public static String getLocalTime(Person person) {
            ZoneId zoneId = ZoneId.of(person.getTimeZone());
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            //diff time zones in diff dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return zonedDateTime.format(formatter);
        }

        public static boolean isAvailable(Person person) {
            // Simplified availability check
            ZoneId zoneId = ZoneId.of(person.getTimeZone());
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            
            int hour = zonedDateTime.getHour();

            //assume 9am to 9pm is a good time to call
            if (hour >= 9 && hour < 21) {
                return true;
            } else {
                return false;
            }
        }

}



