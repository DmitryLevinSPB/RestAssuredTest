import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.given;

public class Test1 {
@Test
    public void test1(){
    given() .baseUri ("https://www.ozon.ru")
            .when().get ("travel/?mwc_campaign=oztravel_horizontal-menu_flight")
            .then(). statusCode(200);

    }

}
