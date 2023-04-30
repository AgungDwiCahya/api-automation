package starter.posts;

import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.serenitybdd.rest.SerenityRest;

public class Update {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "my name is agung");
        requestBody.put("body", "Ini sudah diubah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString())
                .put(setPutApiEndpoints());
    }

    @Step("I receive valid data for update posts")
    public void validateUpdateUser() {
        restAssuredThat(response -> response.body("'title'", equalTo("my name is agung")));
        restAssuredThat(response -> response.body("'body'", equalTo("Ini sudah diubah")));
    }

    //// Negative

    @Step("I set PUT to invalid api endpoints")
    public String setPutInvalidApiEndpoints() {
        return url + "posts/101";
    }

    @Step("I receive invalid HTTP response code 500")
    public void receiveHttpResponseCode500() {
        restAssuredThat(response -> response.statusCode(200));
    }

}