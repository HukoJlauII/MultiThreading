import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread Ping = new Thread(new PingPongThread(),"Ping");
        Thread Pong = new Thread(new PingPongThread(),"Pong");
        Ping.start();
        Pong.start();

    }


    static class PingPongThread implements Runnable{
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
