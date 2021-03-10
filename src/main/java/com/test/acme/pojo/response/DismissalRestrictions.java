package com.test.acme.pojo.response;


import java.util.List;

public class DismissalRestrictions {

    private String url;
    private String usersUrl;
    private String teamsUrl;
    private List<Object> users = null;
    private List<Object> teams = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsersUrl() {
        return usersUrl;
    }

    public void setUsersUrl(String usersUrl) {
        this.usersUrl = usersUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public List<Object> getUsers() {
        return users;
    }

    public void setUsers(List<Object> users) {
        this.users = users;
    }

    public List<Object> getTeams() {
        return teams;
    }

    public void setTeams(List<Object> teams) {
        this.teams = teams;
    }

}
