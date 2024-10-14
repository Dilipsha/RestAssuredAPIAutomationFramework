package airlines;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypesName;

import java.util.HashMap;
import java.util.Map;

public class Payload {

    public static String getCreateAirlinePayload(String id, String name,String country,String logo,String slogan,String head_quaters,
                                                 String website,String established){
        String payload="{\n" +
                "        \"id\": "+id+",\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"country\": \""+country+"\",\n" +
                "        \"logo\": \""+logo+"\",\n" +
                "        \"slogan\": \""+slogan+"\",\n" +
                "        \"head_quaters\": \""+head_quaters+"\",\n" +
                "        \"website\": \""+website+"\",\n" +
                "        \"established\": \""+established+"\"\n" +
                "}";
        return payload;
    }

    public static Map<String,Object> getCreateAirlinePayloadFromMap(String id, String name, String country, String logo, String slogan, String head_quaters,
                                                     String website, String established){
        Map<String,Object> payload=new HashMap<>();
        payload.put("id",id);
        payload.put("name",name);
        payload.put("country",country);
        payload.put("logo",logo);
        payload.put("slogan",slogan);
        payload.put("head_quaters",head_quaters);
        payload.put("website",website);
        payload.put("established",established);
        return payload;
    }

    public static Map<String,Object> getCreateAirlinePayloadFromMap(){

        Map<String,Object> payload=new HashMap<>();
        Faker faker=new Faker();
        payload.put("id",RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypesName.FIRSTNAME));
        payload.put("country",RandomDataGenerator.getRandomDataFor(RandomDataTypesName.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomAlphabets(10));
        payload.put("slogan",RandomDataGenerator.getRandomAlphabets(25));
        payload.put("head_quaters",RandomDataGenerator.getRandomDataFor(RandomDataTypesName.CITY));
        payload.put("website",RandomDataGenerator.getRandomWebsiteName());
        payload.put("established",RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
        return payload;
    }

}
