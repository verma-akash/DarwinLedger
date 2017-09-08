package com.darwinlabs.ledgerex.Model;

/**
 * Created by Akash on 08-Sep-17.
 */

public class NavigationItem {

    public String itemName;
    public int progress;

    public NavigationItem(String itemName, int progress) {
        this.itemName = itemName;
        this.progress = progress;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
