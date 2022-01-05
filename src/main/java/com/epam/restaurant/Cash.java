package com.epam.restaurant;

import com.epam.client.Client;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cash {

    private int id;
    private boolean state = true;

    private final Lock lock = new ReentrantLock();

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
        lock.lock();
        try {
            return state;
        } finally {
            lock.unlock();
        }
    }

    public void setState(boolean state) {
        lock.lock();
        try {
            this.state = state;
        } finally {
            lock.unlock();
        }
    }

    public void serve(Client client) {
        lock.lock();
        try {
            client.setState(true);
        } finally {
            lock.unlock();
        }
    }
}
