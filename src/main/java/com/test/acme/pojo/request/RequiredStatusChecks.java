
package com.test.acme.pojo.request;

import java.util.List;

public class RequiredStatusChecks {

    public RequiredStatusChecks(Boolean strict, List<String> contexts) {
		super();
		this.strict = strict;
		this.contexts = contexts;
	}

	private Boolean strict;
    private List<String> contexts = null;

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

}
