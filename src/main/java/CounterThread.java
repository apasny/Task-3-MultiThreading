public class CounterThread implements Runnable{
    @Override
    public void run() {
        new Counter().count();
    }
}
