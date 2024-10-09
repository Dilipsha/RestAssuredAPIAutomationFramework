package airlines;

import utils.JSonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    static Map<String,String> dataFormJsonFile;
    static {
        String env=System.getProperty("env")==null? "qa" : System.getProperty("env");
        try{
             dataFormJsonFile= JSonUtils.getJSonDataAsMap("airlines/"+env+"/airlineApiData.json");
           // String endPoint=data.get("createAirlineEndpoint");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
