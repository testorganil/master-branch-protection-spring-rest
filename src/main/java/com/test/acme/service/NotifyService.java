package com.test.acme.service;

import com.test.acme.message.BranchProtectionResponse;;

/*
 * The Notify service interface for all operation related to notifications
 * Implemented by MentionNotifyServiceImpl
 * */
public interface NotifyService {

    // notify the organisation's admin when a branch is protected through a mention in an issue within the repo
    void notifyBranchProtected(String repoName, String repoOwner, BranchProtectionResponse protection);

}
