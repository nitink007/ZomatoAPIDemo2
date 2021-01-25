package actions;

import dto.Restaurant_;
import dto.Search;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This  class will contain the Action methods for the pojo.search api
 * */
public class SearchApiAction extends ApiBaseActions {

//    ApiExecutor apiExecutor;
//    ApiResponseValidator apiResponseValidator;

    // Private data members
//    private Map<String, String> queryParams;
    private ApiEndpoints searchApi = ApiEndpoints.GetRestaurants;

    public final String ENTITY_ID = "entity_id";
    public final String ENTITY_TYPE = "entity_type";
    public final String QUERY = "q";
    public final String RESULTS_AFTER = "start";
    public final String COUNT = "count";
    public final String LATITUDE = "lat";
    public final String LONGITUDE = "lon";
    public final String RADIUS = "radius";
    public final String CUISINES = "cuisines";
    public final String ESTABLISHMENT_TYPE = "establishment_type";

    public SearchApiAction() {
        super();
        apiExecutor = new ApiExecutor(searchApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    public ApiEndpoints getEndpoint() {
        return searchApi;
    }

    public Response getSearchResponse(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return executeRequest();
    }


    public List<Restaurant_> getRestaurantList(String searchQuery) {
        Map<String, String> query = new HashMap<>();
        query.put("q",searchQuery);
        setQueryParams(query);
        Response response = executeRequest();
        apiResponseValidator.validateResponseSuccess(response);
        apiResponseValidator.validateResponseSchema(response, searchApi);
        JsonPath jsonPath = response.jsonPath();
        List<Restaurant_> restaurants = jsonPath.getList("restaurants.restaurant", Restaurant_.class);

//        Gson gson = new Gson();
//        gson.fromJson(response.getBody().asString(), new TypeToken<List<Restaurant_>>() {}.getType());
//        Search search = gson.fromJson(response.getBody().asString(), Search.class);
        return restaurants;
    }

    public List<Restaurant_> getRestaurantList(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        Response response = executeRequest();
        apiResponseValidator.validateResponseSuccess(response);
        apiResponseValidator.validateResponseSchema(response, searchApi);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getList("restaurants.restaurant", Restaurant_.class);
    }



}
