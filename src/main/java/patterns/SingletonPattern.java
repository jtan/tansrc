package patterns;

public class SingletonPattern {
    private static SingletonPattern instance = null;

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
         return instance;
    }
}