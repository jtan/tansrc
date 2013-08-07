package patterns;

public class FactoryPattern {

    public static Animal createAnimal(AnimalType type) {
        switch (type) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            default:
                return new Animal();
        }
    }

}