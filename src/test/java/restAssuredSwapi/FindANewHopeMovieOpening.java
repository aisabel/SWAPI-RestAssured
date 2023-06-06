package restAssuredSwapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class FindANewHopeMovieOpening {

    @Test
    public void isAnewHopeAstarwarsMovie() {
        RestAssured.baseURI = "https://swapi.dev/api/films/";

        String getOpening = given().
                        when().get(baseURI).
                        then().
                        assertThat().
                        statusCode(200).
                        body("count", equalTo(6)).
                        body("results[0].title", equalTo("A New Hope")). //Known array index in advance[0] and Verifying the title is as expected
                        extract().
                        path("results[0].opening_crawl"); //After assert title is as expected, extract required value (description opening)
                        //extract().response().asPrettyString(); would extract the query  and print it nicely. Handy in case of printing json

        //Above query doesn't need reusable method to print json. In this case opening is directly printed as a string text

        System.out.println("There are 6 movies in the starwars universe and 'a New Hope' is one of them");
        System.out.println("This is the 'A New Hope movie' introduction:");
        System.out.println(getOpening);

    }
}
