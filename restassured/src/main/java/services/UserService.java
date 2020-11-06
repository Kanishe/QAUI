package services;

import dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserService {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String CREATE_USER = "/user";


    RequestSpecification specification;

    public UserService() {
        specification = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

    public Response addUserRequest(User user, String basePath) {
        return given()
                .spec(specification)
                .with()
                .body(user)
                .when()
                .log().all()
                .post(basePath);
    }
}
