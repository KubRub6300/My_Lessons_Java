package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Поиск нужного элемента в ОТСОРТИРОВАННОМ листе при помощи постепенного деления пополам и определения в какой части
 * (левой или правой) нужный элемент
 * */
public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            arrayList.add( (int) (Math.random()*100));
        }
        Collections.sort(arrayList);//ОБЯЗАТЕЛЬНО ОТСОРТИРОВАТЬ ЛИСТ
        int index1 = Collections.binarySearch(arrayList,5); //Если число не найдено, то индекс будет меньше 0!
        System.out.println(arrayList);
        System.out.println(index1);
    }
}
