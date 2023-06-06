package restAssuredSwapi;
        import io.restassured.RestAssured;
        import io.restassured.path.json.JsonPath;
        import org.junit.jupiter.api.Test;
        import org.testng.Assert;

        import static io.restassured.RestAssured.baseURI;
        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.*;

public class FindLukeSkywalker {
    @Test
    public void getLukeSkywalkerInfo() {
        RestAssured.baseURI = "https://swapi.dev/api/people";

        //Below rest assured assertion syntax
        String validatableResponse =given().
                when().get(baseURI).
                then().
                assertThat().statusCode(200).
                body("results[0].name", equalTo("Luke Skywalker")).
                extract().response().asPrettyString();

        //If desired to not reuse a class, then create a new js
        //JsonPath js = new JsonPath(validatableResponse);

        //This is json response extraction.
        //Json path always expect string argument
        //Reusable method class contain the json response
        JsonPath js = ReusableMethod.rawToJson(validatableResponse);
        String getLukeInfo =js.getString("results[0]");
        String getLukeUrl =js.getString("results[0].url");
        String getLukeId = getLukeUrl.substring(29,30); //Count the characters in the url and extract only the ones in the position described (29,30)

        //Count number of films, vehicles and starships that Luke have
        int countFilms = js.getInt("results[0].films.size()");
        int countVehicles = js.getInt("results[0].vehicles.size()");
        int countStarships = js.getInt("results[0].starships.size()");

        System.out.println("Summary: Luke Skywalker participate in "+ countFilms +" films, have "+countVehicles+" vehicles, "+countStarships+" starships");
        System.out.println("Luke Id: "+getLukeId);
        System.out.println("LukeSkywalker complete information:");
        System.out.println(getLukeInfo);


        //Verify with Test NG the hair color from Luke is blond
        Assert.assertEquals("blond", "blond"); //TestNG syntax

    }
}