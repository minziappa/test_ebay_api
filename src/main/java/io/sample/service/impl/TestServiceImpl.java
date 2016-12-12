package io.sample.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sample.service.TestService;
import io.sample.utilities.ApiHttpsClient;

@Service
public class TestServiceImpl implements TestService {

	final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
    private Configuration configuration;

	@Override
	public String getProducts(String item) throws Exception {

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("X-EBAY-API-APP-ID", "Woongjoo-appkimwo-PRD-XXXXXXXX-XXXXXXXX");
		requestHeaders.put("X-EBAY-API-SITE-ID", "0");
		requestHeaders.put("X-EBAY-API-CALL-NAME", "GetSingleItem");
		requestHeaders.put("X-EBAY-API-VERSION", "863");

		String strJson = null;
		try {
			strJson = ApiHttpsClient.httpsClient("https://svcs.ebay.com/services/search/FindingService/v1?"
					+ "SECURITY-APPNAME=Woongjoo-appkimwo-PRD-XXXXXXXX-XXXXXXXX&"
					+ "OPERATION-NAME=findItemsByKeywords&SERVICE-VERSION=1.0.0&"
					+ "RESPONSE-DATA-FORMAT=JSON&callback=_cb_findItemsByKeywords&"
					+ "REST-PAYLOAD&keywords=iPhone&paginationInput.entriesPerPage=6&"
					+ "GLOBAL-ID=EBAY-US&siteid=0", null, ApiHttpsClient.GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strJson;
	}

}