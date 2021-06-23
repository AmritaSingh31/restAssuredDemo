package DemoRestAssured;

import org.testng.annotations.Test; 
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class EcommerceRestTesting {
	
	public static String baseURI=  "https://ecommerceservice.herokuapp.com";
	public String accessToken;
	public String id;
	
	//Post mehtod//with body
	@Test(enabled=false)
	public void signup()
	{
		RestAssured.baseURI=baseURI;
		//i have to create body
		
		String requestbody = "{\r\n" + 
				"	\"email\": \"amrsc@gmail.com\",\r\n" + 
				"	\"password\": \"amrsc@123\"\r\n" + 
				"}\r\n" + 
				"";
		Response response = given()
		.header("Content-Type", "application/json")
		.body(requestbody)
		
		.when()
		.post("/user/signup")
		
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.extract().response();
		System.out.println(response.asString());
	}

	
	@Test(priority=0)
	public void login()
	{
		RestAssured.baseURI=baseURI;
		//i have to create body
		
		String requestbody = "{\r\n" + 
				"	\"email\": \"amrsc@gmail.com\",\r\n" + 
				"	\"password\": \"amrsc@123\"\r\n" + 
				"}\r\n" + 
				"";
		Response response = given()
		.header("Content-Type", "application/json")
		.body(requestbody)
		
		.when()
		.post("/user/login")
		
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.extract().response();
		System.out.println(response.asString());
	//i have to convert response data from string to json
		
		String jsonresponsebody=response.asString();
		//i want to convert it to jason
		JsonPath responsebody = new JsonPath(jsonresponsebody);
		accessToken=responsebody.get("accessToken");
		System.out.println(accessToken);
	}
	
	@Test(priority=1)
	public void getallusers()
	{
		RestAssured.baseURI=baseURI;
		//i have to create body
		
		
		Response response = given()
		.header("Content-Type", "application/json")
		.header("Authorization","bearer " + accessToken)
	
		
		.when()
		.get("/user")
		
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.extract().response();
		System.out.println(response.asString());
	//i have to convert response data from string to json
		
		String jsonresponsebody=response.asString();
		//i want to convert it to jason
		JsonPath responsebody = new JsonPath(jsonresponsebody);
		id=responsebody.get("users[2]._id");
		System.out.println(id);
		
	}
}


