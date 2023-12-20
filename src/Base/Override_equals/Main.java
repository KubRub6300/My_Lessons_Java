package Base.Override_equals;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);
        System.out.println("Через equals: " + animal1.equals(animal2));
        System.out.println("Через == : " + (animal1 == animal2));


    }
}
