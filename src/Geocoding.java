import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Uses the Open-Meteo Geocoding API to get the coordinates
 * and time zone of a city.
 *
 * I chose Open-Meteo over Google Maps because it returns
 * both in one request without needing an API key.
 *
 * Reference: https://open-meteo.com/en/docs/geocoding-api
 */  

public class Geocoding {
    public static String searchLocation(String city)
            throws IOException {

        String encodedCity = URLEncoder.encode(city,
        StandardCharsets.UTF_8);

        String address = "https://geocoding-api.open-meteo.com/v1/search?name="
        + encodedCity + "&count=1";

        URL url = URI.create(address).toURL();
        URLConnection connection = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String result = "";
        String line;

        while ((line = in.readLine()) != null) {
            result += line;
        }

        in.close();

        return result;
    }

    public static double getLatitude(String result) {
        int start = result.indexOf("\"latitude\":") + 11;
        int end = result.indexOf(",", start);

        return Double.parseDouble(result.substring(start, end));
    }

    public static double getLongitude(String result) {
        int start = result.indexOf("\"longitude\":") + 12;
        int end = result.indexOf(",", start);

        return Double.parseDouble(result.substring(start, end));
    }

    public static String getTimeZone(String result) {
        int start = result.indexOf("\"timezone\":") + 12;
        int end = result.indexOf("\"", start);

        return result.substring(start, end);
    }

    public static Person createPerson(String name, String city)
        throws IOException {

        String result = searchLocation(city);

        if (!result.contains("\"latitude\":")
                || !result.contains("\"longitude\":")
                || !result.contains("\"timezone\":\"")) {
            throw new IOException("Location not found");
        }

        double latitude = getLatitude(result);
        double longitude = getLongitude(result);
        String timeZone = getTimeZone(result);

        return new Person(name, city, timeZone, latitude, longitude);
    }

       
}
