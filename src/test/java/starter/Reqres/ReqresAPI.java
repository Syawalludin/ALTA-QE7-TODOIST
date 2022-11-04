package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REG_BODY = DIR + "/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCEMA = DIR + "/src/test/resources/JSON/jsonScema";

    public static String GET_LIST_USER = URL + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER = URL + "/api/users?page={id}";
    public static String POST_REGISTER = URL + "/api/register";
    public static String POST_LOGIN = URL + "/api/login";

    public static String GET_SINGLE_USER = URL + "/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND = URL + "/api/users/{id}";
    public static String GET_LIST_RESOURCE = URL + "/api/unknown?page={page}";
    public static String GET_SINGLE_RESORCE = URL + "/api/unknown/{id}";


    //LATIHAN
    @Step("Get list users")
    public void setGetListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void setPostCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);

    }

    @Step("Put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    @Step("Delete User")
    public void setDeleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    // TUGAS POST
    @Step("Register Successful")
    public void setPostRegisterSuccess(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Register Unseccess")
    public void setPostRegisterUnseccess(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Login Success")
    public void setPostLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //TUGAS GET
    @Step("Get Single User")
    public void setGetSigleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get Single User")
    public void setGetSingleUserNotFound(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get List Resource")
    public void setGetListResource(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get Single Resource")
    public void setGetSingleResorce(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
