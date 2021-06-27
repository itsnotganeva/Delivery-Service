package org.example.delivery.dao;

import org.example.delivery.entity.Client;

public interface IClientDao {

    void writeClients();
    void getClients();
    void addClient(String name, String surname, int age, String address);
    void show();
    void getNamesAndSurnames();
    void editName(Client client, String newName);
    void editSurname(Client client, String newSurname);
    void editAge(Client client, int newAge);
    void editAddress(Client client, String newAddress);
    Client selectClient(String name, String surname);
    void delete(Client client);
}
