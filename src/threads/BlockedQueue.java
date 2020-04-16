package threads;

import sun.invoke.empty.Empty;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程阻塞队列，一直到队列条件满足
 *
 * @author Liumz
 * @since 2019-06-03  22:24:35
 */
public class BlockedQueue<T> {
    boolean isFull;
    boolean isEmpty;

    //可重入锁
    final Lock lock = new ReentrantLock();
    //条件变量 队列不满
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    //入队
    void enq(T t) {
        lock.lock();
        try {
            while (isFull) {
                notFull.await();
            }
            //入队后通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    //出队
    void deq(T t) {
        lock.lock();
        try {
            while (isEmpty) {
                notEmpty.await();
            }
            //出队后通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }
}
