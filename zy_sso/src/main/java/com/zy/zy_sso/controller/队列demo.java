package com.zy.zy_sso.controller;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: SpringCloud
 * @description: queue
 * @author: zhang yi
 * @create: 2019-10-25 11:13
 */
public class 队列demo {
    public static void main(String[] args){

        //测试队列
        System.out.println("测试队列：");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        for(int e : queue) {
            System.out.println(e);
        }
        System.out.println("----------");
        System.out.println("poll : " + queue.poll());
        System.out.println("----------");

        for(int e : queue) {
            System.out.println(e);
        }
        System.out.println("ele is: " + queue.element());
        System.out.println("----------");

        for(int e : queue) {
            System.out.println(e);
        }

        System.out.println("peek : " + queue.peek());
        System.out.println("----------");

        for(int e : queue) {
            System.out.println(e);
        }
    }
}