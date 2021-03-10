package com.test.acme.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.acme.message.BranchProtectionResponse;
import com.test.acme.message.RequestIssueMessage;
import com.test.acme.service.IssueService;
import com.test.acme.util.JsonUtility;

@Service
public class IssueServiceImpl implements IssueService {

	@Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
	private String token;
	private static final Logger logger=LoggerFactory.getLogger(IssueServiceImpl.class);
	@Override
	public void createNewIssue(String title, String body, String repoOwner, String repoName) {

		String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/issues";
		logger.info("url " +url);
		// Instantiate http header and add the bearer token to the header
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);

		// Create the request message and wrap into http request entity
		RequestIssueMessage issueMessage = new RequestIssueMessage(title, body);
		JsonUtility.createJsonObject(issueMessage, "issue message request");
		HttpEntity<RequestIssueMessage> requestEntity = new HttpEntity(issueMessage, headers);

		// Send http post request using the rest template
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response =restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		JsonUtility.createJsonObject(response.getBody(), "issue message response");
	}

}