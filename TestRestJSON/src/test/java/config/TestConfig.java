package config; 

import config.EndPoint;
import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {
	public static RequestSpecBuilder typicodebuilder;
	public static RequestSpecification typicodeSpec;
	public static RequestSpecification blobSpec;
	public static RequestSpecification myjsonSpec;
	public static RequestSpecBuilder myjsonSpecB;
	public static RequestSpecification newSpec;

	public static ResponseSpecification responseSpec;
	public static ResponseSpecBuilder responseSpecBuilder;
												//https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3
												// other :  "/d14860ba-f2a0-11e7-8877-13767a00f47a";

 
 	
	@BeforeClass
	public static void SetUp() {
		RestAssured.proxy("localhost", 8888);	
		String blobBase        = "https://jsonblob.com"; 
		String blobBasePath = "/api/jsonBlob/53998288-f328-11e7-8877-3d11de9ec1d3";   // + EndPoint.BLOB_ENDPOINT;

		String mokbase = "http://mockbin.org";
		String mokbasepath = "/bin";                      //ff731071-8808-4855-91e8-954f2c8fd0d7/view";

																	 // old : mockbin.org:8080/bin/ff731071-8808-4855-91e8-954f2c8fd0d7";
																	//"https://www.jasonbase.com/things/")
	    String MYBASE = mokbase;
	    String MYBASEPATH = mokbasepath;
	    													//https://api.myjson.com/bins/bl3ht
	    													///  https://www.jasonbase.com/things/gzy2//        
		newSpec = new RequestSpecBuilder().
			setBaseUri(MYBASE).  													
			setBasePath(MYBASEPATH).
			setPort(80).
			//addHeader("Content-Type", "application/json").
			addHeader("Accept", "application/json").
			//addHeader("Accept", "text/html").
		    build();

		blobSpec = new RequestSpecBuilder().
				setBaseUri(blobBase).
				//setBasePath(blobBasePath).
				setPort(80).
				//addHeader("ContentType", "application/json").
				addHeader("Content-Type", "application/json").
				addHeader("Accept", "application/json").
				addHeader("X-jsonblob","53998288-f328-11e7-8877-3d11de9ec1d3").
			    build();
	 
		System.out.println(blobSpec.toString());
			//RestAssured.requestSpecification = blobSpec;
			//TestConfig.SetUpTypicode();
		//TestConfig.SetUpResponse();
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
			responseSpec = new ResponseSpecBuilder().
			    expectStatusCode(200).
				build();

		RestAssured.responseSpecification = responseSpec;    // sets this for all tests
	}
}