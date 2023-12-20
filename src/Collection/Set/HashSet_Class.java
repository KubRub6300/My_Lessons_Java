package Collection.Set;


import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.Set;

/**
 * В основе HashSet лежит HashMap. У элементов этого HashMap: ключи - элементы HashSet, значение - константа(заглушка).
 * HashSet не запоминает порядок добавления элементов.
 * Может содержать null.
 * Если хранить объекты своего класса, то обязательно нужно переопределить методы equals и hashCode в своём классе.
 *
 * @see Collection.Map.HashMap_Class
 * */
public class HashSet_Class {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Danil"); //Тут внутри вызывается метод put HashSet-а
        set.add("Oleg");
        set.add("Nikita");
        set.add("Nikita");//Второй Никита не добавится, так как такой уже есть
        set.add(null);
        System.out.println(set);
        set.remove(null);
        System.out.println();


        for(String s: set){
            System.out.println(s);
        }
        System.out.println();

        System.out.println("количество элементов в set-е: " + set.size());
        System.out.println("Set пустой: " + set.isEmpty());
        System.out.println();

        System.out.println("Содержит ли сет 'Oleg': " + set.contains("Oleg"));


        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(2);
        hashSet1.add(4);
        hashSet1.add(6);
        hashSet1.add(1);
        hashSet1.add(3);


        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(8);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(0);


        System.out.println("HashSet1: " + hashSet1);
        System.out.println("HashSet2: " + hashSet2);

        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println("Объединили два hashSet-а: " + union);

        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);
        System.out.println("Пересечение: " + intersect);

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);
        System.out.println("Исключение(Разность): " + subtract);

    }
}
