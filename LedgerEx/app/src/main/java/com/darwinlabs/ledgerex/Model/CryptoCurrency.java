package com.darwinlabs.ledgerex.Model;

/**
 * Created by Akash on 06-Sep-17.
 */

public class CryptoCurrency {

    private String currencyName;
    private double currencyAmount;
    private double amountInDollars;
    private double rateInDollars;
    private double percentGainLossDay;
    private double percentGainLossWeek;

    public CryptoCurrency(String currencyName, double currencyAmount, double amountInDollars, double rateInDollars, double percentGainLossDay, double percentGainLossWeek) {
        this.currencyName = currencyName;
        this.currencyAmount = currencyAmount;
        this.amountInDollars = amountInDollars;
        this.rateInDollars = rateInDollars;
        this.percentGainLossDay = percentGainLossDay;
        this.percentGainLossWeek = percentGainLossWeek;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public double getAmountInDollars() {
        return amountInDollars;
    }

    public void setAmountInDollars(double amountInDollars) {
        this.amountInDollars = amountInDollars;
    }

    public double getRateInDollars() {
        return rateInDollars;
    }

    public void setRateInDollars(double rateInDollars) {
        this.rateInDollars = rateInDollars;
    }

    public double getPercentGainLossDay() {
        return percentGainLossDay;
    }

    public void setPercentGainLossDay(double percentGainLossDay) {
        this.percentGainLossDay = percentGainLossDay;
    }

    public double getPercentGainLossWeek() {
        return percentGainLossWeek;
    }

    public void setPercentGainLossWeek(double percentGainLossWeek) {
        this.percentGainLossWeek = percentGainLossWeek;
    }
}
