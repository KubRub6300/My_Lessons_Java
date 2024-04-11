package Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrauList - массив который может изменять свою длину
 * В основе ArrayList лежит массив Object
 * */
public class ArrayList_Class {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>(50);
        ArrayList<String> arrayList3 = new ArrayList<>(arrayList1);
        /**
         * При создании arraylist создаётся пустой массив типа Object с
         * capacity (вместимостью) -10 и size (размером) - 0, так как там ещё нет элементов
         *
         * Кода первые 10 элементов будут заполнены, то для добавления 11 (методом add) джава создаст копию массива с
         * вместимостью на 1 больше, скопирует туда все элементы старого массива и
         * на последнее место вставлен новый элемент.
         * Поэтому если заранее известно сколько элементов будет в массиве, то лучше сразу указать это
         * значение (initialCapacity) при создании листа, чтобы сэкономить время работы программы.
         *
         * Также при создании arraylist можно в круглых скобках передать в конструктор другой arraylist.
         * Тогда все элементы из переданного листа будут скопировать в новый (но это будут два не взаимосвязанных arraylist-а)
         *
         * Вообще в ArrayList можно хранить разные объекты, но благодаря Generic-ам
         * @see Base.Generics
         */
        arrayList1.add("Строка1");
        arrayList1.add("Строка2");
        arrayList1.add("Строка3");
        System.out.println(arrayList1);
        System.out.println(arrayList3);

        arrayList1.add(1,"Строка 4");
        System.out.println(arrayList1);
        System.out.println("Элеммент arrayList1 с индексом 0: " + arrayList1.get(0));

        arrayList1.set(1,"Строка вставленна вместо старой с помощью set");
        System.out.println(arrayList1);

        if(arrayList1.remove("Строка2")){
            System.out.println("Строка была удалена");
        }
        else {
            System.out.println("не удалось удалить строку");
        }

        System.out.println(arrayList1);

        System.out.println("Удалили строку: "+arrayList1.remove(0));
        System.out.println(arrayList1);
        for (int i = 0; i<10;i++){
            arrayList2.add(String.valueOf(i));
        }

        System.out.println("arraylist1: " + arrayList1);
        System.out.println("arraylist2: " + arrayList2);

        arrayList1.addAll(arrayList2);
        System.out.println("Добавили arraylist2 к arraylist1 (arrayList1.addAll(arrayList2)): " + arrayList1);
        System.out.println();

        arrayList1.addAll(1,arrayList2);
        System.out.println("Добавили arraylist2 к arraylist1 на индекс 1 (arrayList1.addAll(1,arrayList2)): " + arrayList1);
        System.out.println();

        arrayList1.removeAll(arrayList2);
        System.out.println("Удалили из arraylist1 весь arraylist2 (arrayList1.removeAll(arrayList2)): " + arrayList1);
        System.out.println();

        arrayList1.addAll(arrayList2);
        arrayList1.addAll(1,arrayList2);
        System.out.println(ANSI_CYAN + "*Вернули всё так как было до удаления" + ANSI_RESET);
        System.out.println();


        arrayList2.clear();
        System.out.println("Почистили arraylist2 с помощью (arrayList2.clear();): " + arrayList2);
        System.out.println();

        System.out.println(arrayList1);
        System.out.println("Индекс \"Строка3\" = " + arrayList1.indexOf("Строка3"));
        System.out.println("Индекс \"Строка4\" = " + arrayList1.indexOf("Строка4") + " Такой элемент не найден, поэтому -1");
        System.out.println("Индекс \"1\" = " + arrayList1.indexOf("1") + " (первая 1 в листе)");
        System.out.println("Индекс \"1\" = " + arrayList1.lastIndexOf("1") + " (последняя 1 в листе)");
        System.out.println();

        System.out.println("Размер arraylist1.size() = " + arrayList1.size());
        System.out.println("Пустой ли лист? (arraylist1.isEmpty()) -> " + arrayList1.isEmpty());
        System.out.println("Пустой ли лист? (arraylist2.isEmpty()) -> " + arrayList2.isEmpty());
        System.out.println();

        System.out.println("Содержит ли лист \"4\" (arraylist1.contains()) -> " + arrayList1.contains("4"));
        System.out.println("Содержит ли лист \"10\" (arraylist1.contains()) -> " + arrayList1.contains("10"));
        System.out.println();
        

        for (int i = 0; i<10;i++){
            arrayList2.add(String.valueOf(i));
        }
        System.out.println("arraylist2: " + arrayList2);
        arrayList1.retainAll(arrayList2);
        System.out.println("Оставили только те элементы которые есть в arraylist2 (arrayList1.retainAll(arrayList2)): " + arrayList1);
        System.out.println();

        System.out.println("Содержит ли arraylist1 все элементы arraylist2 (arrayList1.containsAll(arrayList2)) -> " + arrayList1.containsAll(arrayList2));



        //Связанные с ArrayList методы
        System.out.println(ANSI_GREEN +
                "\n\n\n\n\n=================== Связанные с ArrayList методы ===================" + ANSI_RESET);
        String [] array = {"С1","С2","С3","С4","С5","С6"}; //Создание обычного массива
        List<String> list = Arrays.asList(array);//Создаёт лист связанный с массивом
        int[] arrayInt = {1,2,3};





        System.out.println("Лист связанный с массивом: " + list);
        array[0]= "Новая строка";
        System.out.println("Поменяли первый элемент в мссиве, смотрим, что с листом: "+ list);
        list.set(1,"Изменение в листе");
        System.out.println("Поменяли второй элемент в листе, смотрим, что с массивом: "+ Arrays.toString(array));


        List<String> list1 = arrayList1.subList(3,7); //Создаёт представление arrayList1
        // (я хочу, чтобы элементы с 3 по 7 (не включая 7) arrayList1 можно было увидеть в list1)
        // При изменение с 3 по 7 элементов в arrayList1они зменятся и в list1 и наобарот, изменения в list1 происходят
        // и в arrayList1
        System.out.println();
        System.out.println("Представление (view)");
        System.out.println("arrayList1: " + arrayList1);
        System.out.println("list1 (представление arrayList1 с 3 по 7): " + list1);
        System.out.println();


        arrayList1.set(4, "w");
        System.out.println("Поменяли элемент в arraylist1 (arrayList1.set(4, \"w\"))");
        System.out.println("arrayList1: " + arrayList1);
        System.out.println("list1 (представление arrayList1 с 3 по 7): " + list1);
        System.out.println();

        list1.add("new");
        System.out.println("Добавили элемент в list1 (list1.add(\"new\"))");
        System.out.println("arrayList1: " + arrayList1);
        System.out.println("list1 (представление arrayList1 с 3 по 7): " + list1);
        System.out.println(ANSI_RED + "Если добавить элемент в arrayList1 за пределами view, то нельзя будет больше " +
                "взаимодействовать с view, будет выдавать ошибку" + ANSI_RESET);

        Object[] array1 = arrayList1.toArray(); // Создаёт массив объектов из arrayList-a
        String[] array2 = arrayList1.toArray(new String[0]); // Создаёт массив Строк из arrayList-a (Джава сама определит размер массива, поэтому можно указать 0)

        List<Integer> list3 = List.of(3,4,5,6,7); // Создаёт лист, но его нельзя изменять!
        List<String> list4 = List.copyOf(arrayList1); // Создаёт лист, но его нельзя изменять!





    }
}
