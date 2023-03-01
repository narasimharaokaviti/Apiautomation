package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateChargeUnitApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies creata a chargeunit
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=0,description="This testcase verifies creata a chargeunit",enabled=true)
	void verifyCreateChargeUnit() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("chargesUnitId",1);
		request.put("code","tranasction");
		request.put("createdBy",1);
		request.put("name","transaction charge");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/chargesUnit");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies update a chargeunit
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description=" This testcase verifies update a chargeunit",enabled=true)
	void verifyUpdateChargeUnit() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("chargesTypeId",1);
		request.put("code","VIJ");
		request.put("countryId",1);
		request.put("createdBy",1);
		request.put("name","income");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		Response responce= httprequest.request(Method.PUT,"/admin/chargesUnit");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies get  chargeunit details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get  chargeunit details",enabled=true)
	void verifyGetChargeUnitDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/chargesUnits");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies delete chargeunit details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies delete chargeunit details",enabled=true)
	void verifyDeleteChargeUnitDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/chargesUnit/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}


}
