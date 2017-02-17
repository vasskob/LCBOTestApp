package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "stores")
public class Store {
    public static final String HAS_WHEELCHAIR_ACCESSABILITY = "has_wheelchair_accessability";
    public static final String HAS_BILINGUAL_SERVICES = "has_bilingual_services";
    public static final String HAS_TASTING_BAR = "has_tasting_bar";
    public static final String HAS_BEER_COLD_ROOM = "has_beer_cold_room";
    public static final String HAS_VINTAGES_CORNER = "has_vintages_corner";
    public static final String HAS_PARKING = "has_parking";

    @DatabaseField(id = true)
    private long id;
    @DatabaseField()
    private String name;
    @SerializedName("address_line_1")
    @DatabaseField()
    private String address1;
    @SerializedName("address_line_2")
    @DatabaseField()
    private String address2;
    @DatabaseField()
    private String city;
    @DatabaseField()
    private String telephone;
    @DatabaseField()
    private double latitude;
    @DatabaseField()
    private double longitude;
    @SerializedName("has_wheelchair_accessability")
    @DatabaseField()
    private boolean hasWheelchairAccessability;
    @SerializedName("has_bilingual_services")
    @DatabaseField()
    private boolean hasBilingualServices;
    @SerializedName("has_tasting_bar")
    @DatabaseField()
    private boolean hasTastingBar;
    @SerializedName("has_beer_cold_room")
    @DatabaseField()
    private boolean hasBeerColdRoom;
    @SerializedName("has_vintages_corner")
    @DatabaseField()
    private boolean hasVintagesCorner;
    @SerializedName("has_parking")
    @DatabaseField()
    private boolean hasParking;

    public Store(long id, String name, String address1, String address2, String city) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }

    public Store() {
    }

    public Store(long id,
                 String name,
                 String address1,
                 String address2,
                 String city,
                 String telephone,
                 double latitude,
                 double longitude,
                 boolean hasWheelchairAccessability,
                 boolean hasBilingualServices,
                 boolean hasTastingBar,
                 boolean hasBeerColdRoom,
                 boolean hasVintagesCorner,
                 boolean hasParking) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.telephone = telephone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hasWheelchairAccessability = hasWheelchairAccessability;
        this.hasBilingualServices = hasBilingualServices;
        this.hasTastingBar = hasTastingBar;
        this.hasBeerColdRoom = hasBeerColdRoom;
        this.hasVintagesCorner = hasVintagesCorner;
        this.hasParking = hasParking;
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
