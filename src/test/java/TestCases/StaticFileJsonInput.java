package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Payload;

import java.io.IOException;
import java.nio.file.*;

import static io.restassured.RestAssured.given;

public class StaticFileJsonInput {
    //Static file as input-> Read File to Bytes -> Convert Bytes to String
    @Test()
    public void libAdd() throws IOException {
        RestAssured.baseURI= "http://216.10.245.166";
        String response = given().log().all().
                header("Content-Type","application/json").
                body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Mahima\\IdeaProjects\\LibraryAPI\\src\\main\\resources\\libadd.json")))).
        when().post("Library/Addbook.php").
        then().log().all().
                assertThat().statusCode(200).
                extract().response().asPrettyString();
        JsonPath js = new JsonPath(response);
        System.out.println("ID of added book: "+js.get("ID"));

    }


}
