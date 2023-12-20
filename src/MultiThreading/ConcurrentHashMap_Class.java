package MultiThreading;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


/**
 * ConcurrentHashMap - работает как hasMap только позволяет работать с разными потоками. Достигается это тем, что если
 * какой-то поток занял backed (элемент hashmap), то блокируется этот backed, а не весь hashmap.
 * В отличие от обычного HashMap нельзя добавлять null ни в ключ, ни в значение!
 * @see Collection.Map.HashMap_Class
 * */
public class ConcurrentHashMap_Class {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1,"Danil");
        hashMap.put(2,"Kirill");
        hashMap.put(3,"Oleg");
        hashMap.put(4,"Petr");
        hashMap.put(5,"Evpati");

        Thread thread1 = new Thread(() -> {
            Iterator<Integer> iterator = hashMap.keySet().iterator();

            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + ": " + hashMap.get(i));
            }
        });

        Thread thread2 = new Thread(() -> hashMap.put(6,"Vlad"));

        System.out.println(hashMap);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(hashMap);
    }
}
