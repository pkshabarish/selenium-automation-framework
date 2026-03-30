package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // ✅ GET API
    @Test
    public void getUsers() {

        Response response = RestAssured
                .given()
                .when()
                .get("/users");

        System.out.println(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println("GET Passed");
    }

    // ✅ POST API
    @Test
    public void createUser() {

        String body = "{ \"name\": \"shabarish\", \"job\": \"QA\" }";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/posts");

        System.out.println(response.asString());

        Assert.assertEquals(response.getStatusCode(), 201);

        System.out.println("POST Passed");
    }

    // ✅ JSON Validation
    @Test
    public void validateUserName() {

        Response response = RestAssured
                .given()
                .when()
                .get("/users/1");

        String name = response.jsonPath().getString("name");

        Assert.assertNotNull(name);

        System.out.println("User Name: " + name);
    }
}