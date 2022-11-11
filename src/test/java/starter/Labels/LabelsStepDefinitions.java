package starter.Labels;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class
LabelsStepDefinitions {
    @Steps
    LabelsAPI labelsAPI;

    //Get All Label
    @Given("Get all labels valid parameter")
    public void getAllLabelsValidParameter() {
        labelsAPI.getAllLabels();
    }

    @When("Send all labels request")
    public void sendAllLabels() {
        SerenityRest.when().get(LabelsAPI.GET_ALL_LABELS);
    }

    @Then("Status code is {int} OK")
    public void statusCodeIsOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get all labels json schema validator")
    public void validateGetAllLabelsJsonSchemaValidator() {
        File json = new File(LabelsAPI.JSON_SCHEMA+"/GetAllLabelsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Create New Label
    @Given("Post create a valid new label")
    public void postCreateAValidNewLabel() {
        File json = new File(LabelsAPI.JSON_REQ_BODY+"/CreateNewLabel.json");
        labelsAPI.postCreateNewLabel(json);
    }

    @When("Send post create label request")
    public void sendPostCreateLabelRequest() {
        SerenityRest.when().post(LabelsAPI.CREATE_NEW_LABEL);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
            SerenityRest.then()
                    .body(LabelsResponse.NAME,equalTo(name));
    }

    @And("Validate create label json schema validator")
    public void validateCreateLabelJsonSchemaValidator() {
        File json = new File(LabelsAPI.JSON_SCHEMA+"/CreateNewLabelSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get Label
    @Given("Get label valid id {long}")
    public void getLabelsValidIdId(long id) {
        labelsAPI.getLabel(id);
    }

    @When("Send get label request")
    public void sendGetLabelRequest() {
        SerenityRest.when().get(LabelsAPI.GET_LABEL);
    }

    @And("Validate get label json schema validator")
    public void validateGetLabelJsonSchemaValidator() {
        File json = new File(LabelsAPI.JSON_SCHEMA+"/GetLabelSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Update Label
    @Given("Post update label valid id {long}")
    public void postUpdateLabelWithValidJsonId(long id) {
        File json = new File(LabelsAPI.JSON_REQ_BODY+"/UpdateLabel.json");
        labelsAPI.updateLabel(id, json);
    }

    @When("Send post update label request")
    public void sendPostUpdateLabelRequest() {
        SerenityRest.when().post(LabelsAPI.UPDATE_LABEL);
    }

    @And("Response update label body should contain name {string}")
    public void responseUpdateLabelBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(LabelsResponse.NAME,equalTo(name));
    }

    @And("Validate post update label json schema validator")
    public void validatePostUpdateLabelJsonSchemaValidator() {
        File json = new File(LabelsAPI.JSON_SCHEMA+"/UpdateLabelSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Delete Label
    @Given("Task delete label with id {long}")
    public void taskDeleteLabelWithIdId(long id) {
        labelsAPI.deleteLabel(id);
    }

    @When("Send task delete label request")
    public void sendTaskDeleteLabelRequest() {
        SerenityRest.when().delete(LabelsAPI.DELETE_LABEL);
    }

    @Then("Status code is {int} No Content")
    public void statusCodeIsNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

}
