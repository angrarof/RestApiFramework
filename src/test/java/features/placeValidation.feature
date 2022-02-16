Feature: Validating place API
  #https://github.com/cucumber/cucumber-jvm/blob/main/release-notes/v5.0.0.md#property-based-options
  #https://github.com/cucumber/cucumber-jvm/blob/main/core/src/main/java/io/cucumber/core/options/Constants.java
  #mvn test -Dcucumber.filter.tags="@AddPlace"

  @AddPlace
  Scenario Outline: Verify AddPlaceAPI
    Given Add place payload with "<name>" "<place>"
    When User calls "addPlace" API with "POST" http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_id created maps to "<name>" using "getPlace" API

    Examples:
      | name          | place     |
      | Angel Aguilar | All World |
      #| Angel Martin  | Musay     |

  @DeletePlace
  Scenario: Verify DeletePlaceAPI
    Given Delete place payload
    When User calls "deletePlace" API with "POST" http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"