package microservicescourse.currencyexchangeserver.exchangevalue;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exchanger {

    private static final String USER_AGENT = "MOZILLA/5.0";

    public static String getExchangeMultiple(String from, String to) throws IOException, JSONException {
        String API_ENDPOINT = "https://free.currconv.com/api/v7/convert?q=" + from + "_" + to + "&compact=ultra&apiKey=9f4a133883a20e901e8d";
        HttpURLConnection connection = getHttpURLConnection(API_ENDPOINT);
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            JSONObject jsonObject = getResponse(connection);
            return jsonObject.getString(from + "_" + to);
        } else {
            return "Not Found";
        }
    }

    private static JSONObject getResponse(HttpURLConnection connection) throws IOException, JSONException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new JSONObject(String.valueOf(response));
    }

    private static HttpURLConnection getHttpURLConnection(String API_ENDPOINT) throws IOException {
        URL url = new URL(API_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("USER_AGENT", USER_AGENT);
        return connection;
    }
}
