package starter.Todoist;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class
TodoistStepDefinitions {
    @Steps
    TodoistAPI todoistAPI;

    @When("Get all projects request")
    public void lookAllProjects() {
        todoistAPI.getAllProjects();
    }

    @Then("Status code is {int} OK")
    public void statusCodeIs(int OK) {
        SerenityRest.then().statusCode(OK);
    }
}