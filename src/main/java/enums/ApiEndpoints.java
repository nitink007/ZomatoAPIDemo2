package enums;

public enum ApiEndpoints {

    // Common API
    GetRestaurantCategory("/categories", ""), // Get list of Categories
    GetCityDetails("/cities", ""), // Get city details
    GetZomatoCollectionsInCity("/collections", ""), // Get Zomato collections in a city
    GetCuisinesInCity("/cuisines", ""), // Get list of all cuisines in a city
    GetRestaurantTypesInCity("/establishments", ""), // Get list of restaurant types in a city
    GetLocationDetails("/geocode", ""), // Get location details based on coordinates

    // Location API
    GetZomatoLocationDetails("/location_details", ""), // Get Zomato location details
    GetZomatoLocations("/locations", ""), // Search for locations

    // Restaurant API
    GetDailyMenu("/dailymenu", ""), // Get daily menu of a restaurant
    GetRestaurantDetails("/restaurant", ""), // Get restaurant details
    GetRestaurantReviews("/reviews", ""),
    GetRestaurants("/search", "schema/SearchRestaurantsSchema.json");

    private String resource;
    private String responseSchema;

    ApiEndpoints(String resource, String responseSchema)
    {
        this.resource=resource;
        this.responseSchema = responseSchema;
    }

    public String getResource() {
        return resource;
    }

    public String getResponseSchema() {
        return responseSchema;
    }
}
