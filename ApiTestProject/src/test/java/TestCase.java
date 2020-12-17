import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.specification.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import org.json.JSONObject;

public class TestCase {

	String baseUrl = "https://reqres.in/api";
	RequestSpecification request = given();
	GetUserData userData = new GetUserData();

//	========== Login with correct Email and Password by throwing the index of data list ==========
//  ========== { "email": "eve.holt@reqres.in", "password": "cityslicka" }              ==========
	@Test
	void loginWithCorrectData() {

		String email = userData.getEmail(1);
		String password = userData.getPassword(1);
		int id = userData.getID(1);

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password); 

		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post(baseUrl+"/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String idUser = response.jsonPath().getString("id");
		Assert.assertEquals(id, Integer.parseInt(idUser));


	}

//	========== Login with Email only by throwing the index of data list ==========
//  ========== { "email": "eve.holt@reqres.in" }                        ==========
	@Test
	void loginWithEmailOnly() {

		String email = userData.getEmail(1);
		int id = userData.getID(1);

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);

		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post(baseUrl+"/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400);

		String error = response.jsonPath().getString("error");
		Assert.assertEquals(error, "Missing password");

	}

//	========== Login with Password only by throwing the index of data list ==========
//  ========== { "password": "cityslicka" }                                ==========
	@Test
	void loginWithPasswordOnly() {

		String password = userData.getPassword(1);
		int id = userData.getID(1);

		JSONObject requestParams = new JSONObject();
		requestParams.put("password", password);

		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post(baseUrl+"/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400);

		String error = response.jsonPath().getString("error");
		Assert.assertEquals(error, "Missing email or username");

	}

//	========== Verify data user displayed is not empty                        ==========
//	========== Get number of user, then verify all key and value is not empty ==========
	@Test
	void verifyDataUsers() {

		int numberOfData = userData.getNumberOfUserPerPage();

		request.header("Content-Type", "application/json");
		Response response = request.get(baseUrl+"/users");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		for (int i=0; i<numberOfData;i++) {
			Assert.assertNotSame((response.path("data.id["+i+"]")),"");
			Assert.assertNotSame((response.path("data.email["+i+"]")),"");
			Assert.assertNotSame((response.path("data.first_name["+i+"]")),"");
			Assert.assertNotSame((response.path("data.last_name["+i+"]")),"");
			Assert.assertNotSame((response.path("data.avatar["+i+"]")),"");
		}
	}

//	========== Verify avatar of user is not broken ==========
//	========== hit image url with get method       ==========
	@Test
	void verifyImageNotBroken() {

		String avatar = userData.getAvatar(1);

		request.header("Content-Type", "application/json");
		Response response = request.get(avatar);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
//	========== Verify email user has a valid format                ==========
//	========== Substring email text then verified contains @ and . ==========
	@Test
	void verifyFormatEmail() {

		String email = userData.getEmail(1);
		Assert.assertTrue(email.contains("@") && email.contains("."));


	}


}
