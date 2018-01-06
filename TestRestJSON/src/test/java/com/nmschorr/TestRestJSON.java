/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import    io.restassured.builder.*;
import  io.restassured.response.Response;
import     io.restassured.specification.*;


public  class TestRestJSON extends TestConfig {
  public static String jsonAsString;
  
  
	  @Test
		public void newtestDemo2()  {
		    String myData =  "{\n"  +  		"  \"userId\":333,\n"  +  
		            "  \"id\":3333,\n" +  
		    		"  \"title\":\"mynewbook\"\n " +  "}";
	     //   String newendpoint = "/1/";
//given().
Response response =			given().
			log().all().
			//spec(typicodeSpec).
			when().get("/2/").
			
						//get().
			then().assertThat().body(containsString("sunt qui excepturi placeat culpa")).and().body(containsString("qui")).
			and().body( containsString("id")).
			extract().response();
System.out.println("response: " );	  
System.out.println(response.asString()); 

	        String responseBody = given().when().get().asString();
	        System.out.println("\n\n\n ---------responsebody: " );	  
	        System.out.println(responseBody);	 
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
			then().
			log().all();		
		}
}


