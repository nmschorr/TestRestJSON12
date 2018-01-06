package config; 

import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {
    public static RequestSpecBuilder typicodebuilder;
    public static RequestSpecification typicodeSpec;
 
	public static RequestSpecification arspec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
	public static void SetUp() {
    	RestAssured.proxy("localhost", 8888);	

    	typicodebuilder = new RequestSpecBuilder();
    	typicodebuilder.setBaseUri("http://jsonplaceholder.typicode.com");     
    	typicodebuilder.setBasePath("/albums");      
    	typicodebuilder.setPort(80);
    	typicodebuilder.addHeader("ContentType", "application/json");
        typicodeSpec = typicodebuilder.build();
       
       String mybase        = "https://jsonblob.com";
       String mybasepath = "/d14860ba-f2a0-11e7-8877-13767a00f47a";
		arspec = new RequestSpecBuilder().
				setBaseUri(mybase).
			    setBasePath(mybasepath).
			    addHeader("ContentType", "application/json").
			    							//    addHeader("ContentType", "application/json; charset=utf-8").
			    addHeader("Accept", "application/json").
				build();

	//RestAssured.requestSpecification = arspec;
			
    		responseSpec = new ResponseSpecBuilder() 
				.expectStatusCode(200)
				.build();
		
		 RestAssured.responseSpecification = responseSpec;    
 }
}