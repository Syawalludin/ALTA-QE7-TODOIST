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
}
