package org.example.delivery.entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String shopName;
    private List<Laptop> laptopList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Shop() {
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public Shop(String shopName, List<Category> categoryList) {
        this.shopName = shopName;
        this.categoryList = categoryList;
    }

    public Shop(String shopName, List<Laptop> laptopList, List<Category> categoryList) {
        this.shopName = shopName;
        this.laptopList = laptopList;
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Name: " + shopName + "\n";
    }
}
