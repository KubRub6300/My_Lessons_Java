package Collection.Map;


import java.util.Hashtable;

/**
 * HashTable - устаревший класс, который работает по тем же принципам, что и HashMap.
 * В отличие от HashMap является synchronized. По этой причине его методы далеко не такие быстрые.
 * Ни ключ, ни значение не могут быть null.
 * Если нужна поддержка много поточности лучше использовать ConcurrentHashMap
 * */
public class HashTable_Class {
    public static void main(String[] args) {

        Hashtable<Double, Student> hashTable = new Hashtable<>();
        Student s1 = new Student("Ivan", "Petrov",3);
        Student s2 = new Student("Zaur", "Suretov",1);
        Student s3 = new Student("Oleg", "Kirov",4);
        Student s4 = new Student("Nikita", "Ladunov",2);

        hashTable.put(3.5,s1);
        hashTable.put(5.3,s2);
        hashTable.put(9.2,s3);
        hashTable.put(4.1,s4);
    }
}
