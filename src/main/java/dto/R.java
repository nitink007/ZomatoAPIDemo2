package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "res_id",
        "is_grocery_store"
})
public class R {

    @JsonProperty("res_id")
    private Integer resId;
    @JsonProperty("is_grocery_store")
    private Boolean isGroceryStore;

    @JsonProperty("res_id")
    public Integer getResId() {
        return resId;
    }

    @JsonProperty("res_id")
    public void setResId(Integer resId) {
        this.resId = resId;
    }

    @JsonProperty("is_grocery_store")
    public Boolean getIsGroceryStore() {
        return isGroceryStore;
    }

    @JsonProperty("is_grocery_store")
    public void setIsGroceryStore(Boolean isGroceryStore) {
        this.isGroceryStore = isGroceryStore;
    }


}