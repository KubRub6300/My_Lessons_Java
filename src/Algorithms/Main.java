package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(15);
        arrayList.add(3);

        System.out.println(sum(arrayList));
        System.out.println(count_el(arrayList));
        System.out.println(max_el(arrayList));

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 500; i<10000000;i++){
            arrayList2.add(i);
        }
        int r = binary_search(arrayList2,2,0,arrayList2.size()-1);
        System.out.println(r);


    }

    public static int sum(List<Integer> arr){
        if (arr.size()==1) {
            return arr.get(0);
        }
        else {
            return arr.get(0) + sum(arr.subList(1,arr.size()));
        }

    }

    public static int count_el(List<Integer> list){
        if (list.size()==1){
            return 1;
        }
        else{
            return 1 + count_el(list.subList(1,list.size()));
        }
    }

    public  static int max_el(List<Integer> list){
        if (list.size()==1){
            return list.get(0);
        }
        else{
            if (list.get(0)>max_el(list.subList(1,list.size()))){
                return list.get(0);
            }
            else return max_el(list.subList(1,list.size()));
        }
    }

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
}
