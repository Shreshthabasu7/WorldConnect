import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

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

       
}
