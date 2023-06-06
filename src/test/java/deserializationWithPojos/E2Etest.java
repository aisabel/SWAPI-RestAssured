package deserializationWithPojos;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class E2Etest {

    @Test
    public void printCategories() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        //DefaultParser is to define the content-type = json
        Categories response = given().expect().defaultParser(Parser.JSON).
                when().get(baseURI).as(Categories.class);

        System.out.println("Starwars Categories are: ");
        System.out.println(response.getFilms());
        System.out.println(response.getPeople());
        System.out.println(response.getPlanets());
        System.out.println(response.getSpecies());
        System.out.println(response.getStarships());
        System.out.println(response.getVehicles());
    }

    @Test
    public void printFilms() {
        RestAssured.baseURI = "https://swapi.dev/api/films/";
        //DefaultParser is to define the content-type = json
        Films response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Films.class);

        String countFilms = response.getCount();
        System.out.println("Starwars movies are: " + countFilms);

        for (int i = 0; i < response.getResults().size(); i++) {
            String movieTitle = response.getResults().get(i).getTitle();
            String directorName = response.getResults().get(i).getDirector();
            String producerName = response.getResults().get(i).getProducer();
            String releaseDate = response.getResults().get(i).getRelease_date();
            System.out.println("'"+movieTitle+"' directed by: "+directorName+" produced by: "+producerName+" released:"+releaseDate);

        }
    }
    @Test
    public void printPeople(){
        RestAssured.baseURI = "https://swapi.dev/api/people/";
        //DefaultParser is to define the content-type = json
        People response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(People.class);

        String countPeople = response.getCount();
        System.out.println("There are " + countPeople+" characters in the starwars universe");
        //Note: The api only return the first 10, however is possible to make search on any of the other characters using id
        System.out.println("This are the first 10:");

        for (int i = 0; i < response.getResults().size(); i++) {
            String characterName = response.getResults().get(i).getName();
            System.out.println(characterName);

        }
    }

    @Test
    public void printPlanets() {
        RestAssured.baseURI = "https://swapi.dev/api/planets/";
        //DefaultParser is to define the content-type = json
        Planets response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Planets.class);

        String countPlanets = response.getCount();
        System.out.println("Planets in the starwars universe:" + countPlanets);
        //Note: The api only return the first 10, however is possible to make search on any of the other planets using id
        System.out.println("This are the first 10:");
        for (int i = 0; i < response.getResults().size(); i++) {
            String planetName = response.getResults().get(i).getName();
            String climate = response.getResults().get(i).getClimate();
            String terrain = response.getResults().get(i).getTerrain();
            String population = response.getResults().get(i).getPopulation();
            System.out.println("'" + planetName + "' Climate: " + climate + ". Terrain: " + terrain + ". Population: " + population + " habitats");

        }
    }
    @Test
    public void printSpecies(){
        RestAssured.baseURI = "https://swapi.dev/api/species/";
        //DefaultParser is to define the content-type = json
        Species response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Species.class);
        String countSpecies = response.getCount();
        System.out.println("Species living in the starwars universe:" + countSpecies);
        //Note: The api only return the first 10, however is possible to make search on any of the other species using id
        System.out.println("This are the first 10:");
        for (int i = 0; i < response.getResults().size(); i++) {
            String speciesName = response.getResults().get(i).getName();
            String language = response.getResults().get(i).getLanguage();
            String lifeSpan = response.getResults().get(i).getAverage_lifespan();
            //String homeworld = response.getResults().get(i).getHomeworld();
            System.out.println("'"+speciesName+"'Language: "+language+" LifeSpan:"+lifeSpan+" years");

        }
    }
        @Test
        public void printStarships(){
            RestAssured.baseURI = "https://swapi.dev/api/starships/";
            //DefaultParser is to define the content-type = json
            Starships response = given().expect().defaultParser(Parser.JSON).
                    when().
                    get(baseURI).as(Starships.class);

            String countStarships = response.getCount();
            System.out.println("Starships in the starwars universe:" + countStarships);
            //Note: The api only return the first 10, however is possible to make search on any of the other starships using id
            System.out.println("This are the first 10:");
            for (int i = 0; i < response.getResults().size(); i++) {
                String starshipName = response.getResults().get(i).getName();
                String model = response.getResults().get(i).getModel();
                String manufacturer = response.getResults().get(i).getManufacturer();
                System.out.println("'"+starshipName+"' Model: "+model+". Manufacturer: "+manufacturer);

            }
    }

    @Test
    public void printVehicles(){
        RestAssured.baseURI = "https://swapi.dev/api/vehicles/";
        //DefaultParser is to define the content-type = json
        Vehicles response = given().expect().defaultParser(Parser.JSON).
                when().
                get(baseURI).as(Vehicles.class);

        String countVehicles = response.getCount();
        System.out.println("Vehicles in the starwars universe:" + countVehicles);
        //Note: The api only return the first 10, however is possible to make search on any of the other vehicles using id
        System.out.println("This are the first 10:");
        for (int i = 0; i < response.getResults().size(); i++) {
            String vehicleName = response.getResults().get(i).getName();
            String model = response.getResults().get(i).getModel();
            String manufacturer = response.getResults().get(i).getManufacturer();
            System.out.println("'"+vehicleName+"' Model: "+model+". Manufacturer: "+manufacturer);

        }
    }

}
