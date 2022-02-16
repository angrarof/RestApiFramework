package steps;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        StepDefinition stepDefinition = new StepDefinition();
        if(StepDefinition.place_id==null){
            stepDefinition.add_place_payload("Injected","Merida");
            stepDefinition.user_calls_api_with_post_http_request("addPlace","POST");
            stepDefinition.verify_place_id_created_maps_to_using_api("Injected","getPlace");
        }
    }
}
