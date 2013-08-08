package patterns;

/**
 * @author jtan
 * @version 8/8/13
 */

public class SingletonPattern {
    private static SingletonPattern instance = null;

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
         return instance;
    }
}