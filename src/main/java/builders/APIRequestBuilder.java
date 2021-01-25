package builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import utils.PropertiesUtil;

public class APIRequestBuilder {

    private RequestSpecBuilder builder;

    public RequestSpecBuilder getBuilder() {
        return builder;
    }

    public APIRequestBuilder() {
        builder = new RequestSpecBuilder();
        builder.setBaseUri(PropertiesUtil.getAppPropValues("baseUri"));
        builder.setContentType(ContentType.valueOf(PropertiesUtil.getAppPropValues("ContentType")));
        builder.setBasePath(PropertiesUtil.getAppPropValues("basePath"));
        builder.setAccept(ContentType.valueOf(PropertiesUtil.getAppPropValues("ContentType")));
        builder.addHeader("user-key", PropertiesUtil.getAppPropValues("user-key"));
    }

    public void resetRequestSpecBuilder() {
        builder = null;
    }
}
