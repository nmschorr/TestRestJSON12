package config; 

import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {
    public static RequestSpecBuilder builder;
    
	public static RequestSpecification arspec;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
	public static void SetUp() {
    	RestAssured.proxy("localhost", 8888);			
       builder = new RequestSpecBuilder();
       builder.setBaseUri("http://jsonplaceholder.typicode.com");     
       builder.setBasePath("/albums");     //   "http://jsonplaceholder.typicode.com", null);
       builder.setPort(8888);
       builder.addHeader("ContentType", "application/json; charset=utf-8");
       requestSpec = builder.build();
        
		arspec = new RequestSpecBuilder().
				setBaseUri("https://api.myjson.com").
				//https://api.myjson.com/bins/kbxij
				//setBaseUri("http://jsonplaceholder.typicode.com").
			  //  setBasePath("/albums").
			    setBasePath("/bins").
			  //  setBasePath("/kbxij").
			setPort(8080).               
 				addHeader("ContentType", "application/json; charset=utf-8").
 				addHeader("Content-Encoding", "gzip").
				addHeader("X-Content-Type-Options","nosniff").
				build();

	//RestAssured.requestSpecification = arspec;
			
    		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
		
		 RestAssured.responseSpecification = responseSpec;    
 }
}