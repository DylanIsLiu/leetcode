package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁(当前线程可重复获取同一把锁)
 *
 * @author Liumz
 * @since 2019-06-17  17:32:37
 */
public class ReentrantLockDemo {

    /**
     * 可重入锁定义   默认非公平锁
     */
    private final Lock lock = new ReentrantLock();

    private int value;

    public int get() {
        lock.lock();
        try {
            return value;
        } finally {

        }
    }

    public void set(int value) {
        if(!lock.tryLock()){
            return;
        };
        try {
            this.value = value;
        } finally {
            lock.unlock();
        }
    }

    public void addOne() {
        lock.lock();
        try {
            //此处调用了加锁的get()，由于是可重入锁则无异常
            this.value = this.get() + 1;
        } finally {
            lock.unlock();

        }
    }

    /**
     * 可重入锁 公平锁
     */
    private final Lock fairLock = new ReentrantLock(true);

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(() -> {
            System.out.println(demo.get());
            System.out.println("线程1");

        }).start();
        new Thread(() -> {
            demo.set(3);
            System.out.println("线程2");
            System.out.println(demo.get());

        }).start();
    }

}
