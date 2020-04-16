package threads;

import com.sun.org.apache.bcel.internal.generic.F2D;

import java.util.concurrent.CompletableFuture;

/**
 * JDK1.8 CompletableFuture
 *
 * @author Liumz
 * @since 2019-06-27  10:02:09
 */
public class CompletableFutureDemo {

    public static CompletableFuture f1 = CompletableFuture.runAsync(()->{
        System.out.println("f1");
    });
    public static  CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
        System.out.println("f2");
        return "f2";
    });
    public static  CompletableFuture f3 = f1.thenCombine(f2, (r1,r2)->{
        System.out.println(r1);
        System.out.println(r2);
        return "f3:"+r1+r2;
    });

    public static void main(String[] args) {
        //串行
        f1.thenAccept((r1)->{
            System.out.println("f1 accept");
        });

    }
}
