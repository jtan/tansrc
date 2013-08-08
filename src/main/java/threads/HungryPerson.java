package threads;

/**
 * @author jtan
 * @version 8/8/13
 */

public class HungryPerson {
    private int bites;
    private Chopstick left, right;

    public HungryPerson(Chopstick right) {
        this.left = new Chopstick();
        this.right = right;
    }

    public boolean pickUp() {
        return right.pickUp();
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    public void chew() {
        // do some chewing here
    }

    public void putDown() {
        right.putDown();
    }
}