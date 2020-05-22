package com.chuanqi.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
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
//        threadPoolExecutor.shutdown();
    }
}
