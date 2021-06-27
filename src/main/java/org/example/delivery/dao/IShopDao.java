package org.example.delivery.dao;

import org.example.delivery.entity.Category;
import org.example.delivery.entity.Laptop;
import org.example.delivery.entity.Shop;

public interface IShopDao {
    void writeShops();
    void getShops();
    void addShop(String shopName);
    void show();
    void edit(Shop shop, String newName);
    void delete(Shop shop);
    void getNames();
    void getBrands(Shop shop);
    void getCategoryNames(Shop shop);
    void getBrandsAndModels(Shop shop);
    void getQuantities(Laptop laptop);
    Shop selectShop (String name);
    void addLaptop(String brand, String model, int price, String processor,
                   String graphicsCard, int ssdCapacity, int ram, int number, Shop shop);
    void editBrand(Laptop laptop, String newBrand);
    void editModel(Laptop laptop, String newModel);
    void editProcessor(Laptop laptop, String newProcessor);
    void editGraphicsCard(Laptop laptop, String newGraphicsCard);
    void editSsdCapacity(Laptop laptop, int newSsdCapacity);
    void editRam(Laptop laptop, int newRam);
    void editPrice(Laptop laptop, int newPrice);
    void editQuantity(Laptop laptop, int newQuantity);
    Laptop selectLaptop(String brand, String model, Shop shop, int quantity);
    Laptop selectLaptop(String brand, String model, Shop shop);
    void deleteLaptop(Laptop laptop, Shop shop);
    void showLaptops(Shop shop);
    void sortLaptops(Shop shop);
    void searchByBrand(String model, Shop shop);
    void searchByBrandAndModel(String brand, String model, Shop shop);
    void addCategory(Shop shop, String name);
    Category selectCategory(Shop shop, String name);
    void addLaptopToCategory(Laptop laptop, Category category);
    void laptopsFromCategory(Category category);
    void categoriesFromShop(Shop shop);
}
