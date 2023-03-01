package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateChargeTypeApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies creata a chargetype
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=0,description="This testcase verifies creata a chargetype",enabled=true)
	void verifyCreateNewChargeType() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("chargesTypeId",1);
		request.put("code","vij");
		request.put("createdBy",1);
		request.put("name","transaction charge");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/chargeType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies update the existing airport details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description="This testcase verifies update the existing airport details",enabled=true)
	void verifyUpdateChargeType() {
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
		responce= httprequest.request(Method.PUT,"/admin/chargeType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies get the existing airport details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get the existing airport details",enabled=true)
	void verifyGetChargeTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/chargeTypes");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies delete the existing chargetype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies delete the existing chargetype details",enabled=true)
	void verifyDeleteChargeTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/chargeType/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
}
