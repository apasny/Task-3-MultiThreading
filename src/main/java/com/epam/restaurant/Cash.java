package com.epam.restaurant;

import com.epam.client.Client;

public class Cash {

    private int id;
    private boolean state = true;

    public Cash(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void serve(Client client) {
        client.setState(true);
    }
}
