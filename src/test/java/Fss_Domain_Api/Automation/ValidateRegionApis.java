package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateRegionApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies create a Region
	 * @return: NO
	 * @parameters: NO
	 */

	@Test(priority=0,description="This testcase verifies create a region",enabled=true)
	void verifyCreateRegion() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("country",1);
		request.put("createdBy",1);
		request.put("regionCode","IOD");
		request.put("regionId",1);
		request.put("regionName","ap");
		request.put("updatedBy",0);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/region");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		int responcecode =responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}
	}
	/*
	 * This testcase verifies Update existing package
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description=" This testcase verifies Update existing region details ",enabled=true)
	void verifyUpdateRegionDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request.put("country",1);
		request.put("createdBy",1);
		request.put("regionCode","IKD");
		request.put("regionId",1);
		request.put("regionName","ap");
		request.put("updatedBy",0);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		Response responce= httprequest.request(Method.PUT,"/admin/region");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}

	}
	/*
	 * This testcase verifies get all region details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all pregion details",enabled=true)
	void verifyGetRegionsDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/regions");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}

	}
	/*
	 * This testcase verifies get single region details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies get single region details",enabled=true)
	void verifyGetRegionDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/region/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}
	}
	/*
	 * This testcase verifies delete single region details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=4,description="This testcase verifies delete single region details",enabled=false)
	void verifyDeleteRegionDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.DELETE,"/admin/region/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}
	}


}
