package Collection.Set;


import java.util.LinkedHashSet;

/**
 * Наследник HashSet. Хранит информацию о порядке добавления элементов. Производительность методов немного ниже чем у
 * методов HashSet.
 * В основе лежит HashMap. У элементов данного HashMap: ключи - это элементы LinkedHashSet, значения константа заглушка.
 *
 * @see Collection.Set.HashSet_Class
 * */
public class LinkedHashSet_Class {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(16,0.75f);
        linkedHashSet.add("Danil");
        linkedHashSet.add("Oleg");
        linkedHashSet.add("Danil");
        linkedHashSet.add("Kirill");
        System.out.println(linkedHashSet.toArray()[0]);

    }
}
