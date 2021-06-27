package org.example.delivery;

import org.example.delivery.dao.ClientDao;
import org.example.delivery.dao.OrderDao;
import org.example.delivery.dao.ShopDao;
import org.example.delivery.entity.Category;
import org.example.delivery.entity.Client;
import org.example.delivery.entity.Laptop;
import org.example.delivery.entity.Shop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ClientDao clientDao = new ClientDao();
        clientDao.getClients();

        ShopDao shopDao = new ShopDao();
        shopDao.getShops();

        OrderDao orderDao = new OrderDao();
        orderDao.getOrders();

        Menu menu = new Menu();
        menu.mainMenu();

        Scanner in = new Scanner(System.in);

        int num;

        do {
            num = in.nextInt();

            switch (num) {
                case 1:
                    shopDao.show();
                    int shopMenu;
                    do {
                        menu.shopMenu();
                        shopMenu = in.nextInt();
                        switch (shopMenu) {
                            case 1:
                                in.nextLine();
                                System.out.println("Name of shop: ");
                                String shopName = in.nextLine();
                                shopDao.addShop(shopName);
                                break;
                            case 2:
                                System.out.println("Choose the name of shop you want to edit: ");
                                in.nextLine();
                                shopDao.getNames();
                                String shopNameToEdit = in.nextLine();
                                Shop shopToEdit = shopDao.selectShop(shopNameToEdit);
                                System.out.println("Enter the new name of shop: ");
                                shopDao.edit(shopToEdit, in.nextLine());
                                break;
                            case 3:
                                System.out.println("Choose the name of shop you want to delete: ");
                                in.nextLine();
                                shopDao.getNames();
                                String shopNameToDelete = in.nextLine();
                                Shop shopToDelete = shopDao.selectShop(shopNameToDelete);
                                shopDao.delete(shopToDelete);
                                break;
                            case 4:
                                shopDao.show();
                                break;
                            case 5:
                                menu.mainMenu();
                                break;
                        }
                    }while (shopMenu!=5);
                    break;
                case 2:
                    clientDao.show();
                    int clientMenu;
                    do {
                        menu.clientMenu();
                        clientMenu = in.nextInt();
                        switch (clientMenu) {
                            case 1:
                                in.nextLine();
                                System.out.println("Name of client: ");
                                String name = in.nextLine();
                                System.out.println("Surname of client: ");
                                String surname = in.nextLine();
                                System.out.println("Age of client: ");
                                int age = in.nextInt();
                                in.nextLine();
                                System.out.println("Address of client: ");
                                String address = in.nextLine();
                                clientDao.addClient(name, surname, age, address);
                                break;
                            case 2:
                                System.out.println("Enter the name and surname of client you want to edit:");
                                clientDao.getNamesAndSurnames();
                                in.nextLine();
                                System.out.println("\nName: ");
                                String nameToEdit = in.nextLine();
                                System.out.println("Surname: ");
                                String surnameToEdit = in.nextLine();
                                Client clientToEdit = clientDao.selectClient(nameToEdit, surnameToEdit);
                                int editClient;
                                do {
                                    menu.editClientMenu();
                                    editClient = in.nextInt();
                                    switch (editClient) {
                                        case 1:
                                            in.nextLine();
                                            System.out.println("Enter the new name of client: ");
                                            clientDao.editName(clientToEdit, in.nextLine());
                                            break;
                                        case 2:
                                            in.nextLine();
                                            System.out.println("Enter the new surname of client: ");
                                            clientDao.editSurname(clientToEdit, in.nextLine());
                                            break;
                                        case 3:
                                            System.out.println("Enter the new age of client: ");
                                            clientDao.editAge(clientToEdit, in.nextInt());
                                            break;
                                        case 4:
                                            in.nextLine();
                                            System.out.println("Enter the new address of client: ");
                                            clientDao.editAddress(clientToEdit, in.nextLine());
                                            break;
                                    }
                                }while (editClient!=5);

                                break;
                            case 3:
                                System.out.println("Enter the name and surname of client you want to delete: ");
                                clientDao.getNamesAndSurnames();
                                System.out.println("\nName: ");
                                in.nextLine();
                                String nameToDelete = in.nextLine();
                                System.out.println("Surname: ");
                                String surnameToDelete = in.nextLine();
                                Client clientToDelete = clientDao.selectClient(nameToDelete, surnameToDelete);
                                clientDao.delete(clientToDelete);
                                break;
                            case 4:
                                clientDao.show();
                                break;
                            case 5:
                                menu.mainMenu();
                                break;
                        }
                    } while(clientMenu !=5);
                    break;
                case 3:
                    in.nextLine();
                    System.out.println("Enter the name of store where you want to check laptops: ");
                    shopDao.getNames();
                    Shop shopOfLaptop = shopDao.selectShop(in.nextLine());
                    shopDao.showLaptops(shopOfLaptop);
                    int laptopMenu;
                    do {
                        menu.laptopMenu();
                        laptopMenu = in.nextInt();
                        switch (laptopMenu) {
                            case 1:
                                in.nextLine();
                                System.out.println("Brand of laptop: ");
                                String brand = in.nextLine();
                                System.out.println("Model of laptop: ");
                                String model = in.nextLine();
                                System.out.println("Processor of laptop: ");
                                String processor = in.nextLine();
                                System.out.println("Graphics card of laptop: ");
                                String graphicsCard = in.nextLine();
                                System.out.println("SSD capacity of laptop (GB): ");
                                int ssdCapacity = in.nextInt();
                                System.out.println("RAM of laptop (GB): ");
                                int ram = in.nextInt();
                                System.out.println("Price of laptop ($): ");
                                int price = in.nextInt();
                                System.out.println("Number of this laptops: ");
                                int number = in.nextInt();

                                shopDao.addLaptop(brand, model, price, processor, graphicsCard, ssdCapacity, ram, number, shopOfLaptop);
                                break;
                            case 2:
                                in.nextLine();
                                System.out.println("Enter the brand and model of laptop you want to edit: ");
                                shopDao.getBrandsAndModels(shopOfLaptop);
                                System.out.println("\nBrand: ");
                                String brandToEdit = in.nextLine();
                                System.out.println("Model: ");
                                String modelToEdit = in.nextLine();
                                Laptop laptopToEdit = shopDao.selectLaptop(brandToEdit, modelToEdit, shopOfLaptop);
                                int editLaptop;
                                do {
                                    menu.editLaptopMenu();
                                    editLaptop = in.nextInt();
                                    switch (editLaptop) {
                                        case 1:
                                            in.nextLine();
                                            System.out.println("Enter the new brand of laptop: ");
                                            shopDao.editBrand(laptopToEdit, in.nextLine());
                                            break;
                                        case 2:
                                            in.nextLine();
                                            System.out.println("Enter the new model of laptop: ");
                                            shopDao.editModel(laptopToEdit, in.nextLine());
                                            break;
                                        case 3:
                                            in.nextLine();
                                            System.out.println("Enter the new processor of laptop: ");
                                            shopDao.editProcessor(laptopToEdit, in.nextLine());
                                            break;
                                        case 4:
                                            in.nextLine();
                                            System.out.println("Enter the new graphics card of laptop: ");
                                            shopDao.editGraphicsCard(laptopToEdit, in.nextLine());
                                            break;
                                        case 5:
                                            //in.nextLine();
                                            System.out.println("Enter the new SSD capacity of laptop: ");
                                            shopDao.editSsdCapacity(laptopToEdit, in.nextInt());
                                            break;
                                        case 6:
                                            //in.nextLine();
                                            System.out.println("Enter the new RAM of laptop: ");
                                            shopDao.editRam(laptopToEdit, in.nextInt());
                                            break;
                                        case 7:
                                            //in.nextLine();
                                            System.out.println("Enter the new price of laptop: ");
                                            shopDao.editPrice(laptopToEdit, in.nextInt());
                                            break;
                                        case 8:
                                            System.out.println("Enter the new number of laptops: ");
                                            shopDao.editQuantity(laptopToEdit, in.nextInt());
                                            break;
                                    }
                                }while (editLaptop!=9);
                                break;
                            case 3:
                                in.nextLine();
                                System.out.println("Enter the brand and model of laptop you want to delete: ");
                                shopDao.getBrandsAndModels(shopOfLaptop);
                                System.out.println("\nBrand: ");
                                String brandToDelete = in.nextLine();
                                System.out.println("Model: ");
                                String modelToDelete = in.nextLine();
                                Laptop laptopToDelete = shopDao.selectLaptop(brandToDelete, modelToDelete, shopOfLaptop);
                                shopDao.deleteLaptop(laptopToDelete, shopOfLaptop);
                                break;
                            case 4:
                                shopDao.sortLaptops(shopOfLaptop);
                                break;
                            case 5:
                                in.nextLine();
                                System.out.println("Enter the brand of laptop you want to search:");
                                shopDao.getBrands(shopOfLaptop);
                                String brandToSearch = in.nextLine();
                                shopDao.searchByBrand(brandToSearch, shopOfLaptop);
                                break;
                            case 6:
                                in.nextLine();
                                System.out.println("Enter the brand and model of laptop you want to search:");
                                shopDao.getBrandsAndModels(shopOfLaptop);
                                System.out.println("Brand: ");
                                String brandLaptop = in.nextLine();
                                System.out.println("Model: ");
                                shopDao.searchByBrandAndModel(brandLaptop, in.nextLine(), shopOfLaptop);
                                break;
                            case 7:
                                shopDao.showLaptops(shopOfLaptop);
                                break;
                            case 8:
                                menu.mainMenu();
                                break;
                        }
                    }while (laptopMenu!=8);
                    break;
                case 4:
                    System.out.println("Enter the name of shop where you want to check categories: ");
                    shopDao.getNames();
                    in.nextLine();
                    Shop shopOfCategory = shopDao.selectShop(in.nextLine());
                    shopDao.categoriesFromShop(shopOfCategory);
                    int categoryMenu;
                    do {
                        menu.categoryMenu();
                        categoryMenu = in.nextInt();
                        switch (categoryMenu) {
                            case 1:
                                in.nextLine();
                                System.out.println("Enter the name of category: ");
                                String categoryName = in.nextLine();
                                shopDao.addCategory(shopOfCategory, categoryName);
                                break;
                            case 2:
                                in.nextLine();
                                System.out.println("Enter the name of category where you want to add laptop: ");
                                shopDao.getCategoryNames(shopOfCategory);
                                Category category = shopDao.selectCategory(shopOfCategory, in.nextLine());
                                System.out.println("Enter the brand and model of laptop you want to add: ");
                                shopDao.getBrandsAndModels(shopOfCategory);
                                System.out.println("Brand: ");
                                String brandToAdd = in.nextLine();
                                System.out.println("Model: ");
                                String modelToAdd = in.nextLine();
                                Laptop laptopToAdd = shopDao.selectLaptop(brandToAdd, modelToAdd, shopOfCategory);
                                shopDao.addLaptopToCategory(laptopToAdd, category);
                                break;
                            case 3:
                                shopDao.categoriesFromShop(shopOfCategory);
                                break;
                            case 4:
                                in.nextLine();
                                System.out.println("Enter the name of category where you want to check laptops: ");
                                shopDao.getCategoryNames(shopOfCategory);
                                Category categoryToCheck = shopDao.selectCategory(shopOfCategory, in.nextLine());
                                shopDao.laptopsFromCategory(categoryToCheck);
                                break;
                            case 5:
                                menu.mainMenu();
                                break;
                        }
                    }while (categoryMenu!=5);
                    break;
                case 5:
                    orderDao.show();
                    int orderMenu;
                    do {
                        menu.orderMenu();
                        orderMenu = in.nextInt();
                        switch (orderMenu) {
                            case 1:
                                in.nextLine();
                                System.out.println("Enter the name of shop where you want to make an order: ");
                                shopDao.getNames();
                                Shop shopToOrder = shopDao.selectShop(in.nextLine());
                                System.out.println("Enter the brand and model of laptop you want to order and its quantity: ");
                                shopDao.getBrandsAndModels(shopToOrder);
                                System.out.println("Brand: ");
                                String brandToOrder = in.nextLine();
                                System.out.println("Model: ");
                                String modelToOrder = in.nextLine();
                                Laptop laptopToQuantity = shopDao.selectLaptop(brandToOrder, modelToOrder, shopToOrder);
                                shopDao.getQuantities(laptopToQuantity);
                                System.out.println("Quantity to order: ");
                                int quantityToOrder = in.nextInt();
                                Laptop laptopToOrder = shopDao.selectLaptop(brandToOrder, modelToOrder, shopToOrder, quantityToOrder);
                                System.out.println("Enter the client's name and surname to place an order: ");
                                clientDao.getNamesAndSurnames();
                                in.nextLine();
                                System.out.println("Name: ");
                                String nameToOrder = in.nextLine();
                                System.out.println("Surname: ");
                                String surnameToOrder = in.nextLine();
                                Client clientToOrder = clientDao.selectClient(nameToOrder, surnameToOrder);
                                orderDao.makeOrder(shopToOrder, laptopToOrder, clientToOrder, quantityToOrder);
                                break;
                            case 2:
                                orderDao.show();
                                break;
                            case 3:
                                menu.mainMenu();
                                break;
                        }
                    }while (orderMenu!=3);
            }
        } while (num !=6);

    }
}
