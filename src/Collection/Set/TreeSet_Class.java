package Collection.Set;

import java.util.TreeSet;

/**
 * TreeSet хранит значения в отсортированном порядке.
 * В основе TreeSet лежит TreeMap. У элементов данного TreeMap: ключи - все элементы, значения - константа заглушка.
 * Не хранит null
 *
 * @see Collection.Map.TreeMap_Class
 * */
public class TreeSet_Class {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(4);
        treeSet.add(3);


        System.out.println(treeSet);
    }
}
