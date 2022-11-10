package starter.Projects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class
ProjectsStepDefinitions {
    @Steps
    ProjectsAPI projectsAPI;

    //Get All Project Positive Case
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

    //Create New Project Positive Case
    @Given("Post create a valid new project")
    public void postCreateAValidNewProject() {
        File json = new File(ProjectsAPI.JSON_REQ_BODY+"/CreateNewProject.json");
        projectsAPI.postCreateNewProject(json);
    }

    @When("Send post create project request")
    public void sendPostCreateProjectRequest() {
        SerenityRest.when().post(ProjectsAPI.CREATE_NEW_PROJECT);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
            SerenityRest.then()
                    .body(ProjectsResponse.NAME,equalTo(name));
    }

    @And("Validate project json schema validator")
    public void validateProjectJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/CreateNewProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}