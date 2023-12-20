package Base.Anonymous_classes;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Animal animal1 = new Animal() { // Создание ананимного класса ( пофакту создаётся наследник класса Animal)
            @Override
            public void eat(){
                System.out.println("Override animal is eating...");
            }
        };
        animal1.eat();

        AbleToSpeak ableToSpeak = new AbleToSpeak() {// Создание анонимного класса (пофакту создаётся класс
            // реализующий интерфейс AbleToSpeak)
            @Override
            public void speak() {
                System.out.println("Speak...");
            }
        };

        ableToSpeak.speak();
    }
}
