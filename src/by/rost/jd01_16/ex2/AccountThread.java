package by.rost.jd01_16.ex2;

import by.itacademy.lesson15.ex1.Account;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.LinkedList;

@AllArgsConstructor
public class AccountThread extends Thread {

    private final Account from;
    private final Account to;

    @Override
    public void run() {
        int sum = 10;
        for (int i = 0; i < 200; i++) {
            try {
                lockAccounts();
                if (from.takeOff(sum)) {
                    to.add(sum);
                }
            } finally {
                from.getLOCK().unlock();
                to.getLOCK().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLock = from.getLOCK().tryLock();
            boolean toLock = to.getLOCK().tryLock();
            if (fromLock && toLock) {
                break;
            }
            if (fromLock) {
                from.getLOCK().unlock();
            }
            if (toLock) {
                to.getLOCK().unlock();
            }
        }
    }
}
