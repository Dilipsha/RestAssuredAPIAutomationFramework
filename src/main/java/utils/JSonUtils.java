package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSonUtils {

    private static ObjectMapper objMapper=new ObjectMapper();
    public static Map<String,String> getJSonDataAsMap(String JSonFileName) throws IOException {
        String completeJSonFilePath=System.getProperty("user.dir") + "/src/test/resources/" + JSonFileName;
        Map<String,String> data= objMapper.readValue(new File(completeJSonFilePath), new TypeReference<Map<String, String>>() {});
        return data;
    }
}
