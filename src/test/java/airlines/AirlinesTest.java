package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JSonUtils;

import java.io.IOException;
import java.util.*;

public class AirlinesTest extends AirlineAPIs{

    @Test
    public void createAirlines() throws IOException {
   Map<String,Object> payload=Payload.getCreateAirlinePayloadFromMap("9","XYZ","India","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaaairways.com","1992");
    Response res= createAirline(payload);
        Assert.assertEquals(res.statusCode(),200);

    }
}
