package com.web.analytics.Entity;

import java.util.List;

public class Visitor {
    private String visitorId;
    private int totalVisits;
    private int totalActions;
    private int totalOutlinks;
    private int totalDownloads;
    private int totalSearches;
    private int totalPageViews;
    private int totalUniquePageViews;
    private int totalRevisitedPages;
    private int totalPageViewsWithTiming;
    private List<Search> searches;
    private int totalEvents;
    private List<LastVisits> lastVisits;
    private String totalVisitDurationPretty;
    private Visit firstVisit;
    private Visit lastVisit;
    private int visitsAggregated;

    public void setVisitedPages(List<VisitedPage> visitedPages) {
        this.visitedPages = visitedPages;
    }

    public List<VisitedPage> getVisitedPages() {
        return visitedPages;
    }

    private List<VisitedPage> visitedPages;

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }

    public int getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(int totalActions) {
        this.totalActions = totalActions;
    }

    public int getTotalOutlinks() {
        return totalOutlinks;
    }

    public void setTotalOutlinks(int totalOutlinks) {
        this.totalOutlinks = totalOutlinks;
    }

    public int getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(int totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public int getTotalSearches() {
        return totalSearches;
    }

    public void setTotalSearches(int totalSearches) {
        this.totalSearches = totalSearches;
    }

    public int getTotalPageViews() {
        return totalPageViews;
    }

    public void setTotalPageViews(int totalPageViews) {
        this.totalPageViews = totalPageViews;
    }

    public int getTotalUniquePageViews() {
        return totalUniquePageViews;
    }

    public void setTotalUniquePageViews(int totalUniquePageViews) {
        this.totalUniquePageViews = totalUniquePageViews;
    }

    public int getTotalRevisitedPages() {
        return totalRevisitedPages;
    }

    public void setTotalRevisitedPages(int totalRevisitedPages) {
        this.totalRevisitedPages = totalRevisitedPages;
    }

    public int getTotalPageViewsWithTiming() {
        return totalPageViewsWithTiming;
    }

    public void setTotalPageViewsWithTiming(int totalPageViewsWithTiming) {
        this.totalPageViewsWithTiming = totalPageViewsWithTiming;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    public int getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }

    public List<LastVisits> getLastVisits() {
        return lastVisits;
    }

    public void setLastVisits(List<LastVisits> lastVisits) {
        this.lastVisits = lastVisits;
    }

    public String getTotalVisitDurationPretty() {
        return totalVisitDurationPretty;
    }

    public void setTotalVisitDurationPretty(String totalVisitDurationPretty) {
        this.totalVisitDurationPretty = totalVisitDurationPretty;
    }

    public Visit getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(Visit firstVisit) {
        this.firstVisit = firstVisit;
    }

    public Visit getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Visit lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getVisitsAggregated() {
        return visitsAggregated;
    }

    public void setVisitsAggregated(int visitsAggregated) {
        this.visitsAggregated = visitsAggregated;
    }
}
