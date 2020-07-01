package com.chen.demoweb.testExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 15:48
 */
@Service
public class ThreadPoolService {

    @Autowired
    FirstService firstService;

    @Autowired
    SecondService secondService;

    @Async("testExeCutor")
    public void testAsync(){
        try {
            System.out.println("---start testAsync---");
            //Utils.wihleTrue();

            Thread.sleep(3000);
            firstService.first();
            Thread.sleep(3000);
            secondService.second();
            System.out.println(Thread.currentThread().getName() + "------------------ call testAsync done ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}