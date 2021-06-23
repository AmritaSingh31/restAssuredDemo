package DemoRestAssured;
//import io.restassured.RestAssured.*;
//import io.restassured.assertion.BodyMatcherGroup;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
public class GetMethod {
	//created a var to store the base URI
	public static String baseuri = "https://api.trello.com";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//to assign the base uri to rest assured class called baseuri

    RestAssured.baseURI=baseuri;
		given()
		.param("key", "5203ef7973b5e7b57a1b0c488797f34c")
		.param("token", "85ca20f0fa848e1cec9c638b088ea8fc0590bf5b32cc8a1de825eb3ea917b525")
		.when()
		.get("/1/boards/7x1igEpF")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.and()
		.body("name", equalTo("Amrita S Chopra Board"));
		System.out.println("This is my rest assured code and ran successfully");
			}
}