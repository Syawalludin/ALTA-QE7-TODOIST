package starter.Todoist;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteSectionDef {

    //sekarang coba mb kasi @Steps disini aq lihat
    @Steps

    TodoistAPI todoistAPI;
    @Given("Delete section with valid id {long}")
    public void deleteSectionWithValidIdId(long id) {
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
