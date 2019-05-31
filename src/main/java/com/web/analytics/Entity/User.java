package com.web.analytics.Entity;

public class User {

    private String label;
    private int nb_visits;
    private int nb_actions;
    private int max_actions;
    private long sum_visit_length;
    private String total_visit_length;
    private int bounce_count;
    private int nb_visits_converted;
    private int sum_daily_nb_uniq_visitors;
    private int sum_daily_nb_users;
    private String conduct;
    private String idvisitor;

    public User() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNb_visits() {
        return nb_visits;
    }

    public void setNb_visits(int nb_visits) {
        this.nb_visits = nb_visits;
    }

    public int getNb_actions() {
        return nb_actions;
    }

    public void setNb_actions(int nb_actions) {
        this.nb_actions = nb_actions;
    }

    public int getMax_actions() {
        return max_actions;
    }

    public void setMax_actions(int max_actions) {
        this.max_actions = max_actions;
    }

    public long getSum_visit_length() {
        return sum_visit_length;
    }

    public void setSum_visit_length(long sum_visit_length) {
        this.sum_visit_length = sum_visit_length;
    }

    public int getBounce_count() {
        return bounce_count;
    }

    public void setBounce_count(int bounce_count) {
        this.bounce_count = bounce_count;
    }

    public int getNb_visits_converted() {
        return nb_visits_converted;
    }

    public void setNb_visits_converted(int nb_visits_converted) {
        this.nb_visits_converted = nb_visits_converted;
    }

    public int getSum_daily_nb_uniq_visitors() {
        return sum_daily_nb_uniq_visitors;
    }

    public void setSum_daily_nb_uniq_visitors(int sum_daily_nb_uniq_visitors) {
        this.sum_daily_nb_uniq_visitors = sum_daily_nb_uniq_visitors;
    }

    public int getSum_daily_nb_users() {
        return sum_daily_nb_users;
    }

    public void setSum_daily_nb_users(int sum_daily_nb_users) {
        this.sum_daily_nb_users = sum_daily_nb_users;
    }

    public String getIdVisitor() {
        return idvisitor;
    }

    public void setIdVisitor(String idvisitor) {
        this.idvisitor = idvisitor;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getTotal_visit_length() {
        return total_visit_length;
    }

    public void setTotal_visit_length(String total_visit_length) {
        this.total_visit_length = total_visit_length;
    }
}
