package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateContainerTypeApis {
	
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This test case  verifies Create new ContainerType
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This test case  verifies Create new ContainerType",enabled=true)
	void verifyCreateNewContainerType() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
	    request=new JSONObject();
		request.put("code","20FET");
		request.put("containerTypeId",1);
		request.put("createdBy",5);
		request.put("description","heavy load");
		request.put("grossWeightInKg",20);
		request.put("grossWeightInLb",20);  
		request.put("interiorHeightInMtr",20);
		request.put("interiorLengthInMtr",20);
		request.put("interiorWidthInMtr",20);
		request.put("isHighCube",1);
		request.put("isoCode","ASH");
		request.put("maxCBM",1);
		request.put("maxWeight",200);
		request.put("name","cotton");
		request.put("payloadWeightInKg",100);
		request.put("payloadWeightInLb",100);
		request.put("remarks","no");  
		request.put("status",1);
		request.put("tareWeightInLb",1);
		request.put("tareWeightInkg",1);
		request.put("updatedBy",1);
		request.put("volumeInCBM",10);
		request.put("volumeInCFT",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");//H-BranchId
		//httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/containerType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies update ContainerType details
	 * @Parameters:No
	 * @return: NO
	 */
	
	@Test(priority=1,description="This test case  verifies update ContainerType details",enabled=true)
	void verifyUpdateContainerTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("code","20FET");
		request.put("containerTypeId",2);
		request.put("createdBy",1);
		request.put("description","heavy load");
		request.put("grossWeightInKg",20);
		request.put("grossWeightInLb",20);  
		request.put("interiorHeightInMtr",20);
		request.put("interiorLengthInMtr",20);
		request.put("interiorWidthInMtr",20);
		request.put("isHighCube",1);
		request.put("isoCode","ASH");
		request.put("maxCBM",1);
		request.put("maxWeight",100);
		request.put("name","cotton");
		request.put("payloadWeightInKg",100);
		request.put("payloadWeightInLb",100);
		request.put("remarks","no");  
		request.put("status",1);
		request.put("tareWeightInLb",1);
		request.put("tareWeightInkg",1);
		request.put("updatedBy",1);
		request.put("volumeInCBM",10);
		request.put("volumeInCFT",1);;
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/containerType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}/*
	 * This test case  verifies get  ContainerType details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get ContainerType details",enabled=true)
	void verifyGetContainerTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/containerTypes/containertypeId");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  ContainerType details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get ContainerType details",enabled=true)
	void verifyGetContainersTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/containerTypes");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies delete  ContainerType details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This test case  verifies delete  ContainerType details",enabled=false)
	void verifyDeleteContainerTypeDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/containerType/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}


}
