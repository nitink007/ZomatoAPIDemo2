package actions;

import dto.Category;
import enums.ApiEndpoints;
import enums.HttpMethod;
import executors.ApiExecutor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import validator.ApiResponseValidator;

import java.util.List;
import java.util.Map;

public class CategoriesApiAction  extends ApiBaseActions {

    private final ApiEndpoints categoriesApi = ApiEndpoints.GetRestaurantCategory;

    public CategoriesApiAction() {
        super();
        apiExecutor = new ApiExecutor(categoriesApi, HttpMethod.GET);
        apiResponseValidator = new ApiResponseValidator();
    }

    @Override
    public ApiEndpoints getEndpoint() {
        return categoriesApi;
    }

    public Response getCategoriesResponse() {
        clearQueryParams();
        return executeRequest();
    }

    public List<Category> getCategories() {
        Response categoriesResponse = getCategoriesResponse();
        JsonPath jsonPath = categoriesResponse.jsonPath();
        return jsonPath.getList("categories", Category.class);
    }


}
