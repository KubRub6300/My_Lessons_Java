package Collection.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * */
public class ArrayDeque_Class {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);//Добавляет в начало
        deque.addFirst(2);//Добавляет в начало
        deque.addLast(3);//Добавит в конец
        deque.offerFirst(4);//Добавит в начало, но не выбросит ошибку в случае чего
        deque.offerLast(5);//Добавит в конец, но не выбросит ошибку в случае чего
        System.out.println(deque);
        System.out.println();
        System.out.println(deque.removeFirst());    //Удалит первый элемент и выдаст ошибку в случае неудачи
        System.out.println(deque.removeLast());     //Удалит последний элемент и выдаст ошибку в случае неудачи
        System.out.println(deque.pollFirst());      //Удалит первый элемент и НЕ выдаст ошибку в случае неудачи
        System.out.println(deque.pollLast());       //Удалит последний элемент и НЕ выдаст ошибку в случае неудачи
        System.out.println(deque);
        deque.offerLast(6);
        deque.offerLast(7);
        deque.offerLast(8);
        System.out.println(deque);
        System.out.println();


        System.out.println(deque.getFirst());       //Вернёт первый элемент и выдаст ошибку в случае неудачи
        System.out.println(deque.getLast());        //Вернёт последний элемент и выдаст ошибку в случае неудачи
        System.out.println(deque.peekFirst());      //Вернёт первый элемент и НЕ выдаст ошибку в случае неудачи
        System.out.println(deque.peekLast());       //Вернёт последний элемент и НЕ выдаст ошибку в случае неудачи



    }

}
