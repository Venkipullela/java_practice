package multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass = new SharedClass();

        Thread p = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 22; i++) {
                    sharedClass.produce(false);
                }
                sharedClass.produce(true);
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 22; i++) {
                    sharedClass.consume(false);
                }
                sharedClass.consume(true);
            }
        });

        p.setName("Producer");
        c.setName("Consumer");
        //p.setDaemon(true);
        //c.setDaemon(true);


        c.start();
        p.start();




//        Thread.sleep(10);
//        p.interrupt();
//        c.interrupt();
    }

    static class SharedClass {
        Queue<Integer> queue = new ArrayDeque<>();
        Random random = new Random();
        int i = 0;

        public synchronized void produce(Boolean isCompleted) {
            try {
                if(isCompleted) {
                    notify();
                } else if(queue.size() == 10) {
                    notify();
                    System.out.println("producer going into wait");
                    wait();
                    System.out.println("producer recovered from wait");
                } else {
                    System.out.println("producing");
                    queue.add(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                System.out.println("p is interrupted");
                //e.printStackTrace();

            }
        }

        public synchronized void consume(Boolean isCompleted) {
            try {
                if(isCompleted) {
                    notify();
                } else if(queue.isEmpty()){
                    notify();
                    System.out.println("consumer going into wait");
                    wait();
                    System.out.println("consumer recovered from wait");
                } else {
                    System.out.println("consuming");
                    queue.poll();
                }
            } catch (InterruptedException e) {
                System.out.println("q is interrupted");
                //e.printStackTrace();
            }
        }
    }
}
