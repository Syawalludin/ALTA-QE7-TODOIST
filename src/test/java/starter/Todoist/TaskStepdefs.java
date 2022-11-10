package starter.Todoist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class TaskStepdefs {

    @Steps
    TodoistTaskAPI todoistTaskAPI;

    @When("Send Get Active Task")
    public void sendGetActiveTask() {
        todoistTaskAPI.setGetActiveTask();
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }


    //Scenario 2
    @Given("Get list user with file json")
    public void getListUserWithFileJson() {
        File json = new File(TodoistTaskAPI.JSON_REG_BODY + "/TaskCreated.json");
        todoistTaskAPI.setCreateANewTask(json);
    }

    @When("Send Create Active Task")
    public void sendCreateActiveTask() {
        SerenityRest.when().post(TodoistTaskAPI.CREATE_A_NEW_TASK);
    }

    @And("Respose body Should contain name {string} and date {string} and priority {int}")
    public void resposeBodyShouldContainNameContentAndDateDateAndPriorityPriority(String content, String date, int proprity) {
        SerenityRest.then().body(TodoistTaskResponse.CONTENT, equalTo(content))
                           .body(TodoistTaskResponse.DATE, equalTo(date))
                           .body(TodoistTaskResponse.PRIORITY, equalTo(proprity));
    }


    @Given("Get an active task with {long}")
    public void getAnActiveTaskWithId(long id) {
        todoistTaskAPI.setGetAnActiveTask(id);
    }

    @When("Send Get an active task")
    public void sendGetAnActiveTask() {
        SerenityRest.when().get(TodoistTaskAPI.GET_AN_ACTIVE_TASK);
    }

    @And("Respose body should be {long}")
    public void resposeBodyShouldBeId(long id) {
        SerenityRest.then().body(TodoistTaskResponse.ID, equalTo(id));
    }

    @Given("Update task with valid json and {long}")
    public void updateTaskWithValidJsonAndId(long id) {
        File json = new File(TodoistTaskAPI.JSON_REG_BODY + "/TaskUpdate.json");
        todoistTaskAPI.setUpdateATask(id, json);
    }

    @When("Send Update A Task")
    public void sendUpdateATask() {
        SerenityRest.when().post(TodoistTaskAPI.UPDATE_A_TASK);

    }

    @Then("Status code should be {int} NoContent")
    public void statusCodeShouldBeNoContent(int NoContent) {
        SerenityRest.then().statusCode(NoContent);
    }

    @And("Respose Update body should be {string}")
    public void resposeUpdateBodyShouldBeId(String content) {
        SerenityRest.then().body(TodoistTaskResponse.CONTENT, equalTo(content));
    }

    @Given("Close A task With {long}")
    public void closeATaskWithId(long id) {
        todoistTaskAPI.setCloseATask(id);
    }

    @When("Send Close A Task")
    public void sendCloseATask() {
        SerenityRest.when().post(TodoistTaskAPI.CLOSE_A_TASK);
    }
}
