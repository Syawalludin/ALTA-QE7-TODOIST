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

    @And("Validate get all section json schema")
    public void validateGetAllSectionJsonSchema() {
        File json = new File(TodoistAPI.JSON_SCHEMA+"/GetAllSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
