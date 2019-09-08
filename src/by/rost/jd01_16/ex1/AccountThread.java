package by.rost.jd01_16.ex1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

@AllArgsConstructor
public class AccountThread extends Thread {

    private final Account from;
    private final Account to;

    @Override
    public void run() {
        int sum = 10;
        LinkedList<Account> accounts = new LinkedList<>();
        accounts.add(from);
        accounts.add(to);
//        accounts.sort(Comparator.naturalOrder());
        Collections.sort(accounts);

        for (int i = 0; i < 200; i++) {
            synchronized (accounts.getFirst()) {
                synchronized (accounts.getLast()) {
                    if (from.takeOff(sum)) {
                        to.add(sum);
                    }
                }
                //todo
            }
        }
    }
}
