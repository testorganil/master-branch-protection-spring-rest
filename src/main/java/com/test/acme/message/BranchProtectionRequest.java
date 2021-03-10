
package com.test.acme.message;

import com.test.acme.pojo.request.RequiredPullRequestReviews;
import com.test.acme.pojo.request.RequiredStatusChecks;
import com.test.acme.pojo.request.Restrictions;



public class BranchProtectionRequest {

    public BranchProtectionRequest(RequiredStatusChecks requiredStatusChecks, Boolean enforceAdmins,
			RequiredPullRequestReviews requiredPullRequestReviews, Restrictions restrictions) {
		super();
		this.required_status_checks = requiredStatusChecks;
		this.enforce_admins = enforceAdmins;
		this.required_pull_request_reviews = requiredPullRequestReviews;
		this.restrictions = restrictions;
	}

	private RequiredStatusChecks required_status_checks;
    private Boolean enforce_admins;
    private RequiredPullRequestReviews required_pull_request_reviews;
    private Restrictions restrictions;
    
    
   

    public RequiredStatusChecks getRequired_status_checks() {
		return required_status_checks;
	}

	public void setRequired_status_checks(RequiredStatusChecks required_status_checks) {
		this.required_status_checks = required_status_checks;
	}

	public Boolean getEnforce_admins() {
		return enforce_admins;
	}

	public void setEnforce_admins(Boolean enforce_admins) {
		this.enforce_admins = enforce_admins;
	}

	public RequiredPullRequestReviews getRequired_pull_request_reviews() {
		return required_pull_request_reviews;
	}

	public void setRequired_pull_request_reviews(RequiredPullRequestReviews required_pull_request_reviews) {
		this.required_pull_request_reviews = required_pull_request_reviews;
	}

	public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

}
