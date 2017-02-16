package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.SerializedName;

public class Store {
    public static final String HAS_WHEELCHAIR_ACCESSABILITY = "has_wheelchair_accessability";
    public static final String HAS_BILINGUAL_SERVICES = "has_bilingual_services";
    public static final String HAS_PRODUCT_CONSULTANT = "has_product_consultant";
    public static final String HAS_TASTING_BAR = "has_tasting_bar";
    public static final String HAS_BEER_COLD_ROOM = "has_beer_cold_room";
    public static final String HAS_SPECIAL_OCCASION_PERMITS = "has_special_occasion_permits";
    public static final String HAS_VINTAGES_CORNER = "has_vintages_corner";
    public static final String HAS_PARKING = "has_parking";
    public static final String HAS_TRANSIT_ACCESS = "has_transit_access";

    private long id;
    private String name;
    @SerializedName("address_line_1")
    private String address1;
    @SerializedName("address_line_2")
    private String address2;
    private String city;

    public Store(long id, String name, String address1, String address2, String city) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
