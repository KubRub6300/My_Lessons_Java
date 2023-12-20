package Collection.Map;


import java.util.LinkedHashMap;

/**
 * LinkedHashMap - является наследником HashMap. Хранит информацию о порядке добавления элементов или порядке их использования.
 * Производительность методов немного ниже, чем у методов HashMap.
 *
 * При создании объекта класса можно в конструктор передать capacity, loadFactor, а также accessOrder: если он true,
 * то в конце LinkedHashMap будут храниться элементы, которые были недавно использованные (для них вызывались какие-то
 * методы, по типу put, get и т.д.)
 * А если false, то хранятся в порядке добавления (последний добавленный в конце)
 * */
public class LinkedHashMap_Class {
    public static void main(String[] args) {
        LinkedHashMap<Double,Student> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);

        Student s1 = new Student("Ivan", "Petrov",3);
        Student s2 = new Student("Zaur", "Suretov",1);
        Student s3 = new Student("Oleg", "Kirov",4);
        Student s4 = new Student("Nikita", "Ladunov",2);

        linkedHashMap.put(3.5,s1);
        linkedHashMap.put(5.3,s2);
        linkedHashMap.put(9.2,s3);
        linkedHashMap.put(4.1,s4);
        System.out.println(linkedHashMap);
    }
}
