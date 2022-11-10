package starter.Projects;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProjectsAPI {

    public static final String URL = "https://api.todoist.com";
    public static final String GET_ALL_PROJECTS = URL+"/rest/v1/projects";
    public static final String BEARER_TOKEN = "1a29eca8f7991cf41a06e51804191c6f61c6f1c2";

    @Step("Get all projects")
    public void getAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }
}