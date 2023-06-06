package restAssuredSwapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    //Build Request Spec Builder
    RequestSpecification  requestSpec = new RequestSpecBuilder().
            setBaseUri("https://swapi.dev").
            setContentType(ContentType.JSON).
            build();

    //Build Response Spec Builder
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType(ContentType.JSON).
            build();
}
