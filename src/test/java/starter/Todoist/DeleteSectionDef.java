package starter.Todoist;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class DeleteSectionDef {

    TodoistAPI todoistAPI;
    @Given("Delete section with valid id {long}")
    public void deleteSectionWithValidIdId(Long id) {
        todoistAPI.setDeleteSection(id);
    }

    @When("Send delete section with valid request")
    public void sendDeleteSectionWithValidRequest() {
        SerenityRest.when().delete(TodoistAPI.DELETE_SECTION);
    }

    @Then("Status code should with valid be {int} No Content")
    public void statusCodeShouldWithValidBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
