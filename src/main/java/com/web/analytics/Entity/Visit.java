package com.web.analytics.Entity;

public class Visit {
    private long date;
    private String prettyDate;
    private int daysAgo;
    private String referrerType;
    private String referrerUrl;
    private String referralSummary;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getPrettyDate() {
        return prettyDate;
    }

    public void setPrettyDate(String prettyDate) {
        this.prettyDate = prettyDate;
    }

    public int getDaysAgo() {
        return daysAgo;
    }

    public void setDaysAgo(int daysAgo) {
        this.daysAgo = daysAgo;
    }

    public String getReferrerType() {
        return referrerType;
    }

    public void setReferrerType(String referrerType) {
        this.referrerType = referrerType;
    }

    public String getReferrerUrl() {
        return referrerUrl;
    }

    public void setReferrerUrl(String referrerUrl) {
        this.referrerUrl = referrerUrl;
    }

    public String getReferralSummary() {
        return referralSummary;
    }

    public void setReferralSummary(String referralSummary) {
        this.referralSummary = referralSummary;
    }
}
