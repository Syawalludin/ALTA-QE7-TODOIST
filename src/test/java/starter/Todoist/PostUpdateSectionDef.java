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

public class PostUpdateSectionDef {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Post update section with valid json with {long}")
    public void postUpdateSectionWithValidJsonWithId(long id) {
        File json = new File(TodoistAPI.JSON_REQ_BODY+"/PostUpdateSection.json");
        todoistAPI.setPostUpdateSection(id,json);
    }

    @When("Send post update section request")
    public void sendPostUpdateSectionRequest() {
        SerenityRest.when().post(TodoistAPI.POST_UPDATE_SECTION);
    }

    @Then("Status code update should create be {int} No Content")
    public void statusCodeUpdateShouldCreateBeNoContent(int NoContent) {
        SerenityRest.then().statusCode(NoContent);
    }

    @And("Response body page should be id {long}")
    public void responseBodyPageShouldBeId(Long id) {
        SerenityRest.then().body(TodoistResponses.ID,equalTo(id));
    }



//    @And("Validate update section json schema")
//    public void validateUpdateSectionJsonSchema() {
//        File json = new File(TodoistAPI.JSON_SCHEMA+"UpdateSectionSchema.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }


}
