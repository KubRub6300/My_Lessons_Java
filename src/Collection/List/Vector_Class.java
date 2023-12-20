package Collection.List;

import java.util.Vector;

/**
 * Устаревший synchronized класс. В своей основе содержит массив элементов Object. Не рекомендуется для использования.
 * Он позволяет работать с многопоточностью, но из-за этого работает медленно.
 * */
public class Vector_Class {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Misha");
        vector.add("Danil");
        vector.add("Oleg");
        vector.add("Kolya");

        System.out.println(vector);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        vector.remove(0);
        System.out.println(vector);
        System.out.println(vector.get(1));
    }
}
