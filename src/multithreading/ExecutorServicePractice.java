package multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicePractice {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable produce = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 22; i++) {
                    sharedClass.produce(false);
                }
                sharedClass.produce(true);
            }
        };

        Runnable consume = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 22; i++) {
                    sharedClass.consume(false);
                }
                sharedClass.consume(true);
            }
        };
        executorService.execute(produce);
        executorService.execute(consume);
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
                    wait();
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
                    wait();
                    System.out.println("wait finished now");
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
