/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import io.restassured.response.Response;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
//import static org.hamcrest.Matchers.lessThan;
//import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath ;

public  class TestRestJSON extends TestConfig {
  public static String jsonAsString;
  public static Response response;
  
  
	  @Test
		public void newtestDemo2()  {
		    String myData =  "{\n"  +  		"  \"userId\":333,\n"  +  
		            "  \"id\":3333,\n" +  
		    		"  \"title\":\"mynewbook\"\n " +  "}";
	     //   String newendpoint = "/1/";

			given().
			log().all().
			spec(arspec).
			when().
			get().then().
			assertThat().
			body(matchesJsonSchemaInClasspath("enim"));
				// assertThat().body("title", contains("molestiae enim")); 
				//.statusCode(200);
	  }

	//@Test
	public void newtestDemo()  {
	
 		System.out.println("Beginning...");
		given().log().all().
		spec(arspec).
		when().
		get().
		//get("/1/").
		//when().get(EndPoint.SINGLE_ALBUM).
		 //when().get("/1/").
			then().
			log().all();		
		}
}


