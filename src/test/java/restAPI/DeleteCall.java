package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteCall {
	
	@Test
	public void DeleteCall()
	{
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();	
		
		Response response = request.delete("/employees/5");
		
		
//		============= Verify the response code ====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		
		Assert.assertEquals(ActResponse, ExpResponse);
		
		
		
	}

}
