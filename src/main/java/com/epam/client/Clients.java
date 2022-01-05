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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients1 = (Clients) o;
        return Objects.equals(clients, clients1.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }


}
