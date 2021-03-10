
package com.test.acme.pojo.response;



public class RequiredPullRequestReviews {

    private String url;
    private Boolean dismissStaleReviews;
    private Boolean requireCodeOwnerReviews;
    private Integer requiredApprovingReviewCount;
    private DismissalRestrictions dismissalRestrictions;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public DismissalRestrictions getDismissalRestrictions() {
        return dismissalRestrictions;
    }

    public void setDismissalRestrictions(DismissalRestrictions dismissalRestrictions) {
        this.dismissalRestrictions = dismissalRestrictions;
    }

}
