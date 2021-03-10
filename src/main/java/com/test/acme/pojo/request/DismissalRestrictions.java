
package com.test.acme.pojo.request;

import java.util.List;

public class DismissalRestrictions {

    public DismissalRestrictions(List<String> users, List<String> teams) {
		super();
		this.users = users;
		this.teams = teams;
	}

	private List<String> users = null;
    private List<String> teams = null;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

}
