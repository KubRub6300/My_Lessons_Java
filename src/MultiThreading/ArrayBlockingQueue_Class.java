package MultiThreading;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * Потокобезопасная очередь с ограниченным размером (capacity restricted).
 *
 * Новые методы!
 * put() - добавит элемент в очередь если есть место, иначе остановит поток и будет ждать освобождения места
 * take() - возьмёт элемент из очереди если он там есть, иначе остановит поток и будет ждать элемент в очереди
 * */
public class ArrayBlockingQueue_Class {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        //queue.add(5); - так выбросится ошибка, так как в очереди больше нет места
        queue.offer(5); //Так ошибки не будет, элемент просто не добавится

        System.out.println(queue);

        queue.clear();

        Thread thread1 = new  Thread(() -> {

            int i=0;
            while (true){

                try {
                    queue.put(++i);
                    System.out.println("Добавили в очередь " + i + " " + queue);
                    //Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new  Thread(() -> {

            int i=0;
            while (true){
                try {
                    int t = queue.take();
                    System.out.println("Взяли из очереди " + t + " " + queue);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        thread1.start();
        thread2.start();
    }
}
