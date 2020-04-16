package threads;

import java.util.concurrent.*;

/**
 * @author Liumz
 * @since 2019-06-28  14:14:36
 */
public class CompletionServiceDemo {

    static ExecutorService executor = Executors.newFixedThreadPool(3);

    static CompletionService<Integer> cs = new ExecutorCompletionService<>(executor, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        cs.submit(() -> {
            Thread.sleep(2000);
            return 1;
        });
        cs.submit(() -> {
            Thread.sleep(1000);
            return 2;
        });
        cs.submit(() -> {
            Thread.sleep(3000);
            return 3;
        });

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                System.out.println();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
