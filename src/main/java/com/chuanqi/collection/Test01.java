package com.chuanqi.collection;

import com.chuanqi.bean.Ship;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Chauncey
 * @Date 2020/5/12 19:44
 * @Version 1.0
 **/
public class Test01 {


    public static void main(String[] args) {

        ArrayList<Ship> list = getAllList();
        HashSet updateMistakeSet = new HashSet<String>();
        for (int i = 0; i < list.size(); i++) {
            updateMistakeSet.add(list.get(i).getEquipmentId());
        }

        System.out.println(updateMistakeSet.size() + " this is first print") ;
        ExecutorService pool = getExecutorService(updateMistakeSet);

        updateMistakeSet.clear();
        for (int i = 0; i < list.size(); i++) {
            updateMistakeSet.add(list.get(i).getEquipmentId());
        }
        pool.shutdown();//gracefully shutdown
        System.out.println("shutdowned ？");
    }

    private static ExecutorService getExecutorService(HashSet updateMistakeSet) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(updateMistakeSet.size());
                }

            }
        });
        return pool;
    }

    private static ArrayList<Ship> getAllList() {
        ArrayList<Ship> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(new Ship(i, i + "2"));
        }
        return list;

    }
}
