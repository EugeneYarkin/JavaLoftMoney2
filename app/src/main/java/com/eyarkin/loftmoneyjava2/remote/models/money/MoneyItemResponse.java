package com.eyarkin.loftmoneyjava2.remote.models.money;

public class MoneyItemResponse {
    private String date;
    private int id;
    private String name;
    private int price;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


}
