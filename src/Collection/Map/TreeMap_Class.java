package Collection.Map;


import java.util.TreeMap;

/**
 * TreeMap.
 * Элементами TreeMap являются пары ключ/значение.
 * В TreeMap элементы хранятся в отсортированном по возрастанию порядке.
 * <p>
 * В основе TreeMap лежит красно-чёрное дерево. Это позволяет методам работать быстро, но не быстрее, чем методы HashMap.
 * Так же как и в HashMap все ключи должны быть уникальными, в отличие от значений.
 * <p>
 * Класс стоящий в качестве ключа должен реализовывать интерфейс Comparable.
 * Для сравнения ключей в TreeMap - используется метода CompareTo класса ключа.
 *
 * Если метод equals у класса возвращает true, то compareTo должен возвращать 0!
 * <p>
 * Дерево - самобалансирующиеся, это значит, что он не просто добавляет все элементы по порядку в одну ветвь,
 * а распределяет их так, чтобы время на поиск было оптимальным (как в бинарном поиске).
 * Время занимаемое get/set - O(log n)
 * Это медленнее чем у HashMap, где лучшее время сводится к O(1)
 * */
public class TreeMap_Class {
    public static void main(String[] args) {

        TreeMap<Double, Student> treeMap = new TreeMap<>();

        Student s1 = new Student("Ivan", "Petrov",3);
        Student s2 = new Student("Zaur", "Suretov",1);
        Student s3 = new Student("Oleg", "Kirov",4);
        Student s4 = new Student("Nikita", "Ladunov",2);
        Student s5 = new Student("Egor", "Dyrov",2);
        Student s6 = new Student("Nikolai", "Butov",2);
        Student s7 = new Student("Danil", "Zotov",2);

        treeMap.put(5.8,s1);
        treeMap.put(4.8,s2);
        treeMap.put(3.2,s3);
        treeMap.put(9.3,s4);
        treeMap.put(7.2,s5);
        treeMap.put(1.6,s6);
        treeMap.put(5.3,s7);

        System.out.println(treeMap);
        System.out.println("Key 4.8: " + treeMap.get(4.8));
        System.out.println("Key 2.8: " + treeMap.get(2.8));
        treeMap.remove(3.2);
        System.out.println("Удалили элемент с ключом 3.2");
        System.out.println(treeMap);
        System.out.println();

        System.out.println(treeMap.descendingMap());//Выводим TreeMap задом наперёд (с самого большого ключа, до самого маленького)
        System.out.println();

        System.out.println(treeMap.tailMap(4.5));//Выводим всех студентов с ключом больше 4.5
        System.out.println(treeMap.headMap(6.8));//Выводим всех студентов с ключом меньше 6.8
        System.out.println();

        System.out.println(treeMap.lastEntry());//Выводим последний элемент
        System.out.println(treeMap.firstEntry());//Выводим первый элемент


        System.out.println("\n\n\n\n===========================TreeMap2===========================");
        TreeMap<Student,Double> treeMap2 = new TreeMap<>();
        treeMap2.put(s1,5.8);
        treeMap2.put(s2,4.8);
        treeMap2.put(s3,3.2);
        treeMap2.put(s4,9.3);
        treeMap2.put(s5,7.2);
        treeMap2.put(s6,1.6);
        treeMap2.put(s7,5.3);

        System.out.println(treeMap2);
    }
}



