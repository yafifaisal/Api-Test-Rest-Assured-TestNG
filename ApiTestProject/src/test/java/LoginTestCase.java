import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.json.JSONObject;

public class LoginTestCase {
	
	String loginUrl = "https://reqres.in/api/register";

	@Test
	void loginWithCorrectData() {

		GetUserData userData = new GetUserData();

		String email = userData.getEmail(1);
		String password = userData.getPassword(1);

		System.out.println(email + " " + password);

		JSONObject requestParams = new JSONObject();
		requestParams.put("password", password);
		requestParams.put("email", email); 


		System.out.println(requestParams.toString());

		given()
		.body(requestParams.toString()).
		when()
		.post(loginUrl).
		then()
		.statusCode(200);

	}

	@Test
	void loginWithIncorrectData() {

		GetUserData userData = new GetUserData();

		String email = userData.getEmail(1);
		String password = userData.getEmail(1);

		System.out.println(email + " " + password);

		JSONObject requestParams = new JSONObject();
		requestParams.put("password", password);
		requestParams.put("email", email); 


		System.out.println(requestParams.toString());

		given()
		.body(requestParams.toString()).
		when()
		.post(loginUrl).
		then()
		.statusCode(400);

	}

	@Test
	void loginWithEmailOnly() {

		GetUserData userData = new GetUserData();

		String email = userData.getEmail(1);

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); 


		System.out.println(requestParams.toString());

		given()
		.body(requestParams.toString()).
		when()
		.post(loginUrl).
		then()
		.statusCode(400);

	}
	
	@Test
	void loginWithPasswordOnly() {

		GetUserData userData = new GetUserData();

		String password = userData.getPassword(1);

		JSONObject requestParams = new JSONObject();
		requestParams.put("password", password); 


		System.out.println(requestParams.toString());

		given()
		.body(requestParams.toString()).
		when()
		.post(loginUrl).
		then()
		.statusCode(400);

	}

}
