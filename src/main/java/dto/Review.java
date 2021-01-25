package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "review"
})
public class Review {

    @JsonProperty("review")
    private List<Object> review = null;

    @JsonProperty("review")
    public List<Object> getReview() {
        return review;
    }

    @JsonProperty("review")
    public void setReview(List<Object> review) {
        this.review = review;
    }

}