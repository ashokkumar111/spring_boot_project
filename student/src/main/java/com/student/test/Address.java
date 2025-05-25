package com.student.test;
public final class Address {
    private final String cityName;
    private  final String country;

    public Address(String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
    }
    public String getCityName() {
        return cityName;
    }
    public String getCountry() {
        return country;
    }
}
