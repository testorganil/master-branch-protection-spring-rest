package com.test.acme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.acme.service.IssueService;
import com.test.acme.service.NotifyService;
import com.test.acme.util.JsonUtility;
import com.test.acme.message.BranchProtectionResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements NotifyService {

    @Value("${GITHUB.BRANCH.PROTECTION.TOKEN}")
    private String token;
    @Value("${BRANCH.PROTECTION.NOTIFICATION.RECEIVER}")
    private String notificationReceiver;
    @Autowired
    private IssueService issueService;
    private static final Logger logger=LoggerFactory.getLogger(NotifyServiceImpl.class);
    // Notify the organisation's admin when a branch is protected through a mention in an issue within the repo
    @Override
    public void notifyBranchProtected(String repoName, String repoOwner, BranchProtectionResponse protection) {

        String issueTitle = "A New Repo Created - " + repoName + " - Master Branch Successfully protected";
        String issueBody = "@" + notificationReceiver + "\n" + protection.toString();
        logger.info("repoName "+repoName+"repoOwner "+repoOwner);
        issueService.createNewIssue(issueTitle, issueBody, repoOwner, repoName);
    }

}
