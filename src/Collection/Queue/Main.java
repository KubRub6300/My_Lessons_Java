package Collection.Queue;


/**
 * Queue(очередь) - это коллекция, хранящая последовательность элементов. Добавляется элемент в конец очереди,
 * используется из начала очереди – правило FIFO.
 *
 * Deque - double ended queue (двунаправленная очередь). В такой очереди элементы могут использоваться с обоих концов.
 * Здесь работают оба правила - FIFO и LIFO.
 * <p>
 * (I) -interface
 * (C) - class
 *                                             Queue(I)
 *                              |                                |
 *                           Deque(I)                      AbstractQueue(I)
 *                       |            |                          |
 *                 LinkedList(C)   ArrayDeque(C)           PriorityQueue(C)
 *
 *
 *
 * */
public class Main {
}
