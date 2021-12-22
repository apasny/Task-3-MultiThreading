public class Counter {

    public synchronized void count(){
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " counts " + i);
        }
    }

}
