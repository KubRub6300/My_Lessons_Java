package Collection.Cursors;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_Class {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Саша");
        arrayList1.add("Паша");
        arrayList1.add("Коля");
        arrayList1.add("Толя");

        Iterator<String> iterator = arrayList1.iterator();

        while (iterator.hasNext()){ //Выводит элементы листа
            System.out.println(iterator.next());
        }

        iterator = arrayList1.iterator();

        while (iterator.hasNext()){ //Удалит Пашу из листа
            String name = iterator.next();
            if (name == "Паша"){
                iterator.remove();
            }

        }
        System.out.println(arrayList1);

        iterator = arrayList1.iterator();

        while (iterator.hasNext()){ // Удалит все элементы из листа
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayList1);
    }


}
