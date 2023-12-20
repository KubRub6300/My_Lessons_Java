package MultiThreading;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * CopyOnWriteArrayList имплементирует интерфейс лист.
 * Следует использовать тогда, когда нужно добиться пожаробезопасности,
 * есть небольшое количество операций по изменению элементов и большое количество по их чтению.
 *
 * Так как для того, чтобы добиться безопасности в потоках при каждом изменении в list создаётся его копия.
 * */
public class CopyOnWriteArrayList_Class {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Danil");
        list.add("Kirill");
        list.add("Oleg");
        list.add("Petr");
        list.add("Evpati");


        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(3);
            list.add("Nikolay");
        };

        System.out.println(list);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list);


    }
}
