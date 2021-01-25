package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cuisine_id",
        "cuisine_name"
})
public class Cuisine {

    @JsonProperty("cuisine_id")
    private String cuisineId;
    @JsonProperty("cuisine_name")
    private String cuisineName;

    @JsonProperty("cuisine_id")
    public String getCuisineId() {
        return cuisineId;
    }

    @JsonProperty("cuisine_id")
    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }

    @JsonProperty("cuisine_name")
    public String getCuisineName() {
        return cuisineName;
    }

    @JsonProperty("cuisine_name")
    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

}