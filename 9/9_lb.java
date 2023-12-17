import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;

public class WeatherWidget {
    private static final String API_KEY = "bd82977b86bf27fb59a04b61b657fb6f";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=LA&mode=json&appid=" + API_KEY;

    public static void main(String[] args) {
        try {
            String json = getJsonFromApi(API_URL);
            WeatherData weatherData = parseJson(json);

            // Генерация HTML виджета
            String htmlWidget = generateHtmlWidget(weatherData);
            System.out.println(htmlWidget);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }

    private static WeatherData parseJson(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        String city = jsonObject.get("name").getAsString();
        String countryCode = jsonObject.getAsJsonObject("sys").get("country").getAsString();
        String weatherDescription = jsonObject.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("description").getAsString();
        String iconId = jsonObject.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("icon").getAsString();
        double temperature = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        double pressure = jsonObject.getAsJsonObject("main").get("pressure").getAsDouble();
        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
        double minTemperature = jsonObject.getAsJsonObject("main").get("temp_min").getAsDouble();
        double maxTemperature = jsonObject.getAsJsonObject("main").get("temp_max").getAsDouble();
        double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
        double windDirection = jsonObject.getAsJsonObject("wind").get("deg").getAsDouble();
        int clouds = jsonObject.getAsJsonObject("clouds").get("all").getAsInt();

        return new WeatherData(city, countryCode, weatherDescription, iconId, temperature, pressure,
                humidity, minTemperature, maxTemperature, windSpeed, windDirection, clouds);
    }

    private static String generateHtmlWidget(WeatherData weatherData) {
        String iconUrl = "http://openweathermap.org/img/w/" + weatherData.getIconId() + ".png";

        return String.format("""
                <div>
                    <h1>%s, %s</h1>
                    <p>Current Weather: %s</p>
                    <p>Weather Description: %s</p>
                    <p>Temperature: %.2f°C</p>
                    <p>Pressure: %.2f mmHg</p>
                    <p>Humidity: %d%%</p>
                    <p>Min Temperature: %.2f°C</p>
                    <p>Max Temperature: %.2f°C</p>
                    <p>Wind: %.2f m/s %s</p>
                    <p>Cloudiness: %d%%</p>
                    <img src="%s" alt="Weather Icon">
                </div>
                """, weatherData.getCity(), weatherData.getCountryCode(), weatherData.getWeatherDescription(),
                weatherData.getWeatherDescription(), weatherData.getTemperature(), weatherData.getPressure(),
                weatherData.getHumidity(), weatherData.getMinTemperature(), weatherData.getMaxTemperature(),
                weatherData.getWindSpeed(), getWindDirection(weatherData.getWindDirection()), weatherData.getClouds(),
                iconUrl);
    }

    private static String getWindDirection(double degrees) {
        String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

        int index = (int) Math.round((degrees % 360) / 45.0) % 8;
        return directions[index];
    }
}

class WeatherData {
    private final String city;
    private final String countryCode;
    private final String weatherDescription;
    private final String iconId;
    private final double temperature;
    private final double pressure;
    private final int humidity;
    private final double minTemperature;
    private final double maxTemperature;
    private final double windSpeed;
    private final double windDirection;
    private final int clouds;

    public WeatherData(String city, String countryCode, String weatherDescription, String iconId,
                       double temperature, double pressure, int humidity, double minTemperature,
                       double maxTemperature, double windSpeed, double windDirection, int clouds) {
        this.city = city;
        this.countryCode = countryCode;
        this.weatherDescription = weatherDescription;
        this.iconId = iconId;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.clouds = clouds;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getIconId() {
        return iconId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public int getClouds() {
        return clouds;
    }
}