package restAssuredSwapi;


        import io.restassured.RestAssured;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.builder.ResponseSpecBuilder;
        import io.restassured.http.ContentType;
        import io.restassured.path.json.JsonPath;
        import io.restassured.response.Response;
        import io.restassured.specification.RequestSpecification;
        import io.restassured.specification.ResponseSpecification;
        import org.junit.jupiter.api.Test;

        import static io.restassured.RestAssured.*;
        import static org.hamcrest.Matchers.*;

    public class FindAllStarwarsCategories {

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

            //This is json response extraction.
            //Json path always expect string argument
            //Reusable method class contain the json response
            JsonPath js = ReusableMethod.rawToJson(checkCategories);

            //retrieve number of categories
            int countCategories = js.getInt("size()");
            System.out.println("Starwars categories: " + countCategories);
            System.out.println(checkCategories);

        }

    }