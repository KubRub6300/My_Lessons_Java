package Base.Nested_classes;

public class Main {
    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar(1);
        electrocar.start();

        Electrocar.Battery battery = new Electrocar.Battery();
        battery.charge();
    }
}
