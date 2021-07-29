package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Plivo {

    public static void main(String[] args) throws Exception{

        Random random = new Random();
        random.nextLong();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);

        System.out.println(Collections.binarySearch(list, 2));
    }
}
