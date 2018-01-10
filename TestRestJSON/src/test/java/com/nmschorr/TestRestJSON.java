/* TestRestJSON by Nancy Schorr, 2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Goes to url  localhost:3000  and reads the data and store it in various objects running with JSONserver and Node.js.
 2018 : added rest assured.  
 Note to self: do log first, then spec, then the rest in each section.
 */
package com.nmschorr;

import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;
import config.EndPoint;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.junit.Test;
//import  io.restassured.http.*;
//import com.github.fge.jsonpatch.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.*;

public  class TestRestJSON extends TestConfig {
	public static String   myBasePath = EndPoint.MOVIE_EP;  
	public static String begLine = "\n\n---------------Beginning " ;
	public static String endLine = "  --------------------\n\n" ;
	
	//------------------------------------- test 1 Get --------------------------------------
	@Test														
	public void myTest1()  {
		System.out.println(begLine + "myTest1 Simple GET " + endLine);
		System.out.println(begLine + "Fiddler must be running! " + endLine);

		ValidatableResponse validatableResponse =			
				given()
				.log()
				.headers()
				.spec(mySpec)
				.when()
		        .get()
		        .then()
				.spec(responseSpecGet)
		        .log().all();
		
		validatableResponse.assertThat().statusCode(200);
	    String id = validatableResponse.extract().body().jsonPath().get("id").toString();
	    String movieNamesList = validatableResponse.extract().body().jsonPath().get("name").toString();
	    Headers h= validatableResponse.extract().headers();
	    String statusCode =  validatableResponse.extract().statusLine();

	//    assertTrue(statusCode, containsString("200"));
	 	System.out.println("Test one movie names list:  "   + movieNamesList);		
		System.out.println(endLine + "end Test 1" + endLine);
	}

	//------------------------------------- test 2 --------------------------------------
	@Test
	public void myTest2()  {
		System.out.println(begLine + "myTest2 Get One Record" + endLine);
		String myBody2 = "/3";
		String testString2 = "Inception";
		System.out.println("\n\n------Testing Record:     "  +   myBody2  + "  " +  testString2 + "----------\n\n");

		given()
		.log().all()
		.spec(mySpec)
		.when() 
		.get(myBody2)
		.then()
		.spec(responseSpecGet)
		.assertThat().body(containsString(testString2))
		.log().all();
	}
	//------------------------------------- test 3 --------------------------------------
	@Test
	public void myTest3()  {
		System.out.println(begLine + "Beginning myTest3 POST" + endLine);
		// String myBody3 =  "{   \"name\": \"jsonserver55\",  \"director\": \"nms5\",  \"rating\": 9.0 }";// this string works for Post

		JSONObject obj = new JSONObject();  //no need for id
		obj.put("rating","rating12");
		obj.put("director","director12");
		obj.put("name","new12");      	//	obj.put("id", new Integer(12));  // no need for id - gets it automatically
		System.out.println("\n\n------ex obj Record:    \n "  +   obj.toString()  + "  "+ "----------\n\n");

		given()
		.log().all()
		.spec(mySpec)
		.body(obj.toString())     // all specs must be before body!
		.when()
		.post()
		.then()
		.spec(responseSpecPost)
		.log().all();		
	}
	//------------------------------------- test 4 --------------------------------------
	//@Test
	public void myTest4()  {
		System.out.println(begLine + "Beginning myTest4" + endLine);
		System.out.println(begLine + "Fiddler must be running! " + endLine);
		// 																	Map<String, Object>  jsonAsMap = new HashMap<>();
		//																	jsonAsMap.put("name", "Test12");
		//																	jsonAsMap.put("title", "Test127123");
		//																	jsonAsMap.put("contactEmail", "x");
		//																	jsonAsMap.put("description", "testing purpose");

		//String repStr = "[   {\"replace\": \"/id\", \"value\": 5} ]";												    
		given()
		.spec(mySpec)
		//      .body()
		.when()
		//    .put().
		.then()
		.spec(responseSpecPost)
		.log().all();															    														
	} // test4
}  // class


