package NASATechTransfer;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetDataFromNASADemo {

	String api = "https://api.nasa.gov/";

	@Test

	public void testResponseCode() {

		int code = get(api).getStatusCode();

		System.out.println("Code: " + code);

		Assert.assertEquals(code, 200);

	}

	@Test

	public void testResults() {		
		byte[] data  = get(api).asByteArray();

		System.out.println("Response Time:   " + data);
	}
}
