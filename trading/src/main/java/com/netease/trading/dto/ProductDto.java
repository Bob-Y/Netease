package com.netease.trading.dto;

import com.netease.trading.entity.Product;

public class ProductDto {

    private boolean success;
    private Product product;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
