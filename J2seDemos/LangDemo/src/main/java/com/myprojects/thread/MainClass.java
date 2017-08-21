package com.myprojects.thread;

import com.myprojects.thread.countdownlatch.StartUp;

/**
 * Created by root on 2017/7/21.
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            boolean result = false;
            result  = StartUp.getInstance().executeServices();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
