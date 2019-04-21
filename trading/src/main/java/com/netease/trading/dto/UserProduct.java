package com.netease.trading.dto;

import com.netease.trading.entity.Product;

public class UserProduct extends Product{

    // 用户是否已购买
    private boolean hasBought;

    public boolean isHasBought() {
        return hasBought;
    }

    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }
}
