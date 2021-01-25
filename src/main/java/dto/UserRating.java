package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aggregate_rating",
        "rating_text",
//        "rating_color",
//        "rating_obj",
        "votes"
})
public class UserRating {

    @JsonProperty("aggregate_rating")
    private Float aggregateRating;
    @JsonProperty("rating_text")
    private String ratingText;
//    @JsonProperty("rating_color")
//    private String ratingColor;
//    @JsonProperty("rating_obj")
//    private RatingObj ratingObj;
    @JsonProperty("votes")
    private Integer votes;

    @JsonProperty("aggregate_rating")
    public Float getAggregateRating() {
        return aggregateRating;
    }

    @JsonProperty("aggregate_rating")
    public void setAggregateRating(Float aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    @JsonProperty("rating_text")
    public String getRatingText() {
        return ratingText;
    }

    @JsonProperty("rating_text")
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

//    @JsonProperty("rating_color")
//    public String getRatingColor() {
//        return ratingColor;
//    }
//
//    @JsonProperty("rating_color")
//    public void setRatingColor(String ratingColor) {
//        this.ratingColor = ratingColor;
//    }
//
//    @JsonProperty("rating_obj")
//    public RatingObj getRatingObj() {
//        return ratingObj;
//    }
//
//    @JsonProperty("rating_obj")
//    public void setRatingObj(RatingObj ratingObj) {
//        this.ratingObj = ratingObj;
//    }

    @JsonProperty("votes")
    public Integer getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}