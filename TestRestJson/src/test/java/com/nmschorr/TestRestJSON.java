/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */

package com.nmschorr;

import static java.lang.System.out;
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import org.json.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.*;




public class TestRestJSON {
	

	@Test
	public void testDemo() throws Exception {
		System.setProperty("http.agent", "Chrome");
		System.out.println("Beginning...");
		RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.request(Method.GET, "/1");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
				
		System.out.println("\nProgram Finished");
	}

}	//class










