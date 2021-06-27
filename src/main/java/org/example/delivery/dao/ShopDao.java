package org.example.delivery.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.delivery.entity.Category;
import org.example.delivery.entity.Laptop;
import org.example.delivery.entity.Shop;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ShopDao implements IShopDao {

    List<Shop> shops = new ArrayList<Shop>();

    @Override
    public void writeShops() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try
        {
            writer.writeValue(Paths.get("shops.json").toFile(), shops);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getShops() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list
            shops = mapper.readValue(Paths.get("shops.json").toFile(), new TypeReference<List<Shop>>() {
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addShop(String shopName) {

        Shop shop = new Shop(shopName);
        shops.add(shop);
        writeShops();
    }

    @Override
    public void show() {
        System.out.println(shops.toString());
    }

    @Override
    public void edit(Shop shop, String newName) {
        shop.setShopName(newName);
        writeShops();
    }

    @Override
    public void delete(Shop shop) {
        shops.remove(shop);
        writeShops();
    }

    @Override
    public void getNames() {
        for (Shop shop : shops) {
            System.out.println(shop.getShopName());
        }
    }

    @Override
    public void getBrands(Shop shop) {
        for (Laptop laptop : shop.getLaptopList()) {
            System.out.println(laptop.getBrand());
        }
    }

    @Override
    public void getCategoryNames(Shop shop) {
        for (Category category : shop.getCategoryList()) {
            System.out.println(category.getCategoryName());
        }
    }

    @Override
    public void getBrandsAndModels(Shop shop) {
        for (Laptop laptop : shop.getLaptopList()) {
            System.out.println(laptop.getBrand() + " " + laptop.getModel());
        }
    }

    @Override
    public void getQuantities(Laptop laptop) {
        System.out.println("In stock " + laptop.getQuantity());
    }

    @Override
    public Shop selectShop (String name) {
        for (Shop shop : shops) {
            if (shop.getShopName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) {
                return shop;
            }
        }
        return null;
    }

    @Override
    public void addLaptop(String brand, String model, int price, String processor,
                          String graphicsCard, int ssdCapacity, int ram, int number, Shop shop) {

        Laptop laptop = new Laptop(brand, model, price, processor, graphicsCard, ssdCapacity, ram, number);
        shop.getLaptopList().add(laptop);

        writeShops();
    }

    @Override
    public void editBrand(Laptop laptop, String newBrand) {
        laptop.setBrand(newBrand);
        writeShops();
    }

    @Override
    public void editModel(Laptop laptop, String newModel) {
        laptop.setModel(newModel);
        writeShops();
    }

    @Override
    public void editProcessor(Laptop laptop, String newProcessor) {
        laptop.setProcessor(newProcessor);
        writeShops();
    }

    @Override
    public void editGraphicsCard(Laptop laptop, String newGraphicsCard) {
        laptop.setGraphicsCard(newGraphicsCard);
        writeShops();
    }

    @Override
    public void editSsdCapacity(Laptop laptop, int newSsdCapacity) {
        laptop.setSsdCapacity(newSsdCapacity);
        writeShops();
    }

    @Override
    public void editRam(Laptop laptop, int newRam) {
        laptop.setRam(newRam);
        writeShops();
    }

    @Override
    public void editPrice(Laptop laptop, int newPrice) {
        laptop.setPrice(newPrice);
        writeShops();
    }

    @Override
    public void editQuantity(Laptop laptop, int newQuantity) {
        laptop.setQuantity(newQuantity);
        writeShops();
    }

    @Override
    public Laptop selectLaptop(String brand, String model, Shop shop) {
        for (Laptop laptop : shop.getLaptopList()) {
            if (laptop.getBrand().toLowerCase(Locale.ROOT).equals(brand.toLowerCase(Locale.ROOT))
                    && laptop.getModel().toLowerCase(Locale.ROOT).equals(model.toLowerCase(Locale.ROOT))) {
                return laptop;
            }
        }
        return null;
    }

    @Override
    public Laptop selectLaptop(String brand, String model, Shop shop, int quantity) {
        for (Laptop laptop : shop.getLaptopList()) {
            if (laptop.getBrand().toLowerCase(Locale.ROOT).equals(brand.toLowerCase(Locale.ROOT))
                    && laptop.getModel().toLowerCase(Locale.ROOT).equals(model.toLowerCase(Locale.ROOT))) {

                Laptop laptopToOrder = new Laptop(laptop.getBrand(),laptop.getModel(), laptop.getPrice(),
                        laptop.getProcessor(), laptop.getGraphicsCard(), laptop.getSsdCapacity(),
                        laptop.getRam(), quantity);

                laptop.setQuantity(laptop.getQuantity() - quantity); //updating quantity information after placing an order
                return laptopToOrder;
            }
        }
        return null;
    }

    @Override
    public void deleteLaptop(Laptop laptop, Shop shop){

        shop.getLaptopList().remove(laptop);
        writeShops();
    }

    @Override
    public void showLaptops(Shop shop) {
        System.out.println(shop.getLaptopList().toString());
    }

    @Override
    public void sortLaptops(Shop shop) {
        Collections.sort(shop.getLaptopList(), ((o1, o2) -> o1.getPrice() - o2.getPrice()));
        System.out.println(shop.getLaptopList().toString());
    }

    @Override
    public void searchByBrand(String brand, Shop shop) {
        List<Laptop> brandLaptops = new ArrayList<>();
        for (Laptop laptop: shop.getLaptopList()) {
            if (laptop.getBrand().toLowerCase(Locale.ROOT).equals(brand.toLowerCase(Locale.ROOT))){
                brandLaptops.add(laptop);
            }
        }
        System.out.println(brandLaptops.toString());
    }

    @Override
    public void searchByBrandAndModel(String brand, String model, Shop shop) {
        List<Laptop> modelLaptops = new ArrayList<>();
        for (Laptop laptop : shop.getLaptopList()) {
            if (laptop.getBrand().toLowerCase(Locale.ROOT).equals(brand.toLowerCase(Locale.ROOT))
                    && laptop.getModel().toLowerCase(Locale.ROOT).equals(model.toLowerCase(Locale.ROOT))) {
                modelLaptops.add(laptop);
            }
        }
        System.out.println(modelLaptops.toString());
    }

    @Override
    public void addCategory(Shop shop, String name) {
        Category category = new Category(name);

        shop.getCategoryList().add(category);
        writeShops();
    }

    @Override
    public Category selectCategory(Shop shop, String name){
        for (Category category : shop.getCategoryList()) {
            if (category.getCategoryName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void addLaptopToCategory(Laptop laptop, Category category) {

        category.getLaptops().add(laptop);
        writeShops();
    }

    @Override
    public void laptopsFromCategory(Category category) {
        System.out.println(category.getLaptops().toString());
    }

    @Override
    public void categoriesFromShop(Shop shop) {
        System.out.println(shop.getCategoryList().toString());
    }

}