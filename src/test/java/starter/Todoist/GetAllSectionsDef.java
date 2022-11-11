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

public class GetAllSectionsDef {
    @Steps

    TodoistAPI todoistAPI;

    @Given("Get all section with valid project {long}")
    public void getAllSectionWithValidProjectId(Long id) {
        todoistAPI.setGetAllSections(id);
    }
    @When("Send get all section request")
    public void sendGetAllSectionRequest() {
        SerenityRest.when().get(TodoistAPI.GET_ALL_SECTION);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

//    @And("Response body page should be <page>")
//    public void responseBodyPageShouldBePage() {
//    }

//    @Given("Get an active task with id {long}")
//    public void getAnActiveTaskWitdIdId(Long id) {
//        todoistAPI.setGetAnActiveTask(id);
//    }
//
//    @When("Send Get an active tasks")
//    public void sendGetAnActiveTask() {
//        SerenityRest.when().get(TodoistAPI.GET_AN_ACTIVE_TASK);
//    }
//    @Then("Status code should be {long} OK")
//    public void statusCodeShouldBeOK(int OK) {
//        SerenityRest.then().statusCode(OK);
//    }
//    @And("Response body should be {long}")
//    public void responseBodyShouldBeId(Long id) {
//        SerenityRest.then().body(TodoistResponses.ID, equalTo(id));
//    }
//

}
