package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class FruitResourceTest {


    @Test
    public void testGetFirstFruit() {
        given()
                .when().get("/fruits/1")
                .then()
                .statusCode(200)
                .body(is("APPLE"));
    }


    @Test
    public void testWithMethodReference() {
        given()
                .when().get("/fruits/with-method-reference/1")
                .then()
                .statusCode(200)
                .body(is("APPLE"));
    }

    @Test
    public void testWithMethodInvocation() {
        given()
                .when().get("/fruits/with-method-invocation/1")
                .then()
                .statusCode(200)
                .body(is("APPLE"));
    }

}