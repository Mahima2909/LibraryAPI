package resources;

public class Payload {

        public static String libadd(String isbn, String aisle) {
                String libadd="{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe2\"\n" +
                "}";
                return libadd;
        }
}
