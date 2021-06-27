package org.example.delivery.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.delivery.entity.Client;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ClientDao implements IClientDao{

    List<Client> clients = new ArrayList<Client>();

    @Override
    public void writeClients() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try
        {
            writer.writeValue(Paths.get("clients.json").toFile(), clients);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getClients() {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            // convert JSON array to list
           clients = mapper.readValue(Paths.get("clients.json").toFile(), new TypeReference<List<Client>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addClient(String name, String surname, int age, String address) {

        Client client = new Client(name, surname, age, address);
        clients.add(client);
        writeClients();
    }

    @Override
    public void show(){
        System.out.println(clients.toString());
    }

    @Override
    public void getNamesAndSurnames() {
        for (Client client : clients) {
            System.out.println(client.getName() + " " + client.getSurname());
        }
    }

    @Override
    public void editName(Client client, String newName) {
        client.setName(newName);
        writeClients();
    }

    @Override
    public void editSurname(Client client, String newSurname) {
        client.setSurname(newSurname);
        writeClients();
    }

    @Override
    public void editAge(Client client, int newAge) {
        client.setAge(newAge);
        writeClients();
    }

    @Override
    public void editAddress(Client client, String newAddress) {
        client.setAddress(newAddress);
        writeClients();
    }

    @Override
    public Client selectClient(String name, String surname) {
        for (Client client: clients) {
            if (client.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))
                    && client.getSurname().toLowerCase(Locale.ROOT).equals(surname.toLowerCase(Locale.ROOT))) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void delete(Client client) {
        clients.remove(client);
        writeClients();
    }

}