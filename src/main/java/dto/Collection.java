package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "collection_id",
        "title",
        "url",
        "description",
        "image_url",
        "res_count",
        "share_url"
})
public class Collection {

    @JsonProperty("collection_id")
    private String collectionId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("description")
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("res_count")
    private String resCount;
    @JsonProperty("share_url")
    private String shareUrl;

    @JsonProperty("collection_id")
    public String getCollectionId() {
        return collectionId;
    }

    @JsonProperty("collection_id")
    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("res_count")
    public String getResCount() {
        return resCount;
    }

    @JsonProperty("res_count")
    public void setResCount(String resCount) {
        this.resCount = resCount;
    }

    @JsonProperty("share_url")
    public String getShareUrl() {
        return shareUrl;
    }

    @JsonProperty("share_url")
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

}