package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Inventory {
    @SerializedName("product_id")
    @Expose
    private Long productId;
    @SerializedName("store_id")
    @Expose
    private Long storeId;
    @SerializedName("is_dead")
    @Expose
    private Boolean isDead;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("product_no")
    @Expose
    private Long productNo;
    @SerializedName("store_no")
    @Expose
    private Long storeNo;

    @Generated(hash = 220388731)
    public Inventory(Long productId, Long storeId, Boolean isDead, Long quantity,
            String updatedOn, String updatedAt, Long productNo, Long storeNo) {
        this.productId = productId;
        this.storeId = storeId;
        this.isDead = isDead;
        this.quantity = quantity;
        this.updatedOn = updatedOn;
        this.updatedAt = updatedAt;
        this.productNo = productNo;
        this.storeNo = storeNo;
    }

    @Generated(hash = 375708430)
    public Inventory() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(Boolean isDead) {
        this.isDead = isDead;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }
}


