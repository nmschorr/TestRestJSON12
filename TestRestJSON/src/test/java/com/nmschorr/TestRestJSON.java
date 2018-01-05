/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import static io.restassured.RestAssured.given;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import config.TestConfig;
import org.junit.Test;

import io.restassured.http.ContentType;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TestRestJSON {
//	@BeforeClass  //run once before each testsuite


public  class TestRestJSON extends TestConfig {
													//		LogConfig logconfig = new LogConfig().enableLoggingOfRequestAndResponseIfValidationFails().enablePrettyPrinting(true);
													//		RestAssured.config().logConfig(logconfig);
													//	}
    @Test
	public void newtestDemo()  {
 	System.setProperty("http.agent", "Chrome");
 		System.out.println("\nin 2nd part");
 		System.out.println("Beginning...");
 													//io.restassured.RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
		given().log().ifValidationFails()
									//  contentType(ContentType.JSON).
		.when().get("/1aaa/")
														//	when().get("http://jsonplaceholder.typicode.com/albums/1/")
		.then().statusCode(200).log().all();
		
		}
}



//	@Test
//	public void atestDemo() throws Exception {
//		System.setProperty("http.agent", "Chrome");
//		System.out.println("Beginning...");
//		RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
//		RequestSpecification httpRequest = given();
//		Response response = httpRequest.request(Method.GET, "/1");
//		String responseBody = response.getBody().asString();
//
//		System.out.println("Response Body is =>  \n" + responseBody);
//
//		get("/1").then().body("/1/userId", equalTo(1));
//		System.out.println("\nTest Finished\n\n");
//	}
//
//
//	@Test
//	public void btestDemo() throws Exception {
//		System.setProperty("http.agent", "Chrome");
//		System.out.println("Beginning...");
//		RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
//		RequestSpecification httpRequest = given();
//		Response response = httpRequest.request(Method.GET, "/1");
//		String responseBody = response.getBody().asString();
//
//		System.out.println("Response Body is =>  \n" + responseBody);
//
//		get("/1").then().body("/1/userId", equalTo(1));
//		System.out.println("\nTest Finished\n\n");
//	}

//
//	@Test
//	public void exampleRestTest() {
//		System.setProperty("http.agent", "Chrome");
//		System.out.println("\nin 2nd part");
//		System.out.println("Beginning...");
//		io.restassured.RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
//		//RequestSpecification httpRequest = given();
//		given()
//		//.contentType(ContentType.JSON)
//		.pathParam("id", "9")
//		.log().all()
//		.when()
//		.get("/4/{id}")
//		.then().log().all()
//		.assertThat()
//		.statusCode(200).and()
//		//.contentType(ContentType.JSON).and()
//	//	.body("id", equalTo("1"))
//	//	.body("title", equalTo("quidem molestiae enim"))
//		.extract().response();
//	}
//
//
//	//	RestAssured.given().log().all()
//	//    .header("Content-Type", "application/XML; charset=utf-8")
//	//    .body("")
//	//    .when().post("/bxfxml")
//	//    .then().log().all()
//	//    .assertThat()
//	//    .statusCode(200).and()
//	//    .contentType(ContentType.XML)
//	//    .extract().response();
//
//
////	@AfterClass
//	public static void cleanup() {
//		System.out.println("\nProgram Finished");
//	}
//
//}	//class
//
//
//
//
//
//
//
//
//
//
