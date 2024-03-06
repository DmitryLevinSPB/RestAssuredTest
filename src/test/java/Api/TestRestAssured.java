import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestRestAssured {

    @Test
    public void testGetUser() {
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
                body("data.id", equalTo(2)).
                body("data.email", equalTo("janet.weaver@reqres.in")).
                body("data.first_name", equalTo("Janet"))
        ;

        // ассерты вариант 2
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);

        // ассерты вариант 1

        //        System.out.printf("Status code: %s\n", response.getStatusCode());
//        System.out.printf("Status code: %s\n", response.asString());
    }

    @Test
    public void testGetUsers() {
//Response response =

        given().
                baseUri("https://reqres.in").
                queryParam("page", "1").
                when().
                log().all().
                get("/api/users").
                then().assertThat().
                log().all().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                header("Transfer-Encoding", "chunked").
                contentType("application/json; charset=utf-8").
                body("data[1].id", equalTo(2)).
                body("data[1].email", equalTo("janet.weaver@reqres.in")).
                body("data[1].first_name", equalTo("Janet"))
        ;

    }
}