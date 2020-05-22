package com.chuanqi.thread;

import com.chuanqi.bean.Ship;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description 4中创建线程的区别。
 * @Author Chauncey
 * @Date 2020/5/19 15:42
 * @Version 1.0
 **/
public class Thread007 {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 15,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        /**
         * 注意这个的区别。
         */
        // 这样不会运行。
        threadPoolExecutor.execute(()->new Thread(){
            @Override
            public void run(){
                System.out.println("0");
            }
        });
        threadPoolExecutor.execute(new Thread(){
            @Override
            public void run(){
                System.out.println("1");
            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("1.2");
            }
        };
        thread.run();
        thread.start();
//        threadPoolExecutor.execute(thread);

////////////////////////////////////////////////////////////////////////
        // 这样不会运行。
        threadPoolExecutor.execute(()->new Runnable(){
            @Override
            public void run(){
                System.out.println("2");
            }
        });
        //
        threadPoolExecutor.execute(new Runnable(){
            @Override
            public void run(){
                System.out.println("3");
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("4");
            }
        };
        runnable.run();
//        threadPoolExecutor.execute(runnable);

////////////////////////////////////////////////////////////////////////

        Callable<Ship> callable = new Callable<Ship>() {
            @Override
            public Ship call() throws Exception {
                return new Ship();
            }
        };
        try {
            Ship ship = callable.call();
            System.out.println(ship);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        threadPoolExecutor.execute(callable);
        threadPoolExecutor.shutdown();
    }
}
