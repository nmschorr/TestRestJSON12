/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3 and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import  io.restassured.http.*;
import  io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import  io.restassured.specification.*;


public  class TestRestJSON extends TestConfig {
public static String jsonAsString;

	@Test
	public void newtestDemo2()  {
		String myData =  "{\n"  +  		"  \"userId\":333,\n"  +  
				"  \"id\":3333,\n" +  
				"  \"title\":\"mynewbook\"\n " +  "}";
											//   String newendpoint = "/1/";

		String responseStr =			
				given().
				log().all().
				spec(blobSpec).
				when().
				get("53998288-f328-11e7-8877-3d11de9ec1d3").asString();

		Response response =			
				given().
				log().all().
				spec(blobSpec).
				when().
				get("53998288-f328-11e7-8877-3d11de9ec1d3").
				then().
				contentType(ContentType.JSON).
				extract().response();

		Headers headers = response.getHeaders();
		String contentType = response.getHeader("Content-Type");
		System.out.println("\n contentType:   " + contentType);
		int  a = 0;


		//then().assertThat().body(containsString("nancy")).
		//and().body(containsString("a")).
		//and().body( containsString("id")).
		//		extract().response();
		//	System.out.println("response: " );	  
		//		System.out.println(response.asString()); 

		//	String responseBody = given().when().get().asString();

		//	System.out.println("\n\n\n ---------responsebody: " );	  
		//	System.out.println(responseBody);	 
	}

	//@Test
	public void newtestDemo()  {
		System.out.println("Beginning...");
		given().log().all().
		spec(blobSpec).
		when().
		get().
		//get("/1/").
		//when().get(EndPoint.SINGLE_ALBUM).
		then().
		log().all();		
	}
}


