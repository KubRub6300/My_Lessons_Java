package Collection.Queue;


import Collection.Map.Student;

import java.util.PriorityQueue;

/**
 * PriorityQueue - это специальный вид очереди, в котором используется натуральная сортировка или та,
 * которую мы описываем с помощью Comparable или Comparator. Таким образом используется тот элемент из очереди,
 * приоритет которого выше.
 *
 * Так как под капотом лежит Куча (Binary Tree), то просто при обходе данных не гарантируется правильный порядок их вывода,
 * только при извлечении элемента.
 * */
public class PriorityQueue_Class {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(0);
        priorityQueue.add(4);
        priorityQueue.add(8);
        priorityQueue.add(5);

        System.out.println(priorityQueue); //Выведет не правильный порядок, но через poll всегда будет возвращать
        // верный элемент
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());



        Collection.Queue.Student s1 = new Collection.Queue.Student("Ivan", "Petrov",3);
        Collection.Queue.Student s2 = new Collection.Queue.Student("Zaur", "Suretov",1);
        Collection.Queue.Student s3 = new Collection.Queue.Student("Oleg", "Kirov",4);
        Collection.Queue.Student s4 = new Collection.Queue.Student("Nikita", "Ladunov",2);
        Collection.Queue.Student s5 = new Collection.Queue.Student("Egor", "Dyrov",2);
        Collection.Queue.Student s6 = new Collection.Queue.Student("Nikolai", "Butov",2);
        Collection.Queue.Student s7 = new Collection.Queue.Student("Danil", "Zotov",2);

        PriorityQueue<Collection.Queue.Student> priorityQueueStudents = new PriorityQueue<>();
        priorityQueueStudents.add(s1);
        priorityQueueStudents.add(s2);
        priorityQueueStudents.add(s3);
        priorityQueueStudents.add(s4);
        priorityQueueStudents.add(s5);
        priorityQueueStudents.add(s6);
        priorityQueueStudents.add(s7);

        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
        System.out.println(priorityQueueStudents.poll());
    }


}
