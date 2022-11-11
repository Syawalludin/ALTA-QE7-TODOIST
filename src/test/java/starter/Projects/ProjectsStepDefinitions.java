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

    @And("Validate get all projects json schema validator")
    public void validateGetAllProjectsJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/GetAllProjectsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
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

    @And("Validate create project json schema validator")
    public void validateCreateProjectJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/CreateNewProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get Project Positive Case
    @Given("Get project valid id {long}")
    public void getProjectsValidIdId(long id) {
        projectsAPI.getProject(id);
    }

    @When("Send get project request")
    public void sendGetProjectRequest() {
        SerenityRest.when().get(ProjectsAPI.GET_PROJECT);
    }

    @And("Validate get project json schema validator")
    public void validateGetProjectJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/GetProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Update Project
    @Given("Post update project valid id {long}")
    public void postUpdateProjectWithValidJsonId(long id) {
        File json = new File(ProjectsAPI.JSON_REQ_BODY+"/UpdateProject.json");
        projectsAPI.updateProject(id, json);
    }

    @When("Send post update project request")
    public void sendPostUpdateProjectRequest() {
        SerenityRest.when().post(ProjectsAPI.UPDATE_PROJECT);
    }

    @And("Response update project body should contain name {string}")
    public void responseUpdateProjectBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(ProjectsResponse.NAME,equalTo(name));
    }

    @And("Validate post update project json schema validator")
    public void validatePostUpdateProjectJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/UpdateProjectSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Delete Project
    @Given("Task delete project with id {long}")
    public void taskDeleteProjectWithIdId(long id) {
        projectsAPI.deleteProject(id);
    }

    @When("Send task delete project request")
    public void sendTaskDeleteProjectRequest() {
        SerenityRest.when().delete(ProjectsAPI.DELETE_PROJECT);
    }

    @Then("Status code is {int} No Content")
    public void statusCodeIsNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Collaborator project with id {long}")
    public void collaboratorProjectWithIdId(long id) {
        projectsAPI.getAllCollaborator(id);
    }

    @When("Send collaborator project request")
    public void sendCollaboratorProjectRequest() {
        SerenityRest.when().delete(ProjectsAPI.GET_ALL_COLLABORATOR);
    }


    @And("Validate collaborator all project json schema validator")
    public void validateCollaboratorAllProjectJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/CollaboratorSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}