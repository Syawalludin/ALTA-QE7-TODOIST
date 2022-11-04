package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegisterStepDev {

    @Steps
    ReqresAPI reqresAPI;

    //SCHENARIO 1
    @Given("User Success Register with file json")
    public void userRegiterWithFileJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/RegisterSuccess.json");
        reqresAPI.setPostRegisterSuccess(json);
    }

    @When("Send register successful")
    public void sendRegisterSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }


    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then().body(ReqresResponses.ID, equalTo(id))
                           .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate Register Successful json scema")
    public void validateRegisterSuccessfulJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/RegisterSuccessUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario 2
    @Given("User Unsuccess Register with file json")
    public void userUnsuccessRegisterWithFileJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/RegisterUnsuccess.json");
        reqresAPI.setPostRegisterUnseccess(json);
    }

    @When("Send register Unsuccessful")
    public void sendRegisterUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int error) {
        SerenityRest.then().statusCode(error);
    }

    @And("Response body page should be error {string}")
    public void responseBodyPageShouldBeError(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate Register Unsuccessful json scema")
    public void validateRegisterUnsuccessfulJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/RegisterUnsuccessUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
