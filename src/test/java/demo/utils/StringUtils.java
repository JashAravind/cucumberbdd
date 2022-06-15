package demo.utils;

import java.nio.charset.StandardCharsets;

public class StringUtils {

    public String getUtf8Encoded (String rawString){
        byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);
        String encodedString = new String(bytes, StandardCharsets.UTF_8);
        return encodedString;
    }
}
