
package com.test.acme.message;

import com.test.acme.pojo.response.AllowDeletions;
import com.test.acme.pojo.response.AllowForcePushes;
import com.test.acme.pojo.response.EnforceAdmins;
import com.test.acme.pojo.response.RequiredLinearHistory;
import com.test.acme.pojo.response.RequiredPullRequestReviews;
import com.test.acme.pojo.response.RequiredStatusChecks;
import com.test.acme.pojo.response.Restrictions;

public class BranchProtectionResponse {

	private String url;
	private RequiredStatusChecks requiredStatusChecks;
	private Restrictions restrictions;
	private RequiredPullRequestReviews requiredPullRequestReviews;
	private EnforceAdmins enforceAdmins;
	private RequiredLinearHistory requiredLinearHistory;
	private AllowForcePushes allowForcePushes;
	private AllowDeletions allowDeletions;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RequiredStatusChecks getRequiredStatusChecks() {
		return requiredStatusChecks;
	}

	public void setRequiredStatusChecks(RequiredStatusChecks requiredStatusChecks) {
		this.requiredStatusChecks = requiredStatusChecks;
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}

	public RequiredPullRequestReviews getRequiredPullRequestReviews() {
		return requiredPullRequestReviews;
	}

	public void setRequiredPullRequestReviews(RequiredPullRequestReviews requiredPullRequestReviews) {
		this.requiredPullRequestReviews = requiredPullRequestReviews;
	}

	public EnforceAdmins getEnforceAdmins() {
		return enforceAdmins;
	}

	public void setEnforceAdmins(EnforceAdmins enforceAdmins) {
		this.enforceAdmins = enforceAdmins;
	}

	public RequiredLinearHistory getRequiredLinearHistory() {
		return requiredLinearHistory;
	}

	public void setRequiredLinearHistory(RequiredLinearHistory requiredLinearHistory) {
		this.requiredLinearHistory = requiredLinearHistory;
	}

	public AllowForcePushes getAllowForcePushes() {
		return allowForcePushes;
	}

	public void setAllowForcePushes(AllowForcePushes allowForcePushes) {
		this.allowForcePushes = allowForcePushes;
	}

	public AllowDeletions getAllowDeletions() {
		return allowDeletions;
	}

	public void setAllowDeletions(AllowDeletions allowDeletions) {
		this.allowDeletions = allowDeletions;
	}

}
