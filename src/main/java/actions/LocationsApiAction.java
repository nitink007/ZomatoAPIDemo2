package actions;

import dto.Collection;
import dto.ZomatoLocation;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.List;
import java.util.Map;

public class LocationsApiAction extends ApiBaseActions {

    public final String QUERY = "query";

    private final ApiEndpoints zomatoLocationsApi = ApiEndpoints.GetZomatoLocations;

    public LocationsApiAction() {
        super();
        apiExecutor = new ApiExecutor(zomatoLocationsApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    @Override
    public ApiEndpoints getEndpoint() {
        return zomatoLocationsApi;
    }

    public Response getZomatoLocationsResponse(Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return executeRequest();
    }

    public List<ZomatoLocation> getZomatoLocations() {
        Response zomatoLocationsResponse = getResponse();
        JsonPath jsonPath = zomatoLocationsResponse.jsonPath();
        return jsonPath.getList("location_suggestions", ZomatoLocation.class);
    }


}
