
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class GetUserData {
	
	Response response;
	
	public int getID(int index) {

		response = get("https://reqres.in/api/users");
		int ID = response.path("data.id["+Integer.toString(index)+"]");

		return ID;

	}

	public String getEmail(int index) {

		response = get("https://reqres.in/api/users");
		String email = response.path("data.email["+Integer.toString(index)+"]");

		return email;

	}
	
	public String getFirstName(int index) {

		response = get("https://reqres.in/api/users");
		String firstName = response.path("data.first_name["+Integer.toString(index)+"]");

		return firstName;

	}
	
	public String getLastName(int index) {

		response = get("https://reqres.in/api/users");
		String lastName = response.path("data.last_name["+Integer.toString(index)+"]");

		return lastName;

	}

	public String getPassword(int index) {
		
		String firstName = getFirstName(index);
		String lastName = getLastName(index);
		String password = firstName + " " + lastName;

		return password;

	}
	
	public int getNumberOfUserPerPage() {

		response = get("https://reqres.in/api/users");
		int total = response.path("total");
		int pages = response.path("total_pages");
		int numberUserPerPage = total / pages;

		return numberUserPerPage;

	}
	
	public String getAvatar(int index) {

		response = get("https://reqres.in/api/users");
		String avatar = response.path("data.avatar["+Integer.toString(index)+"]");

		return avatar;

	}

}
