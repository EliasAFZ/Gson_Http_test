import com.google.gson.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * GsonTest
 * 9/21/2019
 * Description: This small project was meant to explore the Gson library from google and
 * using javas built in function HttpUrlConnection http requests GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE.
 *
 * @Author Elias Afzalzada
 * © All Rights Reserved
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing some Gson");

        // make an object into a json
        //serializeUserSample();
        // make a json into a pojo(java object)
        //deserializeUserSample();

        //createRequestToSoundCloud();
    }

    private static void createRequestToSoundCloud() throws IOException {
        /**
         * A HttpUrlConnection instance is created by using the
         * openConnection() method of the URL class. Note that
         * this method only creates a connection object, but
         * does not establish the connection yet.
         *
         * The HttpUrlConnection class is used for all types of
         * requests by setting the requestMethod attribute to one
         * of the values: GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE.
         */
        URL url = new URL("https://api-v2.soundcloud.com/search?");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        /**
         * If we want to add parameters to a request, we have to set the doOutput
         * property to true, then write a String of the form param1=value¶m2=value
         * to the OutputStream of the HttpUrlConnection instance:
         */

        //EX: www.youtube.com/watch?    v(key)   =  dQw4w9WgXcQ(value)
        Map<String, String> parameters = new HashMap<>();
        parameters.put("q", "postmalone");
        parameters.put("client_id", "wbUogYOWuXzMPNom10DSNs41FFcCbEOT");


        connection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        outputStream.flush();
        outputStream.close();
    }

    private static void serializeUserSample() {
        userSample objectTest = new userSample(
                "Elias",
                "eliasafz@outlook.com",
                27,
                true
        );
        Gson gson = new Gson();
        String json = gson.toJson(objectTest);
    }

    private static void deserializeUserSample() {
        // single quotes for param names instead of double as to avoid escape marks
        String json = "{'name':Elias,'email':'eliasafz@outlook.com','age':25,'isDeveloper':true}";
        Gson gson = new Gson();
        // incoming json maps to the class and the appropriate properties have to know whats incoming though
        userSample object = gson.fromJson(json, userSample.class);
    }
}
