package steps;

import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import resources.ApiResources;
import resources.TestDataBuilder;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {
    RequestSpecification request;
    Response response;
    TestDataBuilder data = new TestDataBuilder();
    public static String place_id;

    @Given("Add place payload with {string} {string}")
    public void add_place_payload(String name, String place) throws IOException {
        request=given().spec(requestSpecification()).body(data.addPlacePayload(name, place));
    }

    @When("User calls {string} API with {string} http request")
    public void user_calls_api_with_post_http_request(String resource, String method) {
        ApiResources apiResources = ApiResources.valueOf(resource);

        if(method.equalsIgnoreCase("post")){
            response = request.when().post(apiResources.getResource());
        }else if(method.equalsIgnoreCase("get")){
            response = request.when().get(apiResources.getResource());
        }else if(method.equalsIgnoreCase("delete")){
            response = request.when().delete(apiResources.getResource());
        }

    }

    @Then("The API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(int status) {
        Assertions.assertEquals(response.getStatusCode(),status);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String expected) {
        Assert.assertEquals(getStringJsonPath(response,key).toUpperCase(),expected.toUpperCase());
    }

    @Then("Verify place_id created maps to {string} using {string} API")
    public void verify_place_id_created_maps_to_using_api(String expectedName, String resource) throws IOException {
        place_id = getStringJsonPath(response,"place_id");
        request = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_api_with_post_http_request(resource,"GET");
        String actualName = getStringJsonPath(response,"name");
        Assert.assertEquals(actualName,expectedName);
    }

    @Given("Delete place payload")
    public void delete_place_payload() throws IOException {
        request = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }
}
