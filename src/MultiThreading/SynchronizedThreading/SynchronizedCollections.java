package MultiThreading.SynchronizedThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Оборачивает стандартные коллекции благодаря чему они могут работать в многопоточном режиме.
 * Если коллекция используется в одном потоке, то остальные будут ждать пока он освободится.
 * */
public class SynchronizedCollections {


    public static void ex1() throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0 ; i<5;i++){
            source.add(i);
        }

        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>()); //Синхронизирует лист, теперь только
        // один поток может одновременно работать с листом

        Runnable runnable = () ->{synchList.addAll(source);};

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }

    public static void ex2() throws InterruptedException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ; i<1000;i++){
            arrayList.add(i);
        }

        List<Integer> synchList = Collections.synchronizedList(arrayList);


        Runnable runnable1 = () ->{
            Iterator<Integer> iterator = synchList.iterator();

            synchronized (synchList){//Блокирует работу с synchList пока выполняется код в теле этого блока.
                // С итераторами так нужно делать всегда иначе будет выкидывать ConcurrentModificationException
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }

        };



        Runnable runnable2 = () ->{
            synchList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }


    public static void main(String[] args) throws InterruptedException {

        // Пример 1
        //ex1();
        // Пример 2
        ex2();
    }
}
