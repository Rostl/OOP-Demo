package by.rost.jd01_16.ex1;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ToString
public class Account implements Comparable<Account> {

    private static long idGenerator = 0L;
    @Getter
    private final Lock LOCK = new ReentrantLock();

    private long id;
    private int amount;

    public Account(int amount) {
        this.amount = amount;
        this.id = idGenerator++;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public boolean takeOff(int amount) {
        boolean result = this.amount >= amount;
        if (result) {
            this.amount -= amount;
        }

        return result;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(this.id, o.id);
    }
}
