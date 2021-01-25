package actions;

import dto.Collection;
import dto.Cuisine;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.List;
import java.util.Map;

public class CuisinesApiAction extends ApiBaseActions {

    public final String CITY_ID = "city_id";

    private final ApiEndpoints cuisinesApi = ApiEndpoints.GetCuisinesInCity;

    public CuisinesApiAction() {
        super();
        apiExecutor = new ApiExecutor(cuisinesApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    @Override
    public ApiEndpoints getEndpoint() {
        return cuisinesApi;
    }

    public Response getCuisinesResponse(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return executeRequest();
    }

    public List<Cuisine> getCuisines() {
        Response cuisineResponse = getResponse();
        JsonPath jsonPath = cuisineResponse.jsonPath();
        return jsonPath.getList("cuisines.cuisine", Cuisine.class);
    }


}
