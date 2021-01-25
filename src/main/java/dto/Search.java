package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results_found",
        "results_start",
        "results_shown",
        "restaurants"
})
public class Search {

    @JsonProperty("results_found")
    private Integer resultsFound;
    @JsonProperty("results_start")
    private Integer resultsStart;
    @JsonProperty("results_shown")
    private Integer resultsShown;
    @JsonProperty("restaurants")
    private List<Restaurant> restaurants = null;

    @JsonProperty("results_found")
    public Integer getResultsFound() {
        return resultsFound;
    }

    @JsonProperty("results_found")
    public void setResultsFound(Integer resultsFound) {
        this.resultsFound = resultsFound;
    }

    @JsonProperty("results_start")
    public Integer getResultsStart() {
        return resultsStart;
    }

    @JsonProperty("results_start")
    public void setResultsStart(Integer resultsStart) {
        this.resultsStart = resultsStart;
    }

    @JsonProperty("results_shown")
    public Integer getResultsShown() {
        return resultsShown;
    }

    @JsonProperty("results_shown")
    public void setResultsShown(Integer resultsShown) {
        this.resultsShown = resultsShown;
    }

    @JsonProperty("restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @JsonProperty("restaurants")
    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
