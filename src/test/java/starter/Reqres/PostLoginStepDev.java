package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostLoginStepDev {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("User Success Login with file json")
    public void userSuccessLoginWithFileJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/LoginSuccess.json");
        reqresAPI.setPostRegisterSuccess(json);
    }

    @When("Send login successful")
    public void sendLoginSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Login Response body should contain token {string}")
    public void loginResponseBodyShouldContainIdPageAndToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate Login successful json schema")
    public void validateLoginSuccessfulJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/LoginSuccessSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("User Login Unsuccess Register with file json")
    public void userLoginUnsuccessRegisterWithFileJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/LoginUnsuccess.json");
        reqresAPI.setPostLogin(json);
    }

    @When("Send Login Unsuccessful")
    public void sendLoginUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Validate Login Unsuccessful json schema")
    public void validateLoginUnsuccessfulJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/LoginUnsuccessSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
