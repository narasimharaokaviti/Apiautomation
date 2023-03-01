package post_request_api_automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Fss_Domain_Api.Automation.Constants;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Admin_Activity_Request {
	
	@Test
	void postAdminActivityDetails() {
		RestAssured.baseURI="http://fss-alb-955427281.ap-south-1.elb.amazonaws.com";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject request=new JSONObject();
		request.put("activityId",47);
		request.put("createdBy",0);
		request.put("description","SEA EXPORT  DISPATCH");
		request.put("icon","abdec");
		request.put("modeOfTransfer","AIR");
		request.put("name","SEA import PICKU");
		request.put("type","PRE");
		request.put("updatedBy",0);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
	

		Response responce= httprequest.request(Method.POST,"/admin/activity");
		
		httprequest.body(request.toJSONString());
		String responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
	int responcecode=responce.getStatusCode();
	System.out.println("responce code is "+responcecode);
	Assert.assertEquals(responcecode, 200);
	}

}
