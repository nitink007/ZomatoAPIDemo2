package testData;

import actions.CollectionsApiAction;
import actions.CuisinesApiAction;
import actions.LocationsApiAction;
import dto.Cuisine;
import dto.ZomatoLocation;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataProvider {


    @DataProvider(name = "SearchQuery")
    public Object[][] getSearchQuery() {
        return new Object[][]{{"delhi"},{"radiant"}};
    }

    @DataProvider(name = "SearchIndex")
    public Object[][] getSearchIndex() {
        return new Object[][]{{"30","10"},{"50","15"}};
    }

    @DataProvider(name = "ValidaLatLon")
    public Object[][] getValidLatitudeLongitude() {
        LocationsApiAction locationsApiAction = new LocationsApiAction();
        locationsApiAction.clearQueryParams();
        locationsApiAction.addQueryParams(locationsApiAction.QUERY, "delhi");
        locationsApiAction.getZomatoLocationsResponse(locationsApiAction.getQueryParams());
        List<ZomatoLocation> zomatoLocations = locationsApiAction.getZomatoLocations();
        return new Object[][]{{zomatoLocations.get(0).getLatitude(),zomatoLocations.get(0).getLongitude()}};
    }

    @DataProvider(name = "ValidLocation")
    public Object[][] getValidLocationLocationType() {
        LocationsApiAction locationsApiAction = new LocationsApiAction();
        locationsApiAction.clearQueryParams();
        locationsApiAction.addQueryParams(locationsApiAction.QUERY, "Jaipur");
        locationsApiAction.getZomatoLocationsResponse(locationsApiAction.getQueryParams());
        List<ZomatoLocation> zomatoLocations = locationsApiAction.getZomatoLocations();
        return new Object[][]{{zomatoLocations.get(0).getEntityId(),
                                zomatoLocations.get(0).getEntityType(),
                                zomatoLocations.get(0).getCityName()}};
    }

    @DataProvider(name = "ValidCuisine")
    public Object[][] getValidCuisines() {
        CuisinesApiAction cuisinesApiAction = new CuisinesApiAction();
        cuisinesApiAction.clearQueryParams();
        cuisinesApiAction.addQueryParams(cuisinesApiAction.CITY_ID, "10");
        cuisinesApiAction.getCuisinesResponse(cuisinesApiAction.getQueryParams());
        List<Cuisine> cuisines = cuisinesApiAction.getCuisines();
        return new Object[][]{{cuisines.get(0).getCuisineId(),cuisines.get(0).getCuisineName(),"10"}};
    }


    @DataProvider(name = "invalidUserCredentials")
    public Object[][] getInvalidSearchQueryParam() {
        return new Object[][]{{"user-key","sadvsdv"}};
    }

}
