package com.student.test;
public  final class Demo3 {
    private final int id;
    private final String name;
    private final Address address;

    public Demo3(int id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
