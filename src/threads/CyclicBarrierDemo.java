package threads;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier实现线程同步  步调一致
 * @author Liumz
 * @since 2019-06-19  16:57:40
 */
public class CyclicBarrierDemo {

    Vector<String> pos;
    Vector<String> dos;

    Executor executor = Executors.newFixedThreadPool(1);

    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> check());
    });

    void check() {
        String a = pos.remove(0);
        String b = pos.remove(0);

        //diff = check()
        //save(diff)
    }

    void checkAll(){
        Thread t1 = new Thread(()->{
            pos.add("");
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            dos.add("");
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
