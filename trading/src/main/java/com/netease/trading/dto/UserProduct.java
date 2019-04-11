package com.netease.trading.dto;

import com.netease.trading.entity.Product;

public class UserProduct extends Product{

    private boolean hasBought;

    public boolean isHasBought() {
        return hasBought;
    }

    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }
}
