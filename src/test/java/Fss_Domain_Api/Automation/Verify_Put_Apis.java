package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Verify_Put_Apis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	int responcecode;
	String responcebody;
	String responceline;
	
	/*
	 * This api verifies admin activity setup
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This api verifies admin activities setup",enabled=true)
	void verifyPutAdminActivitiesSetupDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("activityId",1);
		request.put("createdBy",1);
		request.put("description","abcd");
		request.put("icon","abdec");
		request.put("modeOfTransfer","AIR");
		request.put("name","SEA import PICKU");
		request.put("type","PRE");
		request.put("updatedBy",1);
		httprequest.header("H-CompId",Constants.HCompId);
		httprequest.header("H-RequesterId",Constants.HRequesterId );
		httprequest.header("Authorization",Constants.authorization);
		httprequest.body(request.toJSONString());
		responce= httprequest.request(Method.PUT,"admin/activity");
	   // responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode,Constants.ExpectedGetStatusCode);
		responceline=responce.getStatusLine();
		
	}


}
