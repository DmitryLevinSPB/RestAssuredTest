import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestRestAssured {

    @Test
            public void testGetUser () {
//Response response =

        given().
                baseUri("https://reqres.in").
                when().
                log().all().
                get("/api/users/{id}", 2).
                then().assertThat().
                log().all().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                header("Transfer-Encoding", "chunked").
                contentType("application/json; charset=utf-8").
                body("data.id", Matchers.equalTo(2));
        // ассерты вариант 2
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);

        // ассерты вариант 1

       //        System.out.printf("Status code: %s\n", response.getStatusCode());
//        System.out.printf("Status code: %s\n", response.asString());
    }

}