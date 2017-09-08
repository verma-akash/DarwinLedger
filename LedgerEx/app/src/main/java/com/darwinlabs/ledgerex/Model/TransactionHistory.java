package com.darwinlabs.ledgerex.Model;

/**
 * Created by Akash on 06-Sep-17.
 */

public class TransactionHistory {

    private String transDate;
    private String transTime;
    private double transAmount;
    private String currency;
    private String transType;

    public TransactionHistory(String transDate, String transTime, double transAmount, String currency, String transType) {
        this.transDate = transDate;
        this.transTime = transTime;
        this.transAmount = transAmount;
        this.currency = currency;
        this.transType = transType;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }
}
