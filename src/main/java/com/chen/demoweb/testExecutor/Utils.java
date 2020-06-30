package com.chen.demoweb.testExecutor;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 17:45
 */
public class Utils {
    public static void wihleTrue(){
        int i = 1000;
        while(true){

            i ++;
            if(i % 100000000 == 0){
                // System.out.println(System.currentTimeMillis());
                System.out.print(1);
            }
            if(i == 500*100000000){
                System.out.println();
                i = 0;
            }

        }
    }
}