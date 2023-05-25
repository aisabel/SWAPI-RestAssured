package restAssuredExample;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class findAllTitleMoviesAndProducers {
    @Test
    public void findMovies() {
        RestAssured.baseURI = "https://swapi.dev/api/films/";
        String validatableResponse = given().
                when().get(baseURI).
                then().
                assertThat().
                statusCode(200).
                body("count", equalTo(6)).
                extract().response().asPrettyString();

        JsonPath js = ReusableMethod.rawToJson(validatableResponse);
        int countMovies = js.getInt("results.size()");
        System.out.println("Starwars movies: " + countMovies);
        //int countMovies = js.getInt("count.size()");
        for (int i = 0; i < countMovies; i++) {
            String movieTitle = js.get("results[" + i + "].title");
            String producerName = js.get("results[" + i + "].producer");
            System.out.println("'"+movieTitle+"' produced by: "+producerName);
        }
    }
}