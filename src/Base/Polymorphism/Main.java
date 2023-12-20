package Base.Polymorphism;

public class Main {
    public static void main(String[] args) {
        //Upcasting - Восходящее преобразование. Происходит неявное преобразование, так как все переменные и методы,
        // что есть у родителя есть и у ребёнка.
        Animal animal2 = new Dog(); // При таком создании мы будем иметь доступ только к методам определённым в родительском классе
        animal2.eat(); // Вызовется метод переопределённый в Dog, это называется поздним связыванием
        //animal.bark(); не сможем вызвать, так как такого метода нет в классе Animal

        //Downcasting - безопасно только лишь в том случае если мы знаем, что animal2 создержит в себе Dog
        // и просто рассматривается как Animal. Иначе получим ошибку
        Dog dog2 = (Dog) animal2;
        dog2.bark();

        Animal animal = new Animal();
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        test(animal);
        test(dog);
        test(cat);
    }

    public static void test(Animal animal){// Могу в этот метод передавать как объекты класса Animal,
        // так и класса Cat и Dog. Это и называется полимфорфизм. Происходит это потомучто, я могу быть на 100% уверен,
        // что весь код выполнится, так как все переменные и методы, что есть у родителя есть и у ребёнка.
        animal.eat();
    }

}
