package com.epam.restaurant;

import com.epam.client.Client;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {

    private static Restaurant instance;
    private final Cashes cashes = new Cashes();
    private static final Lock cashLock = new ReentrantLock();
    private static final Lock restaurantLock = new ReentrantLock();
    private final Semaphore cashSemaphore = new Semaphore(Cashes.getCashes().size());


    private Restaurant() {
    }

    public static Restaurant getInstance() {
        Restaurant localInstance = instance;
        restaurantLock.lock();
        try {
            if (localInstance == null) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new Restaurant();
                    instance = localInstance;
                }
            }
        } finally {
            restaurantLock.unlock();
        }
        return localInstance;
    }

    public void serve(Client client) {
        try {

            cashSemaphore.acquire();

            Cash cash = cashes.getCash();

            cashLock.lock();

            cash.serve(client);
            cash.setState(true);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cashSemaphore.release();
            cashLock.unlock();
        }
    }
}
