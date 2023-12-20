package Base.Generics;

import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); //<String> - дженерик который говорит о том, что в list будет хранится только объекты класса String
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1));

        test3(animals);

    }

    public static void test(List<Animal> list){//На вход можно подать только объект типа класс Animal (Наследников нельзя)
        for (Animal animal: list){
            System.out.println(animal);
        }
    }
    public static void test2(List<? extends Animal> list){//На вход можно подать объект типа класса Animal или его наследников.
        // <?> - whildeCard
        for (Animal animal: list){
            System.out.println(animal);
        }
    }
    public static void test3(List<? super Animal> list){//На вход можно подать объект типа класса Animal или его предков.
        // <?> - whildeCard
        for (Object object: list){
            System.out.println(object);
        }
    }



}
