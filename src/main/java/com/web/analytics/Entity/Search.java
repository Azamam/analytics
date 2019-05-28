package com.web.analytics.Entity;

public class Search {
    private String keyword;
    private int searches;

    public Search() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getSearches() {
        return searches;
    }

    public void setSearches(int searches) {
        this.searches = searches;
    }

    public Search(String keyword, int searches) {
        this.keyword = keyword;
        this.searches = searches;
    }
}
