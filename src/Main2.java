import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runni());
        thread1.setName("one");
        Thread thread2 = new Thread(new Runni());
        thread2.setName("two");
        Thread thread3 = new Thread(new Runni());
        thread3.setName("three");
        try {
            thread3.start();
            thread3.join();
            thread2.start();
            thread2.join();
            thread1.start();
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("main potok");
    }
}

class Runni2 implements Runnable {
    public static int count=0;
    public static ReentrantLock reentrantLock= new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            reentrantLock.lock();
                count++;
                reentrantLock.unlock();

            System.out.println("В потоке :" + Thread.currentThread().getName());
        }
        System.out.println(count);
    }
}
