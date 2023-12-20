package MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        Thread thread = new Thread(new MyThread2());
        myThread.start();
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i=1;i<10;i++){
                System.out.println(-1);
                try {
                    Thread.sleep(1000);//Сон 1 секунда
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        myThread.join();//Поток main ждёт пока закончится поток MyThread и не идёт дальше
        thread.join(4000);//Поток main ждёт пока закончится поток thread или пройдёт 4 секунды и не идёт дальше

        System.out.println(thread2.getName() + ": " + thread2.getState());

        thread2.start();
        System.out.println(thread2.getName() + ": " + thread2.getState());

        thread2.join();
        System.out.println(thread2.getName() + ": " + thread2.getState());


        System.out.println(myThread.getName());
        System.out.println(thread.getName());
        System.out.println(myThread.getPriority());
        System.out.println(thread.getPriority());



    }
}

class MyThread extends Thread{
    public void run(){
        for (int i =1;i<=100;i++){
            System.out.println(i);
        }
    }
}
class MyThread2 implements Runnable{
    public void run(){
        for (int i =100;i>0;i--){
            System.out.println(i);
        }
    }
}
