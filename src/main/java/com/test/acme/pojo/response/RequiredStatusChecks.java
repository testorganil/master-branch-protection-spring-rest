
package com.test.acme.pojo.response;


import java.util.List;

public class RequiredStatusChecks {

    private String url;
    private Boolean strict;
    private List<String> contexts = null;
    private String contextsUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getStrict() {
        return strict;
    }

    public void setStrict(Boolean strict) {
        this.strict = strict;
    }

    public List<String> getContexts() {
        return contexts;
    }

    public void setContexts(List<String> contexts) {
        this.contexts = contexts;
    }

    public String getContextsUrl() {
        return contextsUrl;
    }

    public void setContextsUrl(String contextsUrl) {
        this.contextsUrl = contextsUrl;
    }

}
