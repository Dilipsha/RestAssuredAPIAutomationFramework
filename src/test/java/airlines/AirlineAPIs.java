package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String,Object> createAilinePayload){
        String endPoint=Base.dataFormJsonFile.get("createAirlineEndpoint");
        return RestUtils.performPost(endPoint,createAilinePayload,new HashMap<>());
    }
}
