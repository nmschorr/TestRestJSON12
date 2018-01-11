/* TestRestJSON by Nancy Schorr, 2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Goes to url  localhost:3000  and reads the data and store it in various objects running with JSONserver and Node.js.
 2018 : added rest assured.  
 Note to self: do log first, then spec, then the rest in each section.
 */
package com.nmschorr;

import config.TestConfig;
//import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;
import config.EndPoint;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//import java.util.List;
//import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.Test;
//import com.github.fge.jsonpatch.*;

import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.*;

public  class TestRestJSON extends TestConfig {
	public static String   myBasePath = EndPoint.MOVIE_EP;  
	public static String begLine = "\n---------------Beginning " ;
	public static String endLine = "  --------------------\n" ;
	
	//------------------------------------- test 1 Get --------------------------------------
	
	
	@Test														
	public void myTest1()  {
	  
      if  (mycheck(myTests, 1))    {              // 1 = this test number
        System.out.println(begLine + "Fiddler must be running! " + endLine);	 	
			System.out.println(begLine + "myTest1 Simple GET " + endLine);

			ValidatableResponse validatableResponse =			
					given()
					.log().all()
					.spec(mySpec)
					.when()
					.get()
					.then()
					.spec(responseSpecGet)
					.log().all();

			validatableResponse.assertThat().statusCode(200);
			//String id = validatableResponse.extract().body().jsonPath().get("id").toString();
			String movieNamesList = validatableResponse.extract().body().jsonPath().get("name").toString();
			//Headers h= validatableResponse.extract().headers();
		//	String statusCode =  validatableResponse.extract().statusLine();

			//    assertTrue(statusCode, containsString("200"));
			System.out.println("Test one movie names list:  " + movieNamesList);
			System.out.println(endLine + "end Test 1" + endLine);
      }	
      else {
			System.out.println(endLine + "skipped Test 1" + endLine);
      }
	}
		
	//------------------------------------- test 2 Get Record --------------------------------------
	@Test
	public void myTest2()  {
		if  (mycheck(myTests, 2))    {              // 2 = this test number
			System.out.println(begLine + "myTest2 Get One Record" + endLine);
			String selectedTest = "/3";
			String selectedTestString = "Inception";
			System.out.println("\n\n------Testing Record:     "  +   selectedTest  + "  " +  selectedTestString + "----------\n\n");

			given()
			.log().all()
			.spec(mySpec)
			.when() 
			.get(selectedTest)
			.then()
			.spec(responseSpecGet)
			.assertThat().body(containsString(selectedTestString))
			.log().all();
			System.out.println(endLine + "end Test 2" + endLine);
		}	
		else {
			System.out.println(endLine + "skipped Test 2" + endLine);
		}
	}
	//------------------------------------- test 3 POST --------------------------------------
	@Test
	public void myTest3()  {
		if  (mycheck(myTests, 3))    {              // 3 = this test number
			System.out.println(begLine + "Beginning myTest3 POST" + endLine);
			// String myBody3 =  "{   \"name\": \"jsonserver55\",  \"director\": \"nms5\",  \"rating\": 9.0 }";// this string works for Post

			JSONObject obj = new JSONObject();  //no need for id
			obj.put("rating","rating12");
			obj.put("director","director12");
			obj.put("name","new12");      	//	obj.put("id", new Integer(12));  // no need for id - gets it automatically
			System.out.println("\n\n------ex obj Record:    \n "  +   obj.toString()  + "  "+ "----------\n\n");

			given()
			.log().everything()
			.spec(mySpec)
			.body(obj.toString())     // all specs must be before body!
			.when()
			.post()
			.then()
			.spec(responseSpecPost)
			.log().all();		
			System.out.println(endLine + "end Test 3" + endLine);
		}	
		else {
			System.out.println(endLine + "skipped Test 3" + endLine);
		}
	}
	//------------------------------------- test 4 --------------------------------------
	//@Test
	public void myTest4()  {
		if  (mycheck(myTests,4))    {              // 4 = this test number
			System.out.println(begLine + "Beginning myTest4" + endLine);
			System.out.println(begLine + "Fiddler must be running! " + endLine);
			// 																	Map<String, Object>  jsonAsMap = new HashMap<>();
			//																	jsonAsMap.put("name", "Test12");
			//																	jsonAsMap.put("title", "Test127123");
			//																	jsonAsMap.put("contactEmail", "x");
			//																	jsonAsMap.put("description", "testing purpose");

			String repStr = "[   {\"replace\": \"/rating\", \"value\": 7} ]";			
			String recNumber = "/3";
			
			given()
			.spec(mySpec)
			.body(repStr)
			.when()
			.post(recNumber)    
			.then()
			.spec(responseSpecPost)
			.log().all();															    														
			System.out.println(endLine + "end Test 4" + endLine);
		}	
		else {
			System.out.println(endLine + "skipped Test 4" + endLine);
		}
	}  // test 4
}  // class


