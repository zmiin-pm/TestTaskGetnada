package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestApi {

    public static Response sendGetRequest(String url){
        return given()
//                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().contentType(ContentType.JSON).extract().response();
    }

    public static String getLink(Response response){
        Map<Object, Object> map= response.jsonPath().get();
        String link = map.values()
                .stream()
                .map(x->x.toString())
                .filter(x -> x.contains("https://"))
                .findFirst()
                .get();
        return link;
    }
}
