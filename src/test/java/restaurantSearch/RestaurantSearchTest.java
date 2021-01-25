package restaurantSearch;

import actions.CitiesApiAction;
import actions.SearchApiAction;
import base.BaseTest;
import dto.Restaurant_;
import dto.Search;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import testData.TestDataProvider;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantSearchTest extends BaseTest {

    /*
    *
    * Below are some of the test cases out of manny possible scenarios
    * but this framework is scalable as well as extendable to cater the needs for addition of further scenarios
    * Used action based approach for the API endpoints to have mor control over the the apis.
    *
    * */

    @Test(testName = "Verify that Restaurant Search API giving correct result based on Search query",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "SearchQuery")
    public void searchRestaurantByQuery(String query) {
        searchApiAction = new SearchApiAction();
        List<Restaurant_> restaurantList = searchApiAction.getRestaurantList(query);
        for (Restaurant_ restaurant : restaurantList) {
            assertThat(restaurant.getName()).containsIgnoringCase(query)
                    .describedAs("Restaurant name: " + restaurant.getName() + " NOT contains the searched query: " + query);
        }
    }

    @Test(testName = "Verify that Restaurant Search API giving correct result based on start index for search result",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "SearchIndex")
    public void searchRestaurantByStartIndex(String start, String count) {
        searchApiAction = new SearchApiAction();
        searchApiAction.clearQueryParams();
        searchApiAction.addQueryParams(searchApiAction.RESULTS_AFTER,start);
        searchApiAction.addQueryParams(searchApiAction.COUNT,count);
        Search searchResult = searchApiAction.getSearchResponse(searchApiAction.getQueryParams()).as(Search.class);
        assertThat(String.valueOf(searchResult.getResultsStart())).isEqualTo(start).describedAs("Start is NOT same and the query start");
        assertThat(String.valueOf(searchResult.getResultsShown())).isEqualTo(count).describedAs("Count is NOT same and the query Count");
    }

    @Test(testName = "Verify that Restaurant Search API giving correct result based on valid latitude and longitude",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "ValidaLatLon")
    public void searchRestaurantByLatLon(String lat, String lon) {
        searchApiAction = new SearchApiAction();
        searchApiAction.clearQueryParams();
        searchApiAction.addQueryParams(searchApiAction.LATITUDE,lat);
        searchApiAction.addQueryParams(searchApiAction.LONGITUDE,lon);
        List<Restaurant_> restaurantList = searchApiAction.getRestaurantList(searchApiAction.getQueryParams());
        for (Restaurant_ restaurant : restaurantList) {
            int convertedLatitude = new BigDecimal(String.valueOf(restaurant.getLocation().getLatitude())).intValue();
            int convertedLat = new BigDecimal(String.valueOf(lat)).intValue();
            int convertedLongitude = new BigDecimal(String.valueOf(restaurant.getLocation().getLongitude())).intValue();
            int convertedLon = new BigDecimal(String.valueOf(lon)).intValue();
            assertThat(convertedLatitude).isEqualTo(convertedLat)
                    .describedAs("Result restaurant Latitude: "+restaurant.getLocation().getLatitude()+" is NOT appox input Latitude: "+lat);
            assertThat(convertedLongitude).isEqualTo(convertedLon)
                    .describedAs("Result restaurant Longitude: "+restaurant.getLocation().getLongitude()+" is NOT appox input Longitude: "+lon);
        }
    }

    @Test(testName = "Verify that Restaurant Search API giving correct result based on entity_id and entity_type",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "ValidLocation")
    public void searchRestaurantByLocLocType(String entityId, String entityType, String cityName) {
        searchApiAction = new SearchApiAction();
        searchApiAction.clearQueryParams();
        searchApiAction.addQueryParams(searchApiAction.ENTITY_ID,entityId);
        searchApiAction.addQueryParams(searchApiAction.ENTITY_TYPE,entityType);
        List<Restaurant_> restaurantList = searchApiAction.getRestaurantList(searchApiAction.getQueryParams());
        for (Restaurant_ restaurant : restaurantList) {
            assertThat(restaurant.getLocation().getCity()).isEqualTo(cityName)
                    .describedAs("Result restaurant City: "+restaurant.getLocation().getCity()+
                            " is NOT as per the entityId: "+entityId+" and entityType: "+entityType);
        }
    }

    @Test(testName = "Verify HTTP 403 status code when invalid user-key is passed to the Cities api",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "invalidUserCredentials")
    public void verifySearchByInvalidQueryParam(String userKey, String invalidValue) {
        citiesApiAction = new CitiesApiAction();
        citiesApiAction.clearQueryParams();
        citiesApiAction.addQueryParams("q", "delhi");
        citiesApiAction.updateHeader(userKey,invalidValue);
        citiesApiAction.getCitiesResponse(citiesApiAction.getQueryParams());
        citiesApiAction.validateResponseStatus(HttpStatus.SC_FORBIDDEN);
    }

    @Test(testName = "Verify that Restaurant Search API giving correct result based on cuisine",
            dataProviderClass = TestDataProvider.class,
            dataProvider = "ValidCuisine")
    public void searchRestaurantByCollection(String cuisineId, String cuisineName, String cityId) {
        searchApiAction = new SearchApiAction();
        searchApiAction.clearQueryParams();
        searchApiAction.addQueryParams(searchApiAction.ENTITY_ID,cityId);
        searchApiAction.addQueryParams(searchApiAction.ENTITY_TYPE,"city");
        searchApiAction.addQueryParams(searchApiAction.CUISINES,cuisineId);
        List<Restaurant_> restaurantList = searchApiAction.getRestaurantList(searchApiAction.getQueryParams());
        for (Restaurant_ restaurant : restaurantList) {
            assertThat(restaurant.getCuisines()).containsIgnoringCase(cuisineName)
                    .describedAs("Result restaurant cuisine: "+restaurant.getCuisines()+
                            " NOT contains: "+cuisineName);
        }
    }

}
