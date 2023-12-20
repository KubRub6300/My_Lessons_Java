package Collection.Map;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap - не запоминает порядок добавления элементов. Его методы работают очень быстро.
 * Так же как и все map хранит ключ - значение.
 * В основе HashMap лежит массив. Элементами данного массива являются структуры LinkedList.
 * Данные структуры заполняются Node-ами, каждый Node содержит HashCode ключа, ключ, значение, ссылку на следующий Node.
 * При добавлении элемента в map (map.put()) вычисляется hashCode ключа и уже после этого по hashCode-у вычисляется
 * индекс в массиве куда будет помещён Node. Если key = null, то индекс = 0.
 * Балагдаря тому, что создаётся не один LinkedList, а массив LinkedList-ов сильно сокращается время поиска элемента.
 *
 * При создании Hashmap можно задать 2 параметра, которые очень влияют на производительность:
 * - Initial Capacity - начальный размер массива;
 * - Load factor - коэффициент того, насколько массив должен быть заполнен, после чего размер должен быть увеличен вдвое.
 * Стандартные значения 16 и 0.75f
 * Когда массив будет увеличен в двоё, тогда все Node-ы будут заново распределены по ячейкам массива.
 *
 * При хорошо организованном хранении Node-ов в массиве (зависит от того, как хорошо генерируется HashCode и размера
 * массива), время на поиск, добавление/удаление элемента потребуется всего O(1) времени. Но в худшем случае O(n)
 *
 * !!! Объект на месте ключа должен быть не изменяемый! Так как если изменить какое-то поле объекта,
 * то у него изменится hasCode и этот объект нельзя больше будет найти в HashMap-е.
 * <p>
 * Ключи элементов должны быть уникальными (могут быть null).
 * Значения могут повторяться (могут быть null).
 * <p>
 *
 * <strong> ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО! ВАЖНО!</strong>
 * Для сравнения двух ключей в hashmap используется hashCode объектов и equals. (Сначала сравнивается hashCode объектов,
 * потом уже они сравниваются по equals).
 * Поэтому при создании своего класса важно переопределять метод equals и hashcode, даже если не планируешь его использовать.
 * В классе Student переопределён hashCode и equals.
 * @see Student#hashCode()
 * @see Student#equals(Object)
 * */
public class HashMap_Class {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();

        map1.put(1000, "Danil Sidorov");
        map1.put(12433, "Oleg Shumov");
        map1.put(982, "Ivan Zukov");
        map1.put(2332, "Kirill RiadomTolian");
        map1.put(null, "Dima Serov");
        map1.put(82320, null);
        System.out.println(map1);

        map1.put(982,"Sergei Smirnov");

        System.out.println("Сделали put с уже существующим ключом 982. Значение элемента просто перезаписалось.");
        System.out.println(map1);

        map1.putIfAbsent(1000,"Try Put"); //Добавить элемент если нет элемента с таким ключом.
        System.out.println(map1);

        System.out.println();
        System.out.println("map1.get(1000): " + map1.get(1000));
        System.out.println("map1.get(000): " + map1.get(0));
        System.out.println();

        map1.remove(1000);
        System.out.println("Сделали map1.remove(1000): " + map1);
        System.out.println();

        System.out.println("map1.containsValue(\"Oleg Shumov\"): " + map1.containsValue("Oleg Shumov"));
        System.out.println("map1.containsKey(82320): " + map1.containsKey(82320));
        System.out.println();

        System.out.println("Все ключи (map1.keySet()): " + map1.keySet());
        System.out.println("Все значения (map1.values()): " + map1.values());


        Map<Student, Double> students_map = new HashMap<>();
        Student s1 = new Student("Ivan", "Petrov",3);
        Student s2 = new Student("Zaur", "Suretov",1);
        Student s3 = new Student("Oleg", "Kirov",4);
        Student s4 = new Student("Nikita", "Ladunov",2);
        Student s5 = new Student("Nikita", "Ladunov",2);
        students_map.put(s1,82.3);
        students_map.put(s2,50.45);
        students_map.put(s3,99.9);
        students_map.put(s4,14.5);
        System.out.println();
        System.out.println("HashMap Students: " + students_map);
        System.out.println(students_map.containsKey(s5));


        /**
         * entrySet() - возвращает множество Entry
         * Entry - интерфейс внутренний для map, который имплементируется Node-ом
         * */
        for(Map.Entry<Student, Double> entry: students_map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}


