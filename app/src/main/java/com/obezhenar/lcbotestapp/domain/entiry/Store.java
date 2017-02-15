package com.obezhenar.lcbotestapp.domain.entiry;

public class Store {
    private long id;
    private String name;
    private String address1;
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
