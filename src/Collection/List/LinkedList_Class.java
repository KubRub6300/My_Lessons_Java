package Collection.List;

import java.util.LinkedList;

/**Линкед Лист
 * LinkedList - дву связный список, каждый элемент которого содержит ссылку на предыдущий и последующий элемент.
 * <p>
 * Если это первый элемент (голова/head), то у него ссылка на предыдущий элемент указывает на null,
 * а если это последний (хвост/tail), то ссылка на последующий элемент указывает на null.
 * В отличие от ArrayList-а дольше происходит поиск элемента, так как, что бы найти его в двух связном списке нужно
 * пройти по всем предыдущим элементам.
 * <p>
 * Но при этом добавление и удаление элемента происходит быстрее, так как, чтобы добавить или удалить элемент нужно
 * просто отредактировать ссылки у элементов перед и после, а в arrayList-е, нужно сдвигать все элементы после
 * добавляемого/удаляемого
 *
 * LinkedList имплементирует не только интерфейс List, но и интерфейс Deque(а он в свою очередь интерфейс Queue)
 *
 * @see Collection.List.ArrayList_Class
 * @see Collection.Queue.LinkedList_Class
 * */
public class LinkedList_Class {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Иван");
        linkedList.add("Николай");
        linkedList.add("Дарья");
        linkedList.add("Анастасия");
        linkedList.add("Пётр");

        System.out.println(linkedList);
    }
}
