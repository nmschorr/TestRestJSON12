package config; 

import config.EndPoint;
import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;

import org.junit.BeforeClass;

public class TestConfig {
	public static RequestSpecBuilder typicodebuilder;
	public static RequestSpecification typicodeSpec;
	public static RequestSpecification mySpec;

	public static ResponseSpecification responseSpecGet;
	public static ResponseSpecification responseSpecPost;
	public static ResponseSpecBuilder responseSpecBuilder;

 
 	
	@BeforeClass
	public static void SetUp() {
		RestAssured.proxy("localhost", 8888);	
		
		String   myBase        = "http://localhost:3000"; 
		String   myBasePath = "/movies";   //  
		Integer myPort         = 3000;

 		String MYBASE = myBase;
	    String MYBASEPATH = myBasePath;
	    													    
		mySpec = new RequestSpecBuilder().
			setBaseUri(MYBASE).  													
		    setBasePath(MYBASEPATH).
			setPort(myPort).
			addHeader("Accept", "application/json").
			addHeader("Content-Type", "application/json").
		    build();
	 
		System.out.println("\n\n-----------------Must run with Fidder!---------------------------\n");
		System.out.println(mySpec.toString());
			//RestAssured.requestSpecification = mySpec;  // uncomment to set true for all tests
		TestConfig.SetUpResponse();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		int a[] = {1,2,3,4};
		
	    for (int b = 0; b < a.length; b++) {
		     testList.add(a[b]); }
        boolean xx = testList.contains(1);
		int xxx = 1;

}
	  // ----------------------------------------------------- typicode.com: 
	static void SetUpTypicode() {

		typicodebuilder = new RequestSpecBuilder();
		typicodebuilder.setBaseUri("http://jsonplaceholder.typicode.com");     
		typicodebuilder.setBasePath("/albums");      
		typicodebuilder.setPort(80);
		typicodebuilder.addHeader("ContentType", "application/json");
		typicodeSpec = typicodebuilder.build();
		//RestAssured.requestSpecification = typicodeSpec;   // sets this for all tests
}
	  // ----------------------------------------------------- Response: 

		static void SetUpResponse() {
			responseSpecGet = new ResponseSpecBuilder()
			    .expectStatusCode(200)
				.build();
			
			responseSpecPost = new ResponseSpecBuilder()
				    .expectStatusCode(201)
					.build();

		//RestAssured.responseSpecification = responseSpec;    // sets this for all tests
	}
}


// old : mockbin.org:8080/bin/ff731071-8808-4855-91e8-954f2c8fd0d7";
//https://api.myjson.com/bins/bl3ht
///  https://www.jasonbase.com/things/gzy2//        
//https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3  //ff731071-8808-4855-91e8-954f2c8fd0d7/view
// other :  "/d14860ba-f2a0-11e7-8877-13767a00f47a";



