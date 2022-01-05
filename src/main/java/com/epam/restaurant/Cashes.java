package com.epam.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashes {

    private final Lock lock = new ReentrantLock();
    private final List<Cash> cashes = createList();

    public List<Cash> getCashes() {
        return cashes;
    }

    public Cash getCash() {
        lock.lock();
        try {
            for (Cash cash : cashes) {
                if (cash.isFree()) {
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
        cashes.add(new Cash(3));
        return cashes;
    }
}
