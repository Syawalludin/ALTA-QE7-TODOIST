package starter.Projects;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ProjectsAPI {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/features/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/features/JSON/Schema";

    public static final String BEARER_TOKEN = "181d382f2da19201acc048d06cc5602ed7a15491";

    public static final String GET_ALL_PROJECTS = URL+"/rest/v2/projects";
    public static final String CREATE_NEW_PROJECT = URL+"/rest/v2/projects/";
    public static final String GET_PROJECT = URL+"/rest/v2/projects/{id}";
    public static final String UPDATE_PROJECT = URL+"/rest/v2/projects/{id}";
    //Get All Project Positive Case
    @Step("Get all projects")
    public void getAllProjects() {
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
}