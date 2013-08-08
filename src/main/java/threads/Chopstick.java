package threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Classic example of thread locking with chopstick game.  Imagine each person has a left chopstick but the right chopstick
 * is shared.  Therefore, everyone must try to grab the right chopstick from the middle when they want to eat.
 *
 * @author jtan
 * @version 8/8/13
 */
public class Chopstick{
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}