package restAssuredExample;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class findNewHopeMovieOpening {

    @Test
    public void isAnewHopeAstarwarsMovie() {
       RestAssured.baseURI = "https://swapi.dev/api/films/";
        String validatableResponse = given().
                when().get(baseURI).
                then().
                assertThat().
                statusCode(200).
                body("count", equalTo(6)).
                body("results[0].title", equalTo("A New Hope")).
                extract().response().asPrettyString();

        if (null != validatableResponse){
            System.out.println("There are 6 movies in the starwars universe and 'a New Hope' is one of them");
            String getOpening =
                    given().
                            when().
                            get(baseURI).
                            then().
                            body("results[0].title", equalTo("A New Hope")).
                            extract().
                            path("results[0].opening_crawl");
            System.out.println("This is the 'A New Hope movie' introduction:");
            System.out.println(getOpening);
        }
        else{ System.out.println("No movie available");}
    }
}