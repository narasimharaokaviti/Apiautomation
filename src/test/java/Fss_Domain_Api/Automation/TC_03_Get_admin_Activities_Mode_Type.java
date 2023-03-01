package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_Get_admin_Activities_Mode_Type {
	
	@Test
	void getweatherDetails() {
		//specified base URI
		//RestAssured is a predefined class
		RestAssured.baseURI="http://fss-alb-955427281.ap-south-1.elb.amazonaws.com";
		// It is a predefined class imported  from restassured
		// it is a RestAssured.given for request object created
		RequestSpecification httprequest=RestAssured.given();
		JSONObject request=new JSONObject();
		
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW1lc2giLCJleHAiOjE2NzcyMzQxNzAsImlhdCI6MTY3NzIxNjE3MH0.U7m77FNJN0U6N7aP6lpH4iA-TfsabEw0klAK5O3AI8zPW6cIWJZj-aos0ntKKCFc4oOyIs2Kxnys9G7NAHmL8w");
		httprequest.queryParam("mode", "AIR");
		httprequest.queryParam("type", "PRE");
		// responce object
		Response responce= httprequest.request(Method.GET,"/admin/activities/mode/type");
		String responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
	int responcecode=responce.getStatusCode();
	System.out.println("responce code is "+responcecode);
	}


}
