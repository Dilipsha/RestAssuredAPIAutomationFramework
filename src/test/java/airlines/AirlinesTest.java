package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JSonUtils;

import java.io.IOException;
import java.util.*;

public class AirlinesTest {

    @Test
    public void createAirlines() throws IOException {
        String env=System.getProperty("env")==null? "qa" : System.getProperty("env");
        Map<String,String> data= JSonUtils.getJSonDataAsMap("airlines/"+env+"/airlineApiData.json");
         String endPoint=data.get("createAirlineEndpoint");

    Map<String,Object> payload=Payload.getCreateAirlinePayloadFromMap("2","XYZ","India","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaaairways.com","1992");
    Response res= RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(res.statusCode(),200);

    }
}
