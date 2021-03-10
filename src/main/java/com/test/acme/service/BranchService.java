package com.test.acme.service;

import com.test.acme.message.BranchProtectionResponse;;

/*
 * The branch service interface for all operation performed on a branch
 * Implemented by MasterBranchServiceImpl
 * */
public interface BranchService {

    // set the branch default protection, returns the protection that was applied on the branch
	BranchProtectionResponse setDefaultProtection(String repoName, String repoOwner );
}
