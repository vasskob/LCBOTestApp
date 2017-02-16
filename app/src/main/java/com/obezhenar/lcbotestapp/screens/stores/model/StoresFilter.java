package com.obezhenar.lcbotestapp.screens.stores.model;

public class StoresFilter {
    private Boolean hasWheelChairAccessibility;
    private Boolean hasBilingualServices;
    private Boolean hasParking;
    private Boolean hasTastingBar;
    private Boolean hasBeerColdRoom;
    private Boolean hasVintagesCorner;

    public StoresFilter() {
    }

    public StoresFilter(Boolean hasWheelChairAccessibility, Boolean hasBilingualServices, Boolean hasParking, Boolean hasTastingBar, Boolean hasBeerColdRoom, Boolean hasVintagesCorner) {
        this.hasWheelChairAccessibility = hasWheelChairAccessibility;
        this.hasBilingualServices = hasBilingualServices;
        this.hasParking = hasParking;
        this.hasTastingBar = hasTastingBar;
        this.hasBeerColdRoom = hasBeerColdRoom;
        this.hasVintagesCorner = hasVintagesCorner;
    }

    public Boolean getHasWheelChairAccessibility() {
        return hasWheelChairAccessibility;
    }

    public void setHasWheelChairAccessibility(Boolean hasWheelChairAccessibility) {
        this.hasWheelChairAccessibility = hasWheelChairAccessibility;
    }

    public Boolean getHasBilingualServices() {
        return hasBilingualServices;
    }

    public void setHasBilingualServices(Boolean hasBilingualServices) {
        this.hasBilingualServices = hasBilingualServices;
    }

    public Boolean getHasParking() {
        return hasParking;
    }

    public void setHasParking(Boolean hasParking) {
        this.hasParking = hasParking;
    }

    public Boolean getHasTastingBar() {
        return hasTastingBar;
    }

    public void setHasTastingBar(Boolean hasTastingBar) {
        this.hasTastingBar = hasTastingBar;
    }

    public Boolean getHasBeerColdRoom() {
        return hasBeerColdRoom;
    }

    public void setHasBeerColdRoom(Boolean hasBeerColdRoom) {
        this.hasBeerColdRoom = hasBeerColdRoom;
    }

    public Boolean getHasVintagesCorner() {
        return hasVintagesCorner;
    }

    public void setHasVintagesCorner(Boolean hasVintagesCorner) {
        this.hasVintagesCorner = hasVintagesCorner;
    }
}
