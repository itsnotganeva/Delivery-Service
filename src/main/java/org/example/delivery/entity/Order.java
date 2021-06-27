package org.example.delivery.entity;

public class Order {

    private String clientName;
    private String clientSurname;
    private int clientAge;
    private String clientAddress;
    private String shopName;
    private Laptop laptop;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Order() {
    }

    public Order(String clientName, String clientSurname, int clientAge, String clientAddress, String shopName, Laptop laptop) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAge = clientAge;
        this.clientAddress = clientAddress;
        this.shopName = shopName;
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Order{" +
                "clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientAge=" + clientAge +
                ", clientAddress='" + clientAddress + '\'' +
                ", shopName='" + shopName + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
