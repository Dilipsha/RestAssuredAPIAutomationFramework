package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    public static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String,String> headers){
        return RestAssured.given().
                baseUri(endPoint).
                headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);

    }

    public static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("headers are " + queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request body is " + queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Header is " + response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response Body is" + response.getBody());
     //   ExtentReportManager.logInfoDetails("Request body is " + queryableRequestSpecification.getBody());

    }

    public static Response performPost(String endPoint, String requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification=getRequestSpecification(endPoint,requestPayload,headers);
        Response response=requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Map<String,Object> requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification=getRequestSpecification(endPoint,requestPayload,headers);
        Response response=requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }


}
