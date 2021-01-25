package validator;

import enums.ApiEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiResponseValidator {

    public void validateResponseSuccess(Response response) {
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    public void validateBadRequest(Response response) {
        response.then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    public void validateResponseSchema(Response response, ApiEndpoints apiEndpoint) {
//        response.then().assertThat().body(matchesJsonSchemaInClasspath(apiEndpoint.getResponseSchema()));
    }

}
