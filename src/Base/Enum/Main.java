package Base.Enum;

public class Main {



    public static void main(String[] args) {
        Animal animal = Animal.FROG;
        switch (animal){
            case CAT:
                System.out.println("It is a cat");
                break;
            case DOG:
                System.out.println("It is a dog");
                break;
            case FROG:
                System.out.println("It is a frog");
                break;
            case BIRD:
                System.out.println("It is a bird");
                break;
            default:
                System.out.println("I don know how is it -_-");
        }

        System.out.println(animal.name());
        System.out.println(animal);

        Animal animal2 = Animal.valueOf("CAT");
        System.out.println(animal2);
        System.out.println("Индекс enum " + animal2.name() + ": " + animal2.ordinal());
    }
}
