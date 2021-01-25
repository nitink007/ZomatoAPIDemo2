package actions;

import dto.City;
import dto.Collection;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.List;
import java.util.Map;

public class CollectionsApiAction extends ApiBaseActions {

    private final ApiEndpoints collectionsApi = ApiEndpoints.GetZomatoCollectionsInCity;

    public CollectionsApiAction() {
        super();
        apiExecutor = new ApiExecutor(collectionsApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    @Override
    public ApiEndpoints getEndpoint() {
        return collectionsApi;
    }

    public Response getCollectionsResponse(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return executeRequest();
    }

    public List<Collection> getCollections() {
        Response categoriesResponse = getResponse();
        JsonPath jsonPath = categoriesResponse.jsonPath();
        return jsonPath.getList("collections", Collection.class);
    }


}
