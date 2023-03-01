package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyAirlineApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;



	/*
	 * This api verifies create a new airline
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This api verifies create a new airline",enabled=true)
	void verifyCreateNewAirline() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("airlineId",1);
		request.put("airlineName","indigo");
		request.put("alias","ASD");
		request.put("callsign","SDF");
		request.put("country",2);
		request.put("createdBy",2);
		request.put("iata","AR");
		request.put("icao","VHK");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/airline");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This api verifies get airline details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=1,description="This api verifies get airline details",enabled=true)
	void verifyGetAirlineDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/airlines");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This api verifies update existing airline details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This api verifies update existing airline details",enabled=false)
	void verifyPutAirlinrDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("airlineId",1);
		request.put("airlineName","indigo");
		request.put("alias","AD");
		request.put("callsign","VJK");
		request.put("country",1);
		request.put("iata",1);
		request.put("createdBy",2);
		request.put("iata","JK");
		request.put("icao","VHO");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/airline");
		httprequest.body(request.toJSONString());
		String responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		int responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This api verifies delete existing airline
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This api verifies delete existing airline",enabled=false)
	void verifyDeleteAirlineDetails() {
		RestAssured.baseURI=Constants.URI;
		RestAssured.baseURI="http://fss-alb-955427281.ap-south-1.elb.amazonaws.com";
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/airline/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}

}
