package com.test.acme.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.acme.message.BranchProtectionRequest;
import com.test.acme.message.BranchProtectionResponse;
import com.test.acme.pojo.request.DismissalRestrictions;
import com.test.acme.pojo.request.RequiredPullRequestReviews;
import com.test.acme.pojo.request.RequiredStatusChecks;
import com.test.acme.pojo.request.Restrictions;
import com.test.acme.service.BranchService;
import com.test.acme.util.JsonUtility;

import org.codehaus.jackson.map.ObjectMapper;
@Service
public class MasterBranchServiceImpl implements BranchService {

	@Autowired
	private Environment env;
	@Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
	private String token;

	@Override
	public BranchProtectionResponse setDefaultProtection(String repoName, String repoOwner) {

		String url = "https://api.github.com/repos/" + repoOwner + "/" + repoName + "/branches/master/protection";

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);

		// A custom header media type as mentioned on the API documentation for the
		// protection endpoint (Developer Preview)
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.valueOf("application/vnd.github.luke-cage-preview+json"));
		headers.setAccept(mediaTypes);

		// Construct the default protection and wrap the body and header into http
		// request entity
		HttpEntity<BranchProtectionRequest> requestEntity = new HttpEntity(createDefaultProtection(), headers);

		// Send http post request using the rest template
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BranchProtectionResponse> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
				BranchProtectionResponse.class);
		JsonUtility.createJsonObject(response.getBody(),"Master branch protect response");
		
		return response.getBody();
	}

	/*
	 * Construct the default protection message strict = true | context =
	 * new-repository | min-review = 1 | enforce-admin = false |
	 * dismiss-stale-reviews = false | require-owner-review = false | restriction =
	 * null | dismissalRestrictions = null
	 */
	private BranchProtectionRequest createDefaultProtection() {

		boolean strict = Boolean.valueOf(env.getProperty("github.branch.default.protection.statusCheck.strict"));
		boolean enforceAdmin = Boolean.valueOf(env.getProperty("github.branch.default.protection.enforceAdmin"));
		int requiredReviews = Integer
				.valueOf(env.getProperty("github.branch.default.protection.pullRequestReviews.count"));
		String[] contexts = env.getProperty("github.branch.default.protection.statusCheck.contexts").split(",");
		String[] dismissedUsers = env.getProperty("github.branch.default.protection.dismissalRestriction.users")
				.split(",");
		String[] dismissedTeams = env.getProperty("github.branch.default.protection.dismissalRestriction.teams")
				.split(",");
		String[] restrictedUsers = env.getProperty("github.branch.default.protection.Restriction.users").split(",");
		String[] restrictedTeams = env.getProperty("github.branch.default.protection.Restriction.teams").split(",");
		String[] restrictedApps = env.getProperty("github.branch.default.protection.Restriction.apps").split(",");

		RequiredStatusChecks requiredStatusChange = new RequiredStatusChecks(strict, Arrays.asList(contexts));
		DismissalRestrictions dismissalRestrictions = new DismissalRestrictions(Arrays.asList(dismissedUsers),
				Arrays.asList(dismissedTeams));
		Restrictions restrictions = new Restrictions(Arrays.asList(restrictedUsers), Arrays.asList(restrictedTeams),
				Arrays.asList(restrictedApps));
		RequiredPullRequestReviews requiredPullRequestReviews = new RequiredPullRequestReviews(dismissalRestrictions,
				false, false, requiredReviews);
		BranchProtectionRequest protectionMassage = new BranchProtectionRequest(requiredStatusChange, enforceAdmin,
				requiredPullRequestReviews, restrictions);
		
		JsonUtility.createJsonObject(protectionMassage,"Master branch protect request");
		return protectionMassage;
	}
	
	
}
