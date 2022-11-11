package starter.Labels;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class LabelsAPI {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/jsonScema";

    public static final String BEARER_TOKEN = "181d382f2da19201acc048d06cc5602ed7a15491";

    public static final String GET_ALL_LABELS = URL+"/rest/v1/labels";
    public static final String CREATE_NEW_LABEL = URL+"/rest/v1/labels/";
    public static final String GET_LABEL = URL+"/rest/v1/labels/{id}";
    public static final String UPDATE_LABEL = URL+"/rest/v1/labels/{id}";
    public static final String DELETE_LABEL= URL+"/rest/v1/labels/{id}";

    //Positive Case
    // Get All Labels
    @Step("Get all labels")
    public void getAllLabels() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }

    //Create New Label
    @Step("Post create new label")
    public void postCreateNewLabel(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get Label
    @Step("Get label")
    public void getLabel(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Update lael")
    public void updateLabel(long id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Label
    @Step("Delete label")
    public void deleteLabel(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

}