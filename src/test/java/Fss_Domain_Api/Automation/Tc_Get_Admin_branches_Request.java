package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc_Get_Admin_branches_Request {
	
	@Test
	void branchDetails() {
		RestAssured.baseURI="http://fss-alb-955427281.ap-south-1.elb.amazonaws.com";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject request=new JSONObject();
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW1lc2giLCJleHAiOjE2NzcyMzQxNzAsImlhdCI6MTY3NzIxNjE3MH0.U7m77FNJN0U6N7aP6lpH4iA-TfsabEw0klAK5O3AI8zPW6cIWJZj-aos0ntKKCFc4oOyIs2Kxnys9G7NAHmL8w");
		Response responce= httprequest.request(Method.GET,"/admin/branches");
		String responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		int responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		String statusline=responce.getStatusLine();
		System.out.println("status line is " +statusline);
	}

}
