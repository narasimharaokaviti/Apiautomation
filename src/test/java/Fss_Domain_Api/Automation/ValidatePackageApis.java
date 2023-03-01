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

public class ValidatePackageApis {
	
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies create a package
	 * @return: NO
	 * @parameters: NO
	 */

	@Test(priority=0,description="This testcase verifies create a package",enabled=true)
	void verifyCreatePackage() {
		RestAssured.baseURI=Constants.URI;
	    httprequest=RestAssured.given();
	    request=new JSONObject();
		request.put("applicableAt","A");
		request.put("cbm",1);
		request.put("code","cutton");
		request.put("createdBy",1);
		request.put("height",10);
		request.put("length",10);
		request.put("name","box");
		request.put("packageId",1);
		request.put("updatedBy",1);
		request.put("volumeUnit","KM");
		request.put("volumetricWeight",10);
		request.put("weight",10);
		request.put("weightUnit","K");
		request.put("width",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/package");
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
	@Test(priority=1,description=" This testcase verifies Update existing package details ",enabled=true)
	void verifyUpdatePackageDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("applicableAt","A");
		request.put("cbm",1);
		request.put("code","cutton");
		request.put("createdBy",1);
		request.put("height",10);
		request.put("length",10);
		request.put("name","box");
		request.put("packageId",1);
		request.put("updatedBy",1);
		request.put("volumeUnit","KM");
		request.put("volumetricWeight",11);
		request.put("weight",10);
		request.put("weightUnit","K");
		request.put("width",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		Response responce= httprequest.request(Method.PUT,"/admin/package");
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
	 * This testcase verifies get all package details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all package details",enabled=true)
	void verifyGetpackagesDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/packages");
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
	 * This testcase verifies get single package details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies get single package details",enabled=true)
	void verifyGetPackageDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/package/1");
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
	 * This testcase verifies delete single package details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=4,description="This testcase verifies delete single package details",enabled=false)
	void verifyDeleteSinglePackageDetail() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.DELETE,"/admin/Package/1");
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
