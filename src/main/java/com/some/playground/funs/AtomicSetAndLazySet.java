package com.some.playground.funs;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSetAndLazySet {
    AtomicInteger atomic = new AtomicInteger(0);
    public static void main(String[] args) {
        AtomicSetAndLazySet atomicSetAndLazySet = new AtomicSetAndLazySet();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // atomicSetAndLazySet.atomic.set(i);
                atomicSetAndLazySet.atomic.lazySet(i);
                System.out.println("Set: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (atomicSetAndLazySet.atomic) {
                    int counter = atomicSetAndLazySet.atomic.get();
                    System.out.println("Get: " + counter);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
