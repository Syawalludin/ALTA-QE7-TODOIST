package starter.Todoist;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TodoistAPI {

    private static String GET_ALL_PROJECTS = "https://api.todoist.com/rest/v1/projects";
    public static final String BEARER_TOKEN = "1a29eca8f7991cf41a06e51804191c6f61c6f1c2";

    @Step("Get location by postcode")
    public void getAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .get(GET_ALL_PROJECTS);
    }
}

