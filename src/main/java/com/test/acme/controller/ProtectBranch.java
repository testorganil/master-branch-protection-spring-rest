package com.test.acme.controller;

import com.test.acme.message.RepositoryEventMessage;
import com.test.acme.message.BranchProtectionResponse;
import com.test.acme.service.BranchService;
import com.test.acme.service.NotifyService;
import com.test.acme.service.impl.NotifyServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectBranch {

    @Autowired
    private BranchService branchService;
    @Autowired
    private NotifyService notifyService;
    
    /*
    * Endpoint listening on the repository webhook events
    * receives all repository events and filters them based on the action
    * */
    private static final Logger logger=LoggerFactory.getLogger(NotifyServiceImpl.class);
    @PostMapping("/repo/event")
    public void filterEvents(@RequestBody RepositoryEventMessage eventMessage) throws InterruptedException {

        // If the action received in the repo event is created then start the default master branch protection process
    	logger.info("eventMessage "+eventMessage);
    	if ("created".equals(eventMessage.getAction())) {
            
            protectMasterBranch(eventMessage);
        }
    }

    /*
     * Default master branch protection process
     * */
    private void protectMasterBranch(RepositoryEventMessage eventMessage){

        // Extract repo name and owner values from the event message
        String repoName = eventMessage.getRepository().getName();
        String repoOwner = eventMessage.getRepository().getOwner().getLogin();

        // Call the setDefaultProtection on the master branch service
        // If successful then call the notifyBranchProtected on the mention notification service.
        // Implementation details can be found in MasterBranchServiceImpl and MentionNotifyServiceImpl classes
        BranchProtectionResponse protection = branchService.setDefaultProtection(repoName, repoOwner);
        notifyService.notifyBranchProtected(repoName, repoOwner, protection);
    }

}
