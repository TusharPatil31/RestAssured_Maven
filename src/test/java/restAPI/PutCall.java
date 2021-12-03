package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutCall {
	
	
	@Test 
	public void PutCall()
	{
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		
		PostBody.put("name", "Jon");
		PostBody.put("salary", "45000");
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(PostBody)
									.put("/employees/7");
		
		String ResponseBody =response.body().asString();
		
		System.out.println(ResponseBody);
		
//		============= Verify the response code ====================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		
		Assert.assertEquals(ActResponse, ExpResponse);
	}

}
