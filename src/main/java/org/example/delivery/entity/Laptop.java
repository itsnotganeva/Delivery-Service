package org.example.delivery.entity;

public class Laptop {
    private String brand;
    private String model;
    private int price;
    private String processor;
    private String graphicsCard;
    private int ssdCapacity;
    private int ram;
    private int quantity;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Laptop() {
    }

    public Laptop(String brand, String model, int price, String processor, String graphicsCard, int ssdCapacity, int ram, int quantity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.ssdCapacity = ssdCapacity;
        this.ram = ram;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " | Model: " + model + " | Processor: " + processor +
                " | Graphics card: " + graphicsCard + " | SSD capacity: " + ssdCapacity + "GB | RAM: " + ram +
                "GB | Price: " + price + "$ | Quantity: " + quantity + "\n";
    }
}
