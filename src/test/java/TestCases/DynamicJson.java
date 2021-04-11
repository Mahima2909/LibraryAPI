package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jdk.jfr.DataAmount;
import org.testng.annotations.*;
import resources.Payload;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test(dataProvider = "BooksID")
    public void libAdd(String aisle, String isbn)
    {
        RestAssured.baseURI= "http://216.10.245.166";
        String response = given().log().all().
                header("Content-Type","application/json").
                body(Payload.libadd(aisle,isbn)).
        when().post("Library/Addbook.php").
        then().log().all().
                assertThat().statusCode(200).
                extract().response().asPrettyString();
        JsonPath js = new JsonPath(response);
        System.out.println("ID of added book: "+js.get("ID"));

    }
    @DataProvider(name="BooksID")
    public Object[][] getData()
    {
        return new Object[][]{{"bda","121"},{"bdn","122"},{"rdn","123"}};
    }

}
