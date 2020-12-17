import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetUserData {

	public String getEmail(int index) {

		Response response = get("https://reqres.in/api/users");
		String email = response.path("data.email["+Integer.toString(index)+"]");

		return email;

	}

	public String getPassword(int index) {

		Response response = get("https://reqres.in/api/users");
		String firstname = response.path("data.first_name["+Integer.toString(index)+"]");
		String lastname = response.path("data.last_name["+Integer.toString(index)+"]");
		String password = firstname + " " + lastname;

		return password;

	}

}
