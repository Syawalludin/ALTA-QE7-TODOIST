package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;


import java.io.File;

public class ReqresStepDev {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with parameters page {int}")
    public void getListUserWithParameters(int page) {
        reqresAPI.setGetListUser(page);
    }

    @When("Send Get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBody(int page){
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json scema")
    public void validateGetListUserJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/GetListUserJsonScema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/CreateUser.json");
        reqresAPI.setPostCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                    .body(ReqresResponses.NAME, equalTo(name))
                    .body(ReqresResponses.JOB, equalTo(job));


    }

    @And("Validate create user json scema")
    public void validateCreateUserJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/CreateUserJsonScema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with valid json with {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REG_BODY+"/UpdateUser.json");
        reqresAPI.setPutUpdateUser(id,json);

    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with {int}")
    public void deleteUserWithId(int id) {
        reqresAPI.setDeleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} no content")
    public void statusCodeShouldBe(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


    @And("Validate Put Update user json scema")
    public void validatePutUpdateUserJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/PutUpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
