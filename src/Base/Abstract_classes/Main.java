package Base.Abstract_classes;



public class Main {

    public static void main(String[] args) {
        // Animal animal = new Animal(); - так сделать не получится, так каак класс абстрактный
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.eat();
        cat.eat();

        dog.make_sound();
        cat.make_sound();
    }

}
