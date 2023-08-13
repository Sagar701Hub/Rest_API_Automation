package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;



import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load the properties file
		return routes;
	}

	public static Response createUser(User payload)
	{
		String post_url = getURL().getString("post_url"); // it will read the key value form the property file.
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		
		return response;
	}
	
	public static Response readUser(String userName)
	{
		Response response =given()
		.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload)
	{
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam(userName, payload)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response =given()
		.pathParam("username", userName)
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}
	
}
