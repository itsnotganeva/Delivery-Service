package org.example.delivery.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Laptop> laptops = new ArrayList<>();

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, List<Laptop> laptops) {
        this.categoryName = categoryName;
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Name='" + categoryName + '\'' +
                '}';
    }
}
