package Algorithms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.signum;


/**
 * @author Danil Kubarev
 * @version 1.0<br>
 * <div style="font-size:40px">Алгоритмы</div>
 * У всех алгоритмов есть своё время выполнения.<br><br>
 * <div style="font-size:20px">Специальная нотация  O-большое описывает скорость работы алгоритма.</div><br>
 * Предположим имеется список размера n. Простой поиск должен проверить каждый элемент, поэтому ему придётся выполнить
 * n операций. Время выполнения O-большое имеет вид O(n).<br>
 * O-большое не сообщает скорость в секундах, а позволяет сравнить количество операций.
 * Оно указывает насколько быстро возрастает время выполнения алгоритма.<br>
 * O-большое определяет время выполнения в худшем случае.
 *<p>
 * <div style="font-size:20px">Типичные примеры O-большого:</div>
 * 1. O(log n) или логарифмическое время. Пример: бинарный поиск<br>
 * 2. O(n) или линейное время. Пример: простой поиск<br>
 * 3. O(n*log n) Пример: эффективные алгоритмы сортировки<br>
 * 4. O(n^2) Пример: медленные алгоритмы сортировки<br>
 * 5. O(n!) Пример: очень медленные алгоритмы(задача о коммивояжере)<br>
 *
 * <p>НА КАРТИНКЕ ОПЕЧАТКА! Для 1024 прямоугольников и O(n) 1.7 мин.
 * <div style="width: 100%; float: left"> <img src="doc-files/O-большое.png" alt=""> </div>
 *
 *
 * <h2>СТРАТЕГИЯ РАЗДЕЛЯЙ И ВЛАСТВУЙ!</h2>
 * Алгоритмы на базе этой стратегии являются рекурсивными.<br>
 * <div style="font-size:20px">Шаги стратегии:</div>
 * 1. Определить базовый случай. Это должен быть простейший случай из всех возможных.<br>
 * 2. Задача делится или сокращается до тех пор, пока не будет сведена к базовому случаю.<br>
 * <p>В этом классе методы: {@link Algorithms.Main#sum}, {@link Algorithms.Main#count_el},
 * {@link Algorithms.Main#binary_search}, {@link Algorithms.Main#quick_sort} реализованны при помощи этой стратегии.
 *
 * */
public class Main {
    /**
     * Стартовый метод, отсюда запускается программа и вызываются все остальные методы.
     * */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(sum(arrayList));
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(15);
        arrayList.add(3);

        System.out.println("Сумма элементов листа: " + sum(arrayList));
        System.out.println("Количество элементов листа: " + count_el(arrayList));
        System.out.println("Максимальное число в листе: " + max_el(arrayList));

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 500; i<10000000;i++){
            arrayList2.add(i);
        }
        int r = binary_search(arrayList2,83942,0,arrayList2.size()-1);
        System.out.println("Индекс искомого элемента: " + r);


        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(2);
        arrayList3.add(1);
        arrayList3.add(7);
        arrayList3.add(3);
        arrayList3.add(9);
        arrayList3.add(4);
        arrayList3.add(0);
        System.out.println("Лист до сортировки: " + arrayList3);
        System.out.println("Лист после сортировки: " + quick_sort(arrayList3));


    }

    /**
     * Метод, который суммирует все элементы переданного ему листа int-ов.<br>
     * Это рекурсивный метод. По стратегии разделяй и властвуй выделен базовый случай arr.isEmpty()<br>
     * И задача сокращается до тех пор, пока не будет сведена к базовому случаю
     * arr.get(0) + sum(arr.subList(1,arr.size()))
     * @param arr {@code List<Integer>} сумму элементов которого нужно получить.
     * @return Сумма элементов листа.
     * */
    public static int sum(List<Integer> arr){
        if (arr.isEmpty()) {
            return 0;
        }
        else {
            return arr.get(0) + sum(arr.subList(1,arr.size()));
        }

    }

    /**
     * Метод для подсчёта кол-ва элементов в листе.
     * Это рекурсивный метод. По стратегии разделяй и властвуй выделен базовый случай list.isEmpty()<br>
     * И задача сокращается до тех пор, пока не будет сведена к базовому случаю
     * 1 + count_el(list.subList(1,list.size()))
     * @param list List<?> количество элементов которого нужно получить.
     * @return Количеств элементов листа.
     * */
    public static int count_el(List<?> list){
        if (list.isEmpty()){
            return 0;
        }
        else{
            return 1 + count_el(list.subList(1,list.size()));
        }
    }

    /**
     * Метод для нахождения максимального числа в листе int-ов.
     * Это рекурсивный метод. По стратегии разделяй и властвуй выделен базовый случай list.isEmpty()<br>
     * И задача сокращается до тех пор, пока не будет сведена к базовому случаю
     * <pre>
     *     if (list.get(0)>max_el(list.subList(1,list.size()))){
     *          return list.get(0);
     *     }
     *     else return max_el(list.subList(1,list.size()));}
     * </pre>
     * @param list {@code List<Integer>} В котором нужно найти максимальный элемент.
     * @return Максимальный элемент листа.
     * */
    public  static int max_el(List<Integer> list){
        if (list.isEmpty()){
            return 0;
        }
        else{
            if (list.get(0)>max_el(list.subList(1,list.size()))){
                return list.get(0);
            }
            else return max_el(list.subList(1,list.size()));
        }
    }


    /**
     * Метод бинарного поиска. Скорость O(log n).<br>
     * Это самый быстрый способ найти элемент в отсортированном массиве.
     * Это рекурсивный метод. По стратегии разделяй и властвуй выделен базовый случай left_border>=right_border<br>
     *      * И задача сокращается до тех пор, пока не будет сведена к базовому случаю
     *      * <pre>
     *           mid = (right_border + left_border)/2;
     *             if(desired_element>list.get(mid)){
     *                 left_border = mid;
     *                 mid = binary_search(list,desired_element,left_border,right_border);
     *             } else if (desired_element< list.get(mid)) {
     *                 right_border = mid;
     *                 mid = binary_search(list,desired_element,left_border,right_border);
     *             }
     *      * </pre>
     *      * @param list {@code List<Integer>} В котором нужно найти максимальный элемент.
     *      * @return Максимальный элемент листа.
     * */
    public static int binary_search(List<Integer> list, int desired_element, int left_border, int right_border){
        System.out.println("Бинарный поиск в диапазоне " + left_border + " - " + right_border);
        int mid;
        if (left_border>=right_border){
            return right_border;
        }
        else{
            mid = (right_border + left_border)/2;
            if(desired_element>list.get(mid)){
                left_border = mid;
                mid = binary_search(list,desired_element,left_border,right_border);
            } else if (desired_element< list.get(mid)) {
                right_border = mid;
                mid = binary_search(list,desired_element,left_border,right_border);
            }
        }
        if ((mid>=0 && mid<list.size()) && (desired_element==list.get(mid))) return  mid;
        else return -1;
    }


    public static ArrayList<Integer>  quick_sort(ArrayList<Integer> list){
        if(list.size()==0 || list.size()==1){
            return list;
        }

        int mid_index = (int) (random()*(list.size()-1));
        int mid_el = list.get(mid_index);

        ArrayList<Integer> list_less = new ArrayList<>();
        ArrayList<Integer> list_more = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            if(i==mid_index) continue;

            if(list.get(i)<mid_el) list_less.add(list.get(i));
            else list_more.add(list.get(i));
        }
        //System.out.println(list_less + "[" + mid_el + "]" + list_more);
        list_less = quick_sort(list_less);
        list_more = quick_sort(list_more);
        list_less.add(mid_el);
        list_less.addAll(list_more);

        return list_less;

    }
}
