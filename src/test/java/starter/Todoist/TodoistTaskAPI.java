package starter.Todoist;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TodoistTaskAPI {

    public static final String URL = "https://api.todoist.com/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REG_BODY = DIR + "/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCEMA = DIR + "/src/test/resources/JSON/jsonScema";
    public static final String BEARER_TOKEN = "181d382f2da19201acc048d06cc5602ed7a15491";
    public static String GET_ACTIVE_TASK = URL + "rest/v1/tasks";
    public static String CREATE_A_NEW_TASK = URL + "rest/v1/tasks";
    public static String GET_AN_ACTIVE_TASK = URL + "rest/v1/tasks/{id}";
    public static String UPDATE_A_TASK = URL + "rest/v1/tasks/{id}";
    public static String CLOSE_A_TASK = URL + "rest/v1/tasks/{id}/close";
    public static String REOPEN_A_TASK = URL + "rest/v1/tasks/{id}/reopen";
    public static String DELETE = URL +"rest/v1/tasks/{id}";


    @Step("Get Active Task")
    public void setGetActiveTask(){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                            .get(GET_ACTIVE_TASK);
    }

    @Step("Create a new task")
    public void setCreateANewTask(File json){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Get an active task")
    public void setGetAnActiveTask(long id){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                            .pathParam("id", id);
    }
    @Step("Update a task")
    public void setUpdateATask(long id, File json){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                            .contentType(ContentType.JSON)
                            .body(json)
                            .pathParam("id", id);

    }
    @Step("Close a task")
    public void setCloseATask(long id){
        SerenityRest.given().headers( "Authorization", "Bearer " + BEARER_TOKEN )
                            .pathParam("id", id);
    }
    @Step("Reopen a task")
    public void setReopenATask(long id){
        SerenityRest.given().headers( "Authorization", "Bearer " + BEARER_TOKEN )
                .pathParam("id", id);
    }

    @Step("Delete a Task")
    public void setDELETE(long id){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN )
                            .pathParam("id", id);
    }
}
