import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        Counter counter =  new Counter();

        Thread first = new Thread(counter, "First");
        Thread second = new Thread(counter, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(counter.count);

    }
    /* System.out.println("Start");
        Thread.sleep(2000);
        System.out.println("End");*/
    static class Counter extends Thread{
        public AtomicInteger count = new AtomicInteger(0);

        public void run(){
            for (int i = 0; i < 100_000_000; i++) {
                count.addAndGet(1);
            }
        }
    }

}