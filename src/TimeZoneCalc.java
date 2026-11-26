import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;




public class TimeZoneCalc {

        public static String getLocalTime(Person person) {
            ZoneId zoneId = ZoneId.of(person.getTimeZone());
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return zonedDateTime.format(formatter);
        }

        public static boolean isAvailable(Person person) {
            // Simplified availability check
            ZoneId zoneId = ZoneId.of(person.getTimeZone());
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            
            int hour = zonedDateTime.getHour();
            
            if (hour >= 9 && hour < 21) {
                return true;
            } else {
                return false;
            }
        }

}



