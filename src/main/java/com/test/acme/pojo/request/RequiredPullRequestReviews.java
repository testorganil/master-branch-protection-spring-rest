
package com.test.acme.pojo.request;


public class RequiredPullRequestReviews {

    public RequiredPullRequestReviews(DismissalRestrictions dismissalRestrictions, Boolean dismissStaleReviews,
			Boolean requireCodeOwnerReviews, Integer requiredApprovingReviewCount) {
		super();
		this.dismissalRestrictions = dismissalRestrictions;
		this.dismissStaleReviews = dismissStaleReviews;
		this.requireCodeOwnerReviews = requireCodeOwnerReviews;
		this.requiredApprovingReviewCount = requiredApprovingReviewCount;
	}

	private DismissalRestrictions dismissalRestrictions;
    private Boolean dismissStaleReviews;
    private Boolean requireCodeOwnerReviews;
    private Integer requiredApprovingReviewCount;

    public DismissalRestrictions getDismissalRestrictions() {
        return dismissalRestrictions;
    }

    public void setDismissalRestrictions(DismissalRestrictions dismissalRestrictions) {
        this.dismissalRestrictions = dismissalRestrictions;
    }

    public Boolean getDismissStaleReviews() {
        return dismissStaleReviews;
    }

    public void setDismissStaleReviews(Boolean dismissStaleReviews) {
        this.dismissStaleReviews = dismissStaleReviews;
    }

    public Boolean getRequireCodeOwnerReviews() {
        return requireCodeOwnerReviews;
    }

    public void setRequireCodeOwnerReviews(Boolean requireCodeOwnerReviews) {
        this.requireCodeOwnerReviews = requireCodeOwnerReviews;
    }

    public Integer getRequiredApprovingReviewCount() {
        return requiredApprovingReviewCount;
    }

    public void setRequiredApprovingReviewCount(Integer requiredApprovingReviewCount) {
        this.requiredApprovingReviewCount = requiredApprovingReviewCount;
    }

}
