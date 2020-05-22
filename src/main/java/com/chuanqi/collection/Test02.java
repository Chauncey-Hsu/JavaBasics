package com.chuanqi.collection;

import com.chuanqi.bean.Ship;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description
 * @Author Chauncey
 * @Date 2020/5/19 13:53
 * @Version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        Map<Integer, Ship> map = new HashMap<>();
        map.put(1,new Ship());
        map = null;
//        Iterator<Integer> iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            System.out.println(map.get(iterator.next()));
//        }

//        for (int i = 0; i < map.size(); i++) {
//            System.out.println(map.get(i));
//        }

//        for (Map.Entry entry : map) {
//
//        }
    }
}
