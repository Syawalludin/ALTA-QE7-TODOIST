package starter.Todoist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetSingleSectionDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Get single section with valid {long}")
    public void getSingleSectionWithValidId(long id) {
        todoistAPI.setGetSingleSections(id);
    }
    @When("Send get single section request")
    public void sendGetSingleSectionRequest() {
        SerenityRest.when().get(TodoistAPI.GET_SINGLE_SECTIONS);
    }

    @Then("Status code single section should be {int} OK")
    public void statusCodeSingleSectionShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body single section page should be <page>")
    public void responseBodySingleSectionPageShouldBeId() {
    }

    @And("Validate get single section json schema")
    public void validateGetSingleSectionJsonSchema() {
        File json = new File(TodoistAPI.JSON_SCHEMA+"/GetSingleSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
