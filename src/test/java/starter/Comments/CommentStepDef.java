package starter.Comments;

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
CommentStepDef {
    @Steps
    CommentAPI commentAPI;

    //Create New Comment
    @Given("Post create a valid new comment")
    public void postCreateAValidNewComment() {
        File json = new File(CommentAPI.JSON_REQ_BODY+"/CreateNewComment.json");
        commentAPI.postCreateNewComment(json);
    }

    @When("Send post create comment request")
    public void sendPostCreateCommentRequest() {
        SerenityRest.when().post(CommentAPI.CREATE_NEW_COMMENT);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(CommentResponse.NAME,equalTo(name));
    }

    @And("Validate create comment json schema validator")
    public void validateCreateCommentJsonSchemaValidator() {
        File json = new File(CommentAPI.JSON_SCHEMA+"/CreateNewCommentSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(json));
    }


    //Get All Comments
//    @Given("Get all comments valid parameter {int}")
//    public void getAllCommentsValidParameterId(int id) {
//        commentAPI.getAllComment();
//    }

    @Given("Get all comment valid task id")
    public void getAllCommentValidTaskId() {
        commentAPI.getAllComment();
    }

    @When("Send all comments request")
    public void sendAllComments() {
        SerenityRest.when().get(CommentAPI.GET_ALL_COMMENT);
    }

    @Then("Status code is {int} OK")
    public void statusCodeIsOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get all comments json schema validator")
    public void validateGetAllCommentsJsonSchemaValidator() {
        File json = new File(CommentAPI.JSON_SCHEMA+"/GetAllCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get Comment
    @Given("Get comment valid id {long}")
    public void getCommentsValidIdId(long id) {
        commentAPI.getComment(id);
    }

    @When("Send get comment request")
    public void sendGetCommentRequest() {
        SerenityRest.when().get(CommentAPI.GET_COMMENT);
    }

    @And("Validate get comment json schema validator")
    public void validateGetCommentJsonSchemaValidator() {
        File json = new File(CommentAPI.JSON_SCHEMA+"/GetCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    @And("Response update project body should contain name {string}")
//    public void responseUpdateProjectBodyShouldContainName(String name) {
//        SerenityRest.then()
//                .body(CommentResponse.NAME,equalTo(name));
//    }

    //Update Comment
    @Given("Post update comment valid id {long}")
    public void postUpdateCommentWithValidJsonId(long id) {
        File json = new File(CommentAPI.JSON_REQ_BODY+"/UpdateComment.json");
        commentAPI.updateComment(id, json);
    }

    @When("Send post update comment request")
    public void sendPostUpdateCommentRequest() {
        SerenityRest.when().post(CommentAPI.UPDATE_COMMENT);
    }

    @And("Validate post update project json schema validator")
    public void validatePostUpdateProjectJsonSchemaValidator() {
        File json = new File(CommentAPI.JSON_SCHEMA+"/UpdateCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Delete Comments
    @Given("Task delete comments with id {long}")
    public void taskDeleteCommentsWithIdId(long id) {
        commentAPI.deleteComment(id);
    }

    @When("Send task delete comments request")
    public void sendTaskDeleteCommentsRequest() {
        SerenityRest.when().delete(CommentAPI.DELETE_COMMENT);
    }

    @Then("Status code is {int} No Content")
    public void statusCodeIsNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


}