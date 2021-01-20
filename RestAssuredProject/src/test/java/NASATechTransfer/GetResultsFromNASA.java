package NASATechTransfer;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetResultsFromNASA {

	@Test
	public void retrieveResultsFromNASA() {

		// Base URI

		RestAssured.baseURI = "https://api.nasa.gov";
		Response response = null;

		// Try catch block to handle exceptions
		// To access web services, generated api key
		try {

			response = RestAssured.given()

					.when()

					.get("/techtransfer/patent/?engine&api_key=vAtBDqxxfOXNaVRUJuTqzq2vEpTsncZPzC7fnKjF");

		} catch (Exception e) {

			e.printStackTrace();

		}

		// To get results from web services
		System.out.println("Response :" + response.asString());

		// To get status code 200 from web services
		System.out.println("Status Code :" + response.getStatusCode());

		// Using assert keyword to validate expected response code with actual response code
		assertEquals(200, response.getStatusCode());
		
		
		//create an object for a JSAON file because array of list of list
		NASAResult[] techtransferresults = response.jsonPath().getObject("result", NASAResult[].class);
		
		

	}

}
 
