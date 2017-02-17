package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Store {
    public static final String HAS_WHEELCHAIR_ACCESSABILITY = "has_wheelchair_accessability";
    public static final String HAS_BILINGUAL_SERVICES = "has_bilingual_services";
    public static final String HAS_TASTING_BAR = "has_tasting_bar";
    public static final String HAS_BEER_COLD_ROOM = "has_beer_cold_room";
    public static final String HAS_VINTAGES_CORNER = "has_vintages_corner";
    public static final String HAS_PARKING = "has_parking";

    @Id
    private long id;
    private String name;
    @SerializedName("address_line_1")
    private String address1;
    @SerializedName("address_line_2")
    private String address2;
    private String city;
    private String telephone;
    private double latitude;
    private double longitude;
    @SerializedName("has_wheelchair_accessability")
    private boolean hasWheelchairAccessability;
    @SerializedName("has_bilingual_services")
    private boolean hasBilingualServices;
    @SerializedName("has_tasting_bar")
    private boolean hasTastingBar;
    @SerializedName("has_beer_cold_room")
    private boolean hasBeerColdRoom;
    @SerializedName("has_vintages_corner")
    private boolean hasVintagesCorner;
    @SerializedName("has_parking")
    private boolean hasParking;

    public Store(long id, String name, String address1, String address2, String city) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }

    @Generated(hash = 770513066)
    public Store() {
    }

    @Generated(hash = 774216441)
    public Store(long id, String name, String address1, String address2, String city,
                 String telephone, double latitude, double longitude,
                 boolean hasWheelchairAccessability, boolean hasBilingualServices,
                 boolean hasTastingBar, boolean hasBeerColdRoom, boolean hasVintagesCorner,
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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean getHasWheelchairAccessability() {
        return this.hasWheelchairAccessability;
    }

    public void setHasWheelchairAccessability(boolean hasWheelchairAccessability) {
        this.hasWheelchairAccessability = hasWheelchairAccessability;
    }

    public boolean getHasBilingualServices() {
        return this.hasBilingualServices;
    }

    public void setHasBilingualServices(boolean hasBilingualServices) {
        this.hasBilingualServices = hasBilingualServices;
    }

    public boolean getHasTastingBar() {
        return this.hasTastingBar;
    }

    public void setHasTastingBar(boolean hasTastingBar) {
        this.hasTastingBar = hasTastingBar;
    }

    public boolean getHasBeerColdRoom() {
        return this.hasBeerColdRoom;
    }

    public void setHasBeerColdRoom(boolean hasBeerColdRoom) {
        this.hasBeerColdRoom = hasBeerColdRoom;
    }

    public boolean getHasVintagesCorner() {
        return this.hasVintagesCorner;
    }

    public void setHasVintagesCorner(boolean hasVintagesCorner) {
        this.hasVintagesCorner = hasVintagesCorner;
    }

    public boolean getHasParking() {
        return this.hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }
}
