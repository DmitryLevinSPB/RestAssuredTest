
import org.testng.annotations.Test;


import static io.restassured.path.json.JsonPath.given;


public class TesRestassured {


    @Test
            public void testGetUser () {
given().baseUri("https://reqres.in/api/users?page=2")
                .then().statusCode(200);

    }


}