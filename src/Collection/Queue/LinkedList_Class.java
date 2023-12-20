package Collection.Queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * LinkedList имплементирует не только интерфейс List, но и интерфейс Deque(а он в свою очередь интерфейс Queue)
 * @see Collection.List.LinkedList_Class
 *
 * В этом файле рассматриваются возможности интерфейса Queue, просто на примере класса LinkedList
 * */
public class LinkedList_Class {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Danil");// Добавляет элемент в конец очереди, если очередь ограничена и заполнена, то выбросит exception
        queue.offer("Oleg");// Добавляет элемент в конец очереди, если очередь ограничена и заполнена, то не сможет
        // добавить элемент, но exception не выбросит
        queue.add("Ivan");
        queue.add("Kolia");

        System.out.println(queue);

        System.out.println(queue.remove());//Удалит первый элемент и выведет его на экран, если очередь пуста выбросит exception
        System.out.println(queue.poll());//Удалит первый элемент и выведет его на экран, если очередь пуста вернёт null
        System.out.println();
        System.out.println("На первом месте в очереди: " + queue.element());// Вернёт первый элемент, если элементов нет выбросит exception
        System.out.println("На первом месте в очереди: " + queue.peek());// Вернёт первый элемент, если элементов нет вернёт null
        System.out.println(queue);

        queue.add("Ivan");//Можно добавлять одинаковые элементы
        queue.add("Maxim");
        System.out.println(queue);
        System.out.println(queue.remove("Kolia"));//Можно удалять также элементы из середины очереди,
        // но не стоит так часто делать, так как смысл очереди теряется


    }
}
