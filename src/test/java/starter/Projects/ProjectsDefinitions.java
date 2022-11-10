package starter.Projects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class
ProjectsDefinitions {
    @Steps
    ProjectsAPI projectsAPI;

    //Get all Project Positive Case
    @Given("Get all projects valid parameter")
    public void getAllProjectsValidParameter() {
        projectsAPI.getAllProjects();
    }

    @When("Send all projects request")
    public void sendAllProjects() {
        SerenityRest.when().get(ProjectsAPI.GET_ALL_PROJECTS);
    }

    @Then("Status code is {int} OK")
    public void statusCodeIsOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
}