package org.example.delivery.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.delivery.entity.Client;
import org.example.delivery.entity.Laptop;
import org.example.delivery.entity.Order;
import org.example.delivery.entity.Shop;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    List<Order> orders = new ArrayList<Order>();

    public void writeOrders() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try
        {
            writer.writeValue(Paths.get("orders.json").toFile(), orders);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getOrders() {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            // convert JSON array to list
            orders = mapper.readValue(Paths.get("orders.json").toFile(), new TypeReference<List<Order>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeOrder(Shop shop, Laptop laptop, Client client, int quantity) {
        Order order = new Order(client.getName(), client.getSurname(), client.getAge(),
                client.getAddress(), shop.getShopName(), laptop);
        orders.add(order);
        writeOrders();
    }

    public void show(){
        System.out.println(orders.toString());
    }
}
