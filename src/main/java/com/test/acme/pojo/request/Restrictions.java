
package com.test.acme.pojo.request;

import java.util.List;

public class Restrictions {

    public Restrictions(List<String> users, List<String> teams, List<String> apps) {
		super();
		this.users = users;
		this.teams = teams;
		this.apps = apps;
	}

	private List<String> users = null;
    private List<String> teams = null;
    private List<String> apps = null;

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

    public List<String> getApps() {
        return apps;
    }

    public void setApps(List<String> apps) {
        this.apps = apps;
    }

}
