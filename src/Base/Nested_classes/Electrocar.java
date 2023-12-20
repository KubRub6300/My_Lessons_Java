package Base.Nested_classes;

public class Electrocar{

    // Вложенный не статичный класс (имеет доступ к переменным класса и обычно приватный)
    private class Motor{
        public void startMotor(){
            System.out.println("Motor "+ id + " is starting...");
        }
    }

    // Статический вложенный класс, имеет доступ только к статичным полям класса, обычно создаётся публичным
    // для использования из вне
    public static class Battery{
        public void charge(){
            System.out.println("Battery is charging...");
        }
    }

    int id;
    Motor motor;

    public Electrocar(int id){
        this.id = id;
        motor = new Motor();
    }

    public void start(){
        motor.startMotor();
        System.out.println("Electrocar "+ id +" is starting...");

        final int x = 5; // константа

        class SomeClass{ // вложенный в метод класс, может получать доступ к переменным класса и к константным переменным метода
            public void someMethod(){
                System.out.println("x: " + x);
                System.out.println("id: " + id);
            }
        }

        SomeClass someClass = new SomeClass();
        someClass.someMethod();
    }
}
