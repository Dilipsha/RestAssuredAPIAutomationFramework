package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
    public static Faker faker=new Faker();

   public static String getRandomDataFor(RandomDataTypesName dataTypesName){
       switch (dataTypesName){
           case FIRSTNAME:
           return faker.name().firstName();
           case LASTNAME:
           return faker.name().lastName();
           case FULLNAME:
           return faker.name().fullName();
           case COUNTRY:
           return faker.address().country();
           case CITY:
           return faker.address().city();
           default:
               return "Data type name not available";
       }
   }

   public static String getRandomNumber(int count){
       return faker.number().digits(count);
   }

   public static String getRandomAlphabets(int count){
       return RandomStringUtils.randomAlphabetic(count);
   }

   public static String getRandomWebsiteName(){
       return "https://" + RandomDataGenerator.getRandomAlphabets(10) + ".com";
   }

   public static int getRandomNumber(int min,int max){
       return faker.number().numberBetween(min,max);
   }
}
