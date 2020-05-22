package com.chuanqi.thread;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;


import java.util.concurrent.*;

/**
 * @Description 阿里规范不允许使用executors，除此之外有4种方式，第二种
 * 作者推荐
 * @Author Chauncey
 * @Date 2020/5/12 19:54
 * @Version 1.0
 **/
public class ExecutorsDemo {

    /**
     * Test shouldn't upon static method
     *
     * @param args
     */

    public static void main(String[] args) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("push-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(15, 200,
                5000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//        pool.execute(()->  System.out.println(Thread.currentThread().getName() + " - set.size() = " + updateMistakeSet.size()));

        // 有个问题，如果这个线程里面要做的事情比较多，那么这个，代码会显得十分没有条理
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                do {
//                    System.out.println(System.currentTimeMillis());;
//                } while (true);
//            }
//        });

//        pool.submit(Thread007::new);
        pool.execute(new Thread007());


    }

}

class Thread007 implements Runnable {

    @Override
    public void run() {
        do {
            System.out.println(System.currentTimeMillis());;
        } while (true);
    }
}
