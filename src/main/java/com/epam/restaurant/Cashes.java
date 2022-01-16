package com.epam.restaurant;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashes {

    private final Lock lock = new ReentrantLock();
    private static final List<Cash> cashes = createList();

    public static List<Cash> getCashes() {
        return cashes;
    }

    public Cash getCash() {
        lock.lock();
        try {
            for (Cash cash : cashes) {
                if (cash.isFree()) {
                    cash.setState(false);
                    return cash;
                }
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    private static List<Cash> createList() {
        List<Cash> cashes = new ArrayList<>();
        cashes.add(new Cash(1));
        cashes.add(new Cash(2));
        return cashes;
    }
}
