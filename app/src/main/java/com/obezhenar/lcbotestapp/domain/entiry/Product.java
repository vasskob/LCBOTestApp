package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Product {
    @SerializedName("id")
    @Expose()
    @Id
    private long id;
    @SerializedName("is_dead")
    @Expose
    private boolean isDead;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("is_discontinued")
    @Expose
    private boolean isDiscontinued;
    @SerializedName("price_in_cents")
    @Expose
    private long priceInCents;
    @SerializedName("regular_price_in_cents")
    @Expose
    private long regularPriceInCents;
    @SerializedName("limited_time_offer_savings_in_cents")
    @Expose
    private long limitedTimeOfferSavingsInCents;
    @SerializedName("limited_time_offer_ends_on")
    @Expose
    private String limitedTimeOfferEndsOn;
    @SerializedName("bonus_reward_miles")
    @Expose
    private long bonusRewardMiles;
    @SerializedName("bonus_reward_miles_ends_on")
    @Expose
    private String bonusRewardMilesEndsOn;
    @SerializedName("stock_type")
    @Expose
    private String stockType;
    @SerializedName("primary_category")
    @Expose
    private String primaryCategory;
    @SerializedName("secondary_category")
    @Expose
    private String secondaryCategory;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("package")
    @Expose
    private String _package;
    @SerializedName("package_unit_type")
    @Expose
    private String packageUnitType;
    @SerializedName("package_unit_volume_in_milliliters")
    @Expose
    private long packageUnitVolumeInMilliliters;
    @SerializedName("total_package_units")
    @Expose
    private long totalPackageUnits;
    @SerializedName("volume_in_milliliters")
    @Expose
    private long volumeInMilliliters;
    @SerializedName("alcohol_content")
    @Expose
    private long alcoholContent;
    @SerializedName("price_per_liter_of_alcohol_in_cents")
    @Expose
    private long pricePerLiterOfAlcoholInCents;
    @SerializedName("price_per_liter_in_cents")
    @Expose
    private long pricePerLiterInCents;
    @SerializedName("inventory_count")
    @Expose
    private long inventoryCount;
    @SerializedName("inventory_volume_in_milliliters")
    @Expose
    private long inventoryVolumeInMilliliters;
    @SerializedName("inventory_price_in_cents")
    @Expose
    private long inventoryPriceInCents;
    @SerializedName("sugar_content")
    @Expose
    private String sugarContent;
    @SerializedName("producer_name")
    @Expose
    private String producerName;
    @SerializedName("released_on")
    @Expose
    private String releasedOn;
    @SerializedName("has_value_added_promotion")
    @Expose
    private boolean hasValueAddedPromotion;
    @SerializedName("has_limited_time_offer")
    @Expose
    private boolean hasLimitedTimeOffer;
    @SerializedName("has_bonus_reward_miles")
    @Expose
    private boolean hasBonusRewardMiles;
    @SerializedName("is_seasonal")
    @Expose
    private boolean isSeasonal;
    @SerializedName("is_vqa")
    @Expose
    private boolean isVqa;
    @SerializedName("is_ocb")
    @Expose
    private boolean isOcb;
    @SerializedName("is_kosher")
    @Expose
    private boolean isKosher;
    @SerializedName("value_added_promotion_description")
    @Expose
    private String valueAddedPromotionDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("serving_suggestion")
    @Expose
    private String servingSuggestion;
    @SerializedName("tasting_note")
    @Expose
    private String tastingNote;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("image_thumb_url")
    @Expose
    private String imageThumbUrl;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("varietal")
    @Expose
    private String varietal;
    @SerializedName("style")
    @Expose
    private String style;
    @SerializedName("tertiary_category")
    @Expose
    private String tertiaryCategory;
    @SerializedName("sugar_in_grams_per_liter")
    @Expose
    private String sugarInGramsPerLiter;
    @SerializedName("clearance_sale_savings_in_cents")
    @Expose
    private long clearanceSaleSavingsInCents;
    @SerializedName("has_clearance_sale")
    @Expose
    private boolean hasClearanceSale;
    @SerializedName("product_no")
    @Expose
    private long productNo;

    @Generated(hash = 1890278724)
    public Product() {
    }

    @Generated(hash = 1052147803)
    public Product(long id, boolean isDead, String name, String tags, boolean isDiscontinued,
                   long priceInCents, long regularPriceInCents, long limitedTimeOfferSavingsInCents,
                   String limitedTimeOfferEndsOn, long bonusRewardMiles,
                   String bonusRewardMilesEndsOn, String stockType, String primaryCategory,
                   String secondaryCategory, String origin, String _package, String packageUnitType,
                   long packageUnitVolumeInMilliliters, long totalPackageUnits,
                   long volumeInMilliliters, long alcoholContent, long pricePerLiterOfAlcoholInCents,
                   long pricePerLiterInCents, long inventoryCount, long inventoryVolumeInMilliliters,
                   long inventoryPriceInCents, String sugarContent, String producerName,
                   String releasedOn, boolean hasValueAddedPromotion, boolean hasLimitedTimeOffer,
                   boolean hasBonusRewardMiles, boolean isSeasonal, boolean isVqa, boolean isOcb,
                   boolean isKosher, String valueAddedPromotionDescription, String description,
                   String servingSuggestion, String tastingNote, String updatedAt,
                   String imageThumbUrl, String imageUrl, String varietal, String style,
                   String tertiaryCategory, String sugarInGramsPerLiter,
                   long clearanceSaleSavingsInCents, boolean hasClearanceSale, long productNo) {
        this.id = id;
        this.isDead = isDead;
        this.name = name;
        this.tags = tags;
        this.isDiscontinued = isDiscontinued;
        this.priceInCents = priceInCents;
        this.regularPriceInCents = regularPriceInCents;
        this.limitedTimeOfferSavingsInCents = limitedTimeOfferSavingsInCents;
        this.limitedTimeOfferEndsOn = limitedTimeOfferEndsOn;
        this.bonusRewardMiles = bonusRewardMiles;
        this.bonusRewardMilesEndsOn = bonusRewardMilesEndsOn;
        this.stockType = stockType;
        this.primaryCategory = primaryCategory;
        this.secondaryCategory = secondaryCategory;
        this.origin = origin;
        this._package = _package;
        this.packageUnitType = packageUnitType;
        this.packageUnitVolumeInMilliliters = packageUnitVolumeInMilliliters;
        this.totalPackageUnits = totalPackageUnits;
        this.volumeInMilliliters = volumeInMilliliters;
        this.alcoholContent = alcoholContent;
        this.pricePerLiterOfAlcoholInCents = pricePerLiterOfAlcoholInCents;
        this.pricePerLiterInCents = pricePerLiterInCents;
        this.inventoryCount = inventoryCount;
        this.inventoryVolumeInMilliliters = inventoryVolumeInMilliliters;
        this.inventoryPriceInCents = inventoryPriceInCents;
        this.sugarContent = sugarContent;
        this.producerName = producerName;
        this.releasedOn = releasedOn;
        this.hasValueAddedPromotion = hasValueAddedPromotion;
        this.hasLimitedTimeOffer = hasLimitedTimeOffer;
        this.hasBonusRewardMiles = hasBonusRewardMiles;
        this.isSeasonal = isSeasonal;
        this.isVqa = isVqa;
        this.isOcb = isOcb;
        this.isKosher = isKosher;
        this.valueAddedPromotionDescription = valueAddedPromotionDescription;
        this.description = description;
        this.servingSuggestion = servingSuggestion;
        this.tastingNote = tastingNote;
        this.updatedAt = updatedAt;
        this.imageThumbUrl = imageThumbUrl;
        this.imageUrl = imageUrl;
        this.varietal = varietal;
        this.style = style;
        this.tertiaryCategory = tertiaryCategory;
        this.sugarInGramsPerLiter = sugarInGramsPerLiter;
        this.clearanceSaleSavingsInCents = clearanceSaleSavingsInCents;
        this.hasClearanceSale = hasClearanceSale;
        this.productNo = productNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isIsDiscontinued() {
        return isDiscontinued;
    }

    public void setIsDiscontinued(boolean isDiscontinued) {
        this.isDiscontinued = isDiscontinued;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        this.priceInCents = priceInCents;
    }

    public long getRegularPriceInCents() {
        return regularPriceInCents;
    }

    public void setRegularPriceInCents(long regularPriceInCents) {
        this.regularPriceInCents = regularPriceInCents;
    }

    public long getLimitedTimeOfferSavingsInCents() {
        return limitedTimeOfferSavingsInCents;
    }

    public void setLimitedTimeOfferSavingsInCents(long limitedTimeOfferSavingsInCents) {
        this.limitedTimeOfferSavingsInCents = limitedTimeOfferSavingsInCents;
    }

    public String getLimitedTimeOfferEndsOn() {
        return limitedTimeOfferEndsOn;
    }

    public void setLimitedTimeOfferEndsOn(String limitedTimeOfferEndsOn) {
        this.limitedTimeOfferEndsOn = limitedTimeOfferEndsOn;
    }

    public long getBonusRewardMiles() {
        return bonusRewardMiles;
    }

    public void setBonusRewardMiles(long bonusRewardMiles) {
        this.bonusRewardMiles = bonusRewardMiles;
    }

    public String getBonusRewardMilesEndsOn() {
        return bonusRewardMilesEndsOn;
    }

    public void setBonusRewardMilesEndsOn(String bonusRewardMilesEndsOn) {
        this.bonusRewardMilesEndsOn = bonusRewardMilesEndsOn;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getSecondaryCategory() {
        return secondaryCategory;
    }

    public void setSecondaryCategory(String secondaryCategory) {
        this.secondaryCategory = secondaryCategory;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPackage() {
        return _package;
    }

    public void setPackage(String _package) {
        this._package = _package;
    }

    public String getPackageUnitType() {
        return packageUnitType;
    }

    public void setPackageUnitType(String packageUnitType) {
        this.packageUnitType = packageUnitType;
    }

    public long getPackageUnitVolumeInMilliliters() {
        return packageUnitVolumeInMilliliters;
    }

    public void setPackageUnitVolumeInMilliliters(long packageUnitVolumeInMilliliters) {
        this.packageUnitVolumeInMilliliters = packageUnitVolumeInMilliliters;
    }

    public long getTotalPackageUnits() {
        return totalPackageUnits;
    }

    public void setTotalPackageUnits(long totalPackageUnits) {
        this.totalPackageUnits = totalPackageUnits;
    }

    public long getVolumeInMilliliters() {
        return volumeInMilliliters;
    }

    public void setVolumeInMilliliters(long volumeInMilliliters) {
        this.volumeInMilliliters = volumeInMilliliters;
    }

    public long getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(long alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public long getPricePerLiterOfAlcoholInCents() {
        return pricePerLiterOfAlcoholInCents;
    }

    public void setPricePerLiterOfAlcoholInCents(long pricePerLiterOfAlcoholInCents) {
        this.pricePerLiterOfAlcoholInCents = pricePerLiterOfAlcoholInCents;
    }

    public long getPricePerLiterInCents() {
        return pricePerLiterInCents;
    }

    public void setPricePerLiterInCents(long pricePerLiterInCents) {
        this.pricePerLiterInCents = pricePerLiterInCents;
    }

    public long getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public long getInventoryVolumeInMilliliters() {
        return inventoryVolumeInMilliliters;
    }

    public void setInventoryVolumeInMilliliters(long inventoryVolumeInMilliliters) {
        this.inventoryVolumeInMilliliters = inventoryVolumeInMilliliters;
    }

    public long getInventoryPriceInCents() {
        return inventoryPriceInCents;
    }

    public void setInventoryPriceInCents(long inventoryPriceInCents) {
        this.inventoryPriceInCents = inventoryPriceInCents;
    }

    public String getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(String sugarContent) {
        this.sugarContent = sugarContent;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(String releasedOn) {
        this.releasedOn = releasedOn;
    }

    public boolean isHasValueAddedPromotion() {
        return hasValueAddedPromotion;
    }

    public void setHasValueAddedPromotion(boolean hasValueAddedPromotion) {
        this.hasValueAddedPromotion = hasValueAddedPromotion;
    }

    public boolean isHasLimitedTimeOffer() {
        return hasLimitedTimeOffer;
    }

    public void setHasLimitedTimeOffer(boolean hasLimitedTimeOffer) {
        this.hasLimitedTimeOffer = hasLimitedTimeOffer;
    }

    public boolean isHasBonusRewardMiles() {
        return hasBonusRewardMiles;
    }

    public void setHasBonusRewardMiles(boolean hasBonusRewardMiles) {
        this.hasBonusRewardMiles = hasBonusRewardMiles;
    }

    public boolean isIsSeasonal() {
        return isSeasonal;
    }

    public void setIsSeasonal(boolean isSeasonal) {
        this.isSeasonal = isSeasonal;
    }

    public boolean isIsVqa() {
        return isVqa;
    }

    public void setIsVqa(boolean isVqa) {
        this.isVqa = isVqa;
    }

    public boolean isIsOcb() {
        return isOcb;
    }

    public void setIsOcb(boolean isOcb) {
        this.isOcb = isOcb;
    }

    public boolean isIsKosher() {
        return isKosher;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public String getValueAddedPromotionDescription() {
        return valueAddedPromotionDescription;
    }

    public void setValueAddedPromotionDescription(String valueAddedPromotionDescription) {
        this.valueAddedPromotionDescription = valueAddedPromotionDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServingSuggestion() {
        return servingSuggestion;
    }

    public void setServingSuggestion(String servingSuggestion) {
        this.servingSuggestion = servingSuggestion;
    }

    public String getTastingNote() {
        return tastingNote;
    }

    public void setTastingNote(String tastingNote) {
        this.tastingNote = tastingNote;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageThumbUrl() {
        return imageThumbUrl;
    }

    public void setImageThumbUrl(String imageThumbUrl) {
        this.imageThumbUrl = imageThumbUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTertiaryCategory() {
        return tertiaryCategory;
    }

    public void setTertiaryCategory(String tertiaryCategory) {
        this.tertiaryCategory = tertiaryCategory;
    }

    public String getSugarInGramsPerLiter() {
        return sugarInGramsPerLiter;
    }

    public void setSugarInGramsPerLiter(String sugarInGramsPerLiter) {
        this.sugarInGramsPerLiter = sugarInGramsPerLiter;
    }

    public long getClearanceSaleSavingsInCents() {
        return clearanceSaleSavingsInCents;
    }

    public void setClearanceSaleSavingsInCents(long clearanceSaleSavingsInCents) {
        this.clearanceSaleSavingsInCents = clearanceSaleSavingsInCents;
    }

    public boolean isHasClearanceSale() {
        return hasClearanceSale;
    }

    public void setHasClearanceSale(boolean hasClearanceSale) {
        this.hasClearanceSale = hasClearanceSale;
    }

    public long getProductNo() {
        return productNo;
    }

    public void setProductNo(long productNo) {
        this.productNo = productNo;
    }

    public boolean getIsDead() {
        return this.isDead;
    }

    public boolean getIsDiscontinued() {
        return this.isDiscontinued;
    }

    public String get_package() {
        return this._package;
    }

    public void set_package(String _package) {
        this._package = _package;
    }

    public boolean getHasValueAddedPromotion() {
        return this.hasValueAddedPromotion;
    }

    public boolean getHasLimitedTimeOffer() {
        return this.hasLimitedTimeOffer;
    }

    public boolean getHasBonusRewardMiles() {
        return this.hasBonusRewardMiles;
    }

    public boolean getIsSeasonal() {
        return this.isSeasonal;
    }

    public boolean getIsVqa() {
        return this.isVqa;
    }

    public boolean getIsOcb() {
        return this.isOcb;
    }

    public boolean getIsKosher() {
        return this.isKosher;
    }

    public boolean getHasClearanceSale() {
        return this.hasClearanceSale;
    }

}