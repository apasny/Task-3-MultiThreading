package com.epam.client;

import java.util.List;
import java.util.Objects;

public class Clients {

    private List<Client> clients;

    public Clients() {
        super();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Clients clientsInstance = (Clients) object;
        return Objects.equals(clients, clientsInstance.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }


}
