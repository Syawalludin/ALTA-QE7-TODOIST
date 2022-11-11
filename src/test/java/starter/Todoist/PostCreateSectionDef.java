package starter.Todoist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class PostCreateSectionDef {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Post new section with valid json")
    public void postNewSectionWithValidBody() {
        File json = new File(TodoistAPI.JSON_REQ_BODY + "/PostCreateSection.json");
        todoistAPI.setPostNewSection(json);
    }

    @When("Send post new section request")
    public void sendPostNewSectionRequest() {
        SerenityRest.when().post(TodoistAPI.POST_NEW_SECTION);
    }

    @Then("Status code should create be {int} OK")
    public void statusCodeShouldCreateBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

//    @And("Response body page should contain id {long} and project_id {long} and order {int} and name {string}")
//    public void responseBodyPageShouldContainIdIdAndProject_idProjectAndOrderOrderAndNameName(Long id, Long project, int order, String name) {
//        SerenityRest.then().body(TodoistResponses.ID, equalTo(id));
//        SerenityRest.then().body(TodoistResponses.PROJECT, equalTo(project));
//        SerenityRest.then().body(TodoistResponses.ORDER, equalTo(order));
//        SerenityRest.then().body(TodoistResponses.NAME, equalTo(name));
    @And("Response body page should contain id <id> and project_id <project> and order <order> and name <name>")
    public void responseBodyPageShouldContainIdIdAndProject_idProjectAndOrderOrderAndNameName(Long id, Long project, int order, String name) {
        SerenityRest.then().body(TodoistResponses.ID, equalTo(id));
        SerenityRest.then().body(TodoistResponses.PROJECT, equalTo(project));
        SerenityRest.then().body(TodoistResponses.ORDER, equalTo(order));
        SerenityRest.then().body(TodoistResponses.NAME, equalTo(name));
    }


    @And("Validate create section json schema")
    public void validateCreateSectionJsonSchema() {
        File json = new File(TodoistAPI.JSON_SCHEMA + "CreateSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}


