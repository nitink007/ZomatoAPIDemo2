package base;

import actions.CitiesApiAction;
import actions.SearchApiAction;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Map;

public class BaseTest {

    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Response response;

    protected SearchApiAction searchApiAction;
    protected CitiesApiAction citiesApiAction;



    @BeforeTest
    public void beforeTest() {
        // Can utilize this space to have some data setup
        // Like loading data from excel of mutating the input data
    }

    @AfterTest
    public void afterTest() {
        // This is teardown
    }


}
