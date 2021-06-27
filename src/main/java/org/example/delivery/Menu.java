package org.example.delivery;

public class Menu {

    public void mainMenu() {
        System.out.println("1 - Show list of shops\n" +
                "2 - Show list of clients\n" +
                "3 - Show list of laptops\n" +
                "4 - Show list of categories\n" +
                "5 - Show list of orders\n" +
                "6 - Exit");

    }
    public void clientMenu() {
        System.out.println("1 - Register new client\n" +
                "2 - Edit client\n" +
                "3 - Delete client\n" +
                "4 - Show list of clients again\n" +
                "5 - Back");
    }
    public void editClientMenu() {
        System.out.println("1 - Edit name\n" +
                "2 - Edit surname\n" +
                "3 - Edit age\n" +
                "4 - Edit address\n" +
                "5 - Back");
    }
    public void shopMenu() {
        System.out.println("1 - Register new shop\n" +
                "2 - Edit shop\n" +
                "3 - Delete shop\n" +
                "4 - Show list of shops again\n" +
                "5 - Back");
    }
    public void laptopMenu() {
        System.out.println("1 - Add new laptop\n" +
                "2 - Edit laptop\n" +
                "3 - Delete laptop\n" +
                "4 - Sort by price\n" +
                "5 - Search laptop by brand\n" +
                "6 - Search laptop by brand and model\n" +
                "7 - Show list of laptops again\n" +
                "8 - Back");
    }

    public void editLaptopMenu() {
        System.out.println("Choose what you want edit:\n" +
                "1 - Edit brand\n" +
                "2 - Edit model\n" +
                "3 - Edit processor\n" +
                "4 - Edit graphics card\n" +
                "5 - Edit SSD capacity\n" +
                "6 - Edit RAM\n" +
                "7 - Edit Price\n" +
                "8 - Edit number of laptops\n" +
                "9 - Back");
    }
    public void categoryMenu() {
        System.out.println("1 - Add new category\n" +
                "2 - Add laptop to category\n" +
                "3 - Show list of categories again\n" +
                "4 - Show laptops from category\n" +
                "5 - Back");
    }
    public void orderMenu() {
        System.out.println("1 - Make a new order\n" +
                "2 - Show list of orders again\n" +
                "3 - Back");
    }

}
