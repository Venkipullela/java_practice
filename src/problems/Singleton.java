package problems;

public class Singleton {
    private static Singleton singletonInstance = new Singleton();
    private static Singleton singletonInstance2;
    private Singleton(){ }

    synchronized public Singleton getSingletonInstance() {
        if(singletonInstance == null){
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }

    synchronized public static void getSingletonInstance2() {
        System.out.println();
        //notify();
    }



}
