package airlines;

import airlines.pojo.Airline;
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
    Airline payload=Payload.getCreateAirlinePayloadFromPojo();
    Response res= createAirline(payload);
        Assert.assertEquals(res.statusCode(),200);
    }
}