package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "restaurant"
})
public class Restaurant {

    @JsonProperty("restaurant")
    private Restaurant_ restaurant;

    @JsonProperty("restaurant")
    public Restaurant_ getRestaurant() {
        return restaurant;
    }

    @JsonProperty("restaurant")
    public void setRestaurant(Restaurant_ restaurant) {
        this.restaurant = restaurant;
    }

}