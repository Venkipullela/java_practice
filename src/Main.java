import java.util.*;

public class Main {
    public static void Comparision(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> integerList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            integerList.add(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("timeElapsed: " + (t2-t1));

        for(int i = 0; i < 100000; i++){
            minHeap.add(i);
        }
        long t3 = System.currentTimeMillis();
        System.out.println("timeElapsed: " + (t3-t2));

        for(int i = 0; i < 100000; i++){
            list.add(i);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("timeElapsed: " + (t4-t3));



    }

    public static void main(String[] args){
        int[] a = new int[] {1,2,0,2,0,0,2,1,0,1};
        sortColors(a);
    }

    public static void sortColors(int[] nums) {
        int r=0,w=0,b = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                r++;
            }
            if(nums[i]==1){
                w++;
            }
            if(nums[i]==2){
                b++;
            }
        }
        int i = 0, j = nums.length-1;
        while(i<=j) {
            if(nums[i]==2) {
                if(nums[j]==0){
                    nums[i] = 0;
                    nums[j] = 2;
                    i++; j--;
                } else if (nums[j]==1){
                    nums[i] = 1;
                    nums[j] = 2;
                    if(i >= r){
                        i++; j--;
                    } else {
                        j--;
                    }
                } else {
                    j--;
                }
            } else if(nums[i]==1){
                if(nums[j]==2){
                    j--;
                } else if(nums[j]==1){
                    if(i >= r){
                        i++;
                    } else {
                        for(int k = i+1; k < j; k++){
                            if(nums[k] == 0) {
                                nums[i] = 0;
                                nums[k] = 1;
                                i++;
                                break;
                            }
                        }
                    }
                } else {
                    nums[i] = 0;
                    nums[j] = 1;
                    i++;
                }
            } else {
                i++;
            }
        }
    }



    public static long maximumProfit(List<Integer> inventory, long order) {
        inventory.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        long maximumProfit = 0;
        int whileCounter = 0;
        while(order != 0) {
            whileCounter++;
            if(whileCounter > inventory.size()) {
                System.out.println("terminating due to infinite loop");
            }
            int numberOfMaximums = 1;
            int difference = 0;
            for(int i = 1; i < inventory.size(); i++){
                if(inventory.get(i).equals(inventory.get(i-1))) {
                    numberOfMaximums++;
                } else {
                    difference = inventory.get(i-1)-inventory.get(i);
                    break;
                }
            }

            if(numberOfMaximums == inventory.size()) {
                difference = inventory.get(0);
            }

            if(order < numberOfMaximums * difference) {
                for(int j = 0; j < order/numberOfMaximums; j++){
                    maximumProfit += numberOfMaximums * (inventory.get(0) - j);
                }
                for(int k = 0; k < numberOfMaximums; k++){
                    inventory.set(k, inventory.get(k)-((int)(order/numberOfMaximums)));
                }
                maximumProfit += order%numberOfMaximums*inventory.get(0);
                order = 0;
            } else {
                for(int j = 0; j < difference; j++){
                    maximumProfit += numberOfMaximums * (inventory.get(0) - j);
                }
                for(int k = 0; k < numberOfMaximums; k++){
                    inventory.set(k, inventory.get(k)-difference);
                }
                order -= numberOfMaximums*difference;
            }
        }
        return maximumProfit;
    }

    public static long maximumProfitWithMaxHeap(List<Integer> inventory, long order) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer i: inventory) {
            maxHeap.add(i);
        }

        long maximumProfit = 0;
        long currentMax = maxHeap.peek().longValue();
        long nextMax = 0;

        while(order != 0){
            maxHeap.poll();
            nextMax = maxHeap.peek().longValue();
            if (currentMax != nextMax && order >= (currentMax - nextMax)) {
                maximumProfit += (currentMax - nextMax)*(currentMax+nextMax+1)/2;
                maxHeap.add((int) nextMax);
                order -= currentMax-nextMax;
                currentMax = nextMax;
            } else {
                maximumProfit += currentMax;
                maxHeap.add((int)currentMax-1);
                if(currentMax != nextMax) {
                    currentMax = currentMax-1;
                }
                order--;
            }
        }
        return maximumProfit;
    }

    public static long maximumProfitWithoutMaxHeap(List<Integer> inventory, long order) {


        return 0L;
    }

    public int longestValidParentheses(String s) {
        Stack<ParanthesisAndIndex> paranthesisAndIndexStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(!paranthesisAndIndexStack.empty()) {
                if(s.charAt(i) == ')' && paranthesisAndIndexStack.peek().isOpen) {
                    paranthesisAndIndexStack.pop();
                    continue;
                }
            }
            if(s.charAt(i) == ')') {
                paranthesisAndIndexStack.push(new ParanthesisAndIndex(i,true,false));
            }
            else {
                paranthesisAndIndexStack.push(new ParanthesisAndIndex(i, false, true));
            }
        }

        int longestValidParentheses = 0;
        if(paranthesisAndIndexStack.empty()) {
            return s.length();
        } else {
            int lastIndex = paranthesisAndIndexStack.pop().index;
            if (paranthesisAndIndexStack.empty()) {
                return Math.max(lastIndex, s.length() - lastIndex - 1);
            } else {
                longestValidParentheses = Math.max(longestValidParentheses, s.length() - lastIndex - 1);
                while (!paranthesisAndIndexStack.empty()) {
                    longestValidParentheses = Math.max(longestValidParentheses, lastIndex - paranthesisAndIndexStack.peek().index - 1);
                    lastIndex = paranthesisAndIndexStack.pop().index;
                }
                longestValidParentheses = Math.max(longestValidParentheses, lastIndex);
            }
            return longestValidParentheses;
        }
    }

    class ParanthesisAndIndex{
        int index;
        boolean isClosed;
        boolean isOpen;

        public ParanthesisAndIndex(int index, boolean isClosed, boolean isOpen) {
            this.index = index;
            this.isClosed = isClosed;
            this.isOpen = isOpen;
        }
    }
}
