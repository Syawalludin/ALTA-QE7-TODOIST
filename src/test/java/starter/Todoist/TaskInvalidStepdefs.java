package starter.Todoist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mk_latn.No;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.aspectj.weaver.ast.Not;
import org.hamcrest.Matchers;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class TaskInvalidStepdefs {

    @Steps
    TodoistTaskAPI todoistTaskAPI;

    //Scenario 8
    @Given("Get an active task with invalid {long}")
    public void getAnActiveTaskWithInvalidId(long id) {
        todoistTaskAPI.setGetAnActiveTask(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario 9
    @Given("Update task with json and invalid {long}")
    public void updateTaskWithJsonAndInvalidId(long id) {
        File json = new File(TodoistTaskAPI.JSON_REG_BODY + "/TaskUpdate.json");
        todoistTaskAPI.setUpdateATask(id, json);
    }

    //Scenario 10
    @Given("Close A task With invalid {long}")
    public void closeATaskWithInvalidId(long id) {
        todoistTaskAPI.setCloseATask(id);
    }

    //Scenario 11
    @Given("Reopen a task with invalid {long}")
    public void reopenATaskWithInvalidId(long id) {
        todoistTaskAPI.setReopenATask(id);
    }

    //Scenario 12
    @Given("Delete a task with invalid {long}")
    public void deleteATaskWithInvalidId(long id) {
        todoistTaskAPI.setDELETE(id);
    }
}
