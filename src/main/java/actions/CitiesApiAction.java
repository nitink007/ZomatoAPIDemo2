package actions;

import dto.Category;
import dto.City;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.List;
import java.util.Map;

public class CitiesApiAction extends ApiBaseActions {

    private final ApiEndpoints citiesApi = ApiEndpoints.GetCityDetails;

    public CitiesApiAction() {
        super();
        apiExecutor = new ApiExecutor(citiesApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    @Override
    public ApiEndpoints getEndpoint() {
        return citiesApi;
    }

    public Response getCitiesResponse(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return executeRequest();
    }

    public List<City> getCities() {
        Response categoriesResponse = getResponse();
        JsonPath jsonPath = categoriesResponse.jsonPath();
        return jsonPath.getList("location_suggestions", City.class);
    }


}
