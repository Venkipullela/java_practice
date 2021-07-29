package multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ThreadPractice {

    static Queue<Integer> queue = new ArrayDeque<>();
    static int max = 10;

    public static void main(String[] args) throws Exception{
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    sharedResource.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    sharedResource.checkDataRace();
                }
            }
        });
        long t1 = System.nanoTime();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(sharedResource.count);
        long t2 = System.nanoTime();

        System.out.println("time difference " + (t2-t1));
    }

    static class SharedResource {
        int x = 0;
        int y = 0;
        int count = 0;

        public synchronized void increment(){
            x++;
            y++;
        }

        public synchronized void checkDataRace() {
            if(y > x){
                count++;
            }
        }
    }
}
