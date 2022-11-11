package starter.Projects;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ProjectsAPI {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/jsonScema";

    public static final String BEARER_TOKEN = "9493ffaa6194d2417c1b364cebb48d9232114a9a";

    public static final String GET_ALL_PROJECTS = URL+"/rest/v1/projects";
    public static final String INVALID_GET_ALL_PROJECTS = URL+"/rest/v1/project";
    public static final String CREATE_NEW_PROJECT = URL+"/rest/v1/projects";
    public static final String GET_PROJECT = URL+"/rest/v1/projects/{id}";
    public static final String UPDATE_PROJECT = URL+"/rest/v1/projects/{id}";
    public static final String DELETE_PROJECT = URL+"/rest/v1/projects/{id}";
    public static final String GET_ALL_COLLABORATOR = URL+"/rest/v1/projects/{id}/collaborators";

    //Get All Project Positive Case
    @Step("Get all projects")
    public void getAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }

    //Get All Project Negative Case
    @Step("Invalid get all projects")
    public void invalidGetAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }

    //Create New Project Positive Case
    @Step("Post create new project")
    public void postCreateNewProject(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get Project Positive Case
    @Step("Get project")
    public void getProject(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Update project")
    public void updateProject(long id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Project
    @Step("Delete project")
    public void deleteProject(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    //Collaborator Project
    @Step("Get all collaborator")
    public void getAllCollaborator(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
}