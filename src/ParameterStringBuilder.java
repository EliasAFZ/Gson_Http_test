import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * To facilitate the transformation of the parameter Map,
 * we have written a utility class called ParameterStringBuilder
 * containing a static method getParamsString() that transforms a
 * Map to a String of the required format:
 */

public class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> parameters){
        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, String> entry : parameters.entrySet()){
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0,resultString.length()-1)
                : resultString;
    }
}

