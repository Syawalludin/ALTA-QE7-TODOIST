package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GETstepDev {
    @Steps
    ReqresAPI reqresAPI;

    //SCENARIO 1
    @Given("Get single user with {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.setGetSigleUser(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response Single User body page should be {int}")
    public void responseSingleUserBodyPageShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID, Matchers.equalTo(id));
    }

    @And("Validate Get single user json scema")
    public void ValidateGetSingleUserJsonScema(){
        File json = new File(ReqresAPI.JSON_SCEMA+"/GetSingleUserScema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //SCENARIO 2
    @Given("Get single user not found with {int}")
    public void getSingleUserNotFoundWithId(int id){
        reqresAPI.setGetSingleUserNotFound(id);
    }

    @When("Send get single user Not Found")
    public void sendGetSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_NOT_FOUND);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @And("Response body should be NULL")
    public void responseBodyShouldBeNULL() {
        SerenityRest.then().body(ReqresResponses.NOT_FOUND, Matchers.equalTo(null));
    }

    @And("Validate Get single user Not Found json scema")
    public void validateGetSingleUserNotFoundJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/UserNotFoundSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //SCENARIO 3
    @Given("Get List Resource with parameter page {int}")
    public void getListResourceWithParametersPageId(int page){
        reqresAPI.setGetListResource(page);
    }

    @When("Send Get List Resource request")
    public void sendGetListResourceRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }
    @And("Response List Resource body page should be {int}")
    public void responseListResourceBodyPageShouldBeId(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
    @And("Validate List Resource json schema")
    public void validateListResourceJsonScema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/ListResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //SCENARIO 4
    @Given("Get single resouce with {int}")
    public void getSingleResouceWithId(int id) {
        reqresAPI.setGetSingleResorce(id);
    }

    @When("Send get single resouce")
    public void sendGetSingleResouce(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESORCE);
    }

    @And("Response Single resouce body page should be {int}")
    public void responseSingleResouceBodyPageShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id));
    }
    @And("Validate Single resource json schema")
    public void validateSingleResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCEMA+"/SingleResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
