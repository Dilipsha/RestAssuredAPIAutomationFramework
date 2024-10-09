package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JSonUtils;

import java.util.*;

public class AirlinesTest {

    @Test
    public void createAirlines(){

        Map<String,String> data= JSonUtils.getJSonDataAsMap("/src/test/resources/airlines/qa/")
    String endPoint="https://api.instantwebtools.net/v1/airlines";

    Map<String,Object> payload=Payload.getCreateAirlinePayloadFromMap("2","XYZ","India","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
            "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaaairways.com","1992");
    Response res= RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(res.statusCode(),200);

    }
}
