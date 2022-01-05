package com.epam.restaurant;

import com.epam.client.Client;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {

    private final Cashes cashes = new Cashes();
    private static Restaurant instance;
    private static final Lock lock = new ReentrantLock();
    private final Semaphore semaphore = new Semaphore(cashes.getCashes().size());


    private Restaurant() {
    }

    public static Restaurant getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Restaurant();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public void serve(Client client) {
        try {
            Cash cash = cashes.getCash();

            semaphore.acquire();
            lock.lock();

            cash.setState(false);

            cash.serve(client);
            System.out.println("Client " + client.getId() + " was served by cash " + cash.getId());

            cash.setState(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            lock.unlock();
        }
    }
}
