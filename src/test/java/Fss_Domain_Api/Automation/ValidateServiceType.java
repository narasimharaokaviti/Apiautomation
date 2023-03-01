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

public class ValidateServiceType {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies create a ServiceType
	 * @return: NO
	 * @parameters: NO
	 */

	@Test(priority=0,description="This testcase verifies create a ServiceType",enabled=true)
	void verifyCreateServiceType() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("code","port1");
		request.put("createdBy",1);
		request.put("name","poort to poort");
		request.put("serviceTypeId",1);
		request.put("updatedBy",0);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/serviceType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		int responcecode =responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		String statusline=responce.getStatusLine();
		//Assert.assertEquals(statusline,"HTTP/1.1 200");

		System.out.println("status line is "+ statusline);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}
	}
	/*
	 * This testcase verifies Update servicetype
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description=" This testcase verifies Update existing servicetype ",enabled=true)
	void verifyUpdateServiceType() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request.put("code","port1");
		request.put("createdBy",1);
		request.put("name","poort to door");
		request.put("serviceTypeId",1);
		request.put("updatedBy",0);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
	    responce= httprequest.request(Method.PUT,"/admin/serviceType");
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
	 * This testcase verifies get all servicetype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all servicetype details",enabled=true)
	void verifyGetServiceTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/serviceTypes");
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
	 * This testcase verifies get single servicetype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies get single servicetype details",enabled=true)
	void verifyGetServiceTypeDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-BranchId","85");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/serviceType/1");
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
	 * This testcase verifies delete single serviceType details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=4,description="This testcase verifies delete single region details",enabled=false)
	void verifyDeleteServiceTypeDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.DELETE,"/admin/serviceType/1");
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
