package DemoRestAssured;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredTestNG {
	public static String baseURI="https://api.trello.com";
	
	@Test
	public void testcase1()
	{
		//base usri gets loaded
		RestAssured.baseURI=baseURI;
		//given,when and then
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
		System.out.println("Executed successfully");
	}
	
	
	@Test
	public void testcase2()
	{
		//base usri gets loaded
		RestAssured.baseURI=baseURI;
		//given,when and then
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
		.header("content-Type", "application/json; charset=utf-8");
		//.and()
		//.header("Date", "Thu, 17 Jun 2021 07:11:11 GMT");
		System.out.println("executed successfully header");
	}
		@Test
		public void testcase3()
		{
			String boardname="Creation of board from eclipse" +(int) (Math.random()*100);
			RestAssured.baseURI = baseURI;
			//given,when and then
			given()
		
			.queryParam("key", "5203ef7973b5e7b57a1b0c488797f34c")
			.queryParam("token", "85ca20f0fa848e1cec9c638b088ea8fc0590bf5b32cc8a1de825eb3ea917b525")
			.queryParam("name", "boardname")
			.header("Content-Type", "application/json; charset=utf-8")
			.when()
			.post("/1/boards")
			.then()
			.assertThat()
			.statusCode(200);
				
		}
}
