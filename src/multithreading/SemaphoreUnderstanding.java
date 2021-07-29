package multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreUnderstanding {
    public static void main(String[] args){
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(10);
        Queue<String> queue = new ArrayDeque<>(10);
        ReentrantLock lock = new ReentrantLock();
        Random random = new Random();
        String s = new String();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s2.acquire();
                        lock.lock();
                        queue.offer(produce());
                        lock.unlock();
                        s1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            public String produce() {
                return String.valueOf(random.nextInt());
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s1.acquire();
                        lock.lock();
                        String s = queue.poll();
                        lock.unlock();
                        consume(s);
                        s2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            public void consume(String s) {
                System.out.println(s);
            }
        };
        Thread producer1 = new Thread(runnable);
        Thread producer2 = new Thread(runnable);
        Thread producer3 = new Thread(runnable);
        Thread producer4 = new Thread(runnable);

        Thread consumer1 = new Thread(runnable1);
        Thread consumer2 = new Thread(runnable1);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        consumer1.start();
        consumer2.start();
    }
}
