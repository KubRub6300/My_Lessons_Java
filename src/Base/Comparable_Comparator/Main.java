package Base.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        Student st1 = new Student(1,"Danil","Surovi",2);
        Student st2 = new Student(25,"Pasha","Trafimov",3);
        Student st3 = new Student(4,"Oleg","Kuzov",4);

        list.add(st1);
        list.add(st2);
        list.add(st3);

        System.out.println(list);

        System.out.println();
        Collections.sort(list);
        System.out.println(list);

        System.out.println();
        Collections.sort(list, (firstSt, secondSt) -> firstSt.course - secondSt.course);
        System.out.println(list);

        System.out.println();
        Collections.sort(list, new CompareName());
        System.out.println(list);

    }


}
