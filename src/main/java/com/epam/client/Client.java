package com.epam.client;

import com.epam.restaurant.Restaurant;

import java.util.Objects;

public class Client implements Runnable {

    private int id;
    private boolean state = false;

    public Client() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isServed() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void run() {

        Restaurant restaurant = Restaurant.getInstance();
        restaurant.serve(this);

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Client clientInstance = (Client) object;
        return id == clientInstance.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                '}';
    }
}
