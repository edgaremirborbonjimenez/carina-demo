package com.zebrunner.carina.demo.utils.apium;

public enum NavigationOptions {

    HOME("action_home"),
    EDITORIAL("action_curation"),
    SEARCH("action_search"),
    STORE("action_stores");


    private final String id;

    NavigationOptions(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
