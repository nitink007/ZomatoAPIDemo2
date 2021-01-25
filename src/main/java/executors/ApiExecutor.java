package executors;

import builders.APIRequestBuilder;
import enums.ApiEndpoints;
import enums.HttpMethod;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiExecutor {

    private RequestSpecBuilder builder;
    private HttpMethod method;
    private String uri;

    private RequestSpecification requestSpecification;

    public ApiExecutor(ApiEndpoints uri, HttpMethod method) {
        this.uri = uri.getResource();
        this.method = method;
        builder = new APIRequestBuilder().getBuilder();
    }

    public HttpMethod getMethod() {
        return method;
    }

    public RequestSpecification getRequestSpecification() {
        return this.requestSpecification;
    }

    public RequestSpecBuilder getRequestBuilder() {
        return this.builder;
    }

    public void setRequestBuilder(RequestSpecBuilder builder) {
        this.builder = builder;
    }

    /**
     * Method to execute the API for GET/POST/PUT/DELETE
     */
    public ResponseOptions<Response> executeAPI() {
        requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given().spec(requestSpecification);
        switch (method) {
            case GET:
                return request.get(this.uri);
            case POST:
                return request.post(this.uri);
            case PUT:
                return request.put(this.uri);
            case DELETE:
                return request.delete(this.uri);
            default:
                throw new IllegalArgumentException("Invalid/Not Supported HTTP Method");
        }
    }

    public ResponseOptions<Response> executeWithQueryParams(Map<String, String> queryParams) {
        builder.addQueryParams(queryParams);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithQueryParamsAndBody(Map<String, String> queryParams, String body) {
        builder.setBody(body);
        builder.addQueryParams(queryParams);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return executeAPI();
    }

}
