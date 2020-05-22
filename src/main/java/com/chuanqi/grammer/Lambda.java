package com.chuanqi.grammer;

import com.chuanqi.bean.Ship;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description
 * @Author Chauncey
 * @Date 2020/5/22 10:16
 * @Version 1.0
 **/
public class Lambda {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.forEach(System.out::println);

//        ArrayList list = new ArrayList<String>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.forEach(System.out::println);

        ArrayList list = new ArrayList<Integer>();
        list.add("heima");
        System.out.println(list);
        list.add(2 );
        System.out.println(list);
        list.add(new Ship());
        System.out.println(list);
//        Class clazz = ArrayList.class;
//        Method me = clazz.getMethod("add", Object.class);
//        me.invoke(list, "heima");
//        System.out.println(list);
    }
}
