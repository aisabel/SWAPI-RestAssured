package restAssuredExample;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class findAllstarwarsCategories {

    @Test
    public void getAllCategories() {
        RestAssured.baseURI = "https://swapi.dev/api/";

        //Below rest assured assertion syntax
        String checkCategories = given().
                when().
                get(baseURI).
                then().
                assertThat().
                statusCode(200).
                body(notNullValue()).//check if body response is not null
                extract().response().asPrettyString();//extract response and print nicely

        JsonPath js = ReusableMethod.rawToJson(checkCategories);
        int countCategories;//for parsing json
        //count number of categories
        countCategories = js.getInt("size()");

        System.out.println(countCategories+" Starwars Categories exists: people, planets, films, species, vehicles, starships");
        System.out.println(checkCategories);

    }
}