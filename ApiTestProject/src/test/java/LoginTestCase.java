import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.Random;

import org.testng.annotations.Test;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginTestCase {

	public String getEmail(int index) {

		Response response = get("https://reqres.in/api/users");
		String email = response.path("data.email["+Integer.toString(index)+"]");

		return email;

	}

	public String getPassword(int index) {

		Response response = get("https://reqres.in/api/users");
		String firstname = response.path("data.first_name["+Integer.toString(index)+"]");
		String lastname = response.path("data.last_name["+Integer.toString(index)+"]");
		String password = firstname + lastname;

		return password;

	}


	@Test
	void login() {
		
		String email = getEmail(1);
		String password = getPassword(1);
		
		System.out.println(email + " " + password);
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); 
		requestParams.put("password", password);
		
		System.out.println(requestParams.toString());

		given()
			.body(requestParams.toString()).
		when()
			.post("https://reqres.in/api/register").
		then()
			.statusCode(200);


	}

}
