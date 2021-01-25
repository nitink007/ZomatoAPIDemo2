package actions;

import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import validator.ApiResponseValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiBaseActions {

    // API Tools
    ApiExecutor apiExecutor;
    ApiResponseValidator apiResponseValidator;


    // Private data members
    private Response response;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> headers;



    public ApiBaseActions() {
        this.queryParams = new HashMap<>();
        this.pathParams = new HashMap<>();
    }

    public RequestSpecification getRequest() {
        return apiExecutor.getRequestSpecification();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void updateHeader(String headerName, String value) {
        apiExecutor.setRequestBuilder(apiExecutor.getRequestBuilder().addHeader(headerName, value));
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
//        this.queryParams.clear();
        this.queryParams = queryParams;
    }

    public void addQueryParams(Map<String, String> queryParams) {
        this.queryParams.putAll(queryParams);
    }

    public void addQueryParams(String queryParam, String value) {
        this.queryParams.put(queryParam, value);
    }

    public void clearQueryParams() {
        this.queryParams.clear();
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public void setPathParams(Map<String, String> pathParams) {
        this.pathParams = pathParams;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    // General functional Methods for API handling
    public abstract ApiEndpoints getEndpoint();

    public Response executeRequest() {
        if (MapUtils.isNotEmpty(queryParams)) {
             response = apiExecutor.executeWithQueryParams(queryParams).thenReturn();
        }
        if (MapUtils.isNotEmpty(pathParams)) {
            response = apiExecutor.executeWithPathParams(pathParams).andReturn();
        }
        if (MapUtils.isEmpty(queryParams)) {
            response = apiExecutor.executeAPI().andReturn();
        }
        return response;
    }

    public void validateResponseStatus(int httpStatus) {
        Assertions.assertThat(response).isNotNull().describedAs("Response is NULL");
        if (httpStatus==200) {
            apiResponseValidator.validateResponseSuccess(response);
        } else if (httpStatus==400) {
            apiResponseValidator.validateBadRequest(response);
        }
    }


}
