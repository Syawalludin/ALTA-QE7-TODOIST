package starter.Todoist;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class TodoistAPI {

    public static final String URL ="https://api.todoist.com";
    public static final String DIR =System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String BEARER_TOKEN= "181d382f2da19201acc048d06cc5602ed7a15491";
    public static String JSON_SCHEMA = DIR +"/src/test/resources/JSON/jsonScema";
    public static String GET_ALL_SECTION = URL+"/rest/v1/sections?project_id={id}";
    public static String GET_SINGLE_SECTIONS =URL+ "/rest/v1/sections/{id}";
    public static String POST_NEW_SECTION = URL +"/rest/v1/sections";
    public static String POST_UPDATE_SECTION = URL+"/rest/v1/sections/{id}";
    public static String DELETE_SECTION =URL+"/rest/v1/sections/{id}";
    public static String GET_AN_ACTIVE_TASK= URL+"/rest/v1/sections?project_id={id}";

    @Step("Get all sections")
    public void  setGetAllSections(Long id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Get single section")
    public void setGetSingleSections(Long id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Post create new section")
    public void setPostNewSection (File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
        .contentType(ContentType.JSON).body(json);
    }
    @Step("Post update section")
    public void setPostUpdateSection(Long id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Delete section")
    public void setDeleteSection(Long id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step
    public void setGetAnActiveTask(Long id){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .pathParam("id", id);

    }
}
