package NASATechTransfer;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetResultsFromNASA{

@Test
public void retrieveResultsFromNASA() {

 RestAssured.baseURI = "https://api.nasa.gov";
 Response response = null;

 try {

   response = RestAssured.given()

    .when()

    .get("/techtransfer");

  } catch (Exception e) {

   e.printStackTrace();

  }

 

  System.out.println("Response :" + response.asString());

  System.out.println("Status Code :" + response.getStatusCode());

  assertEquals(200, response.getStatusCode());
}



}

 
