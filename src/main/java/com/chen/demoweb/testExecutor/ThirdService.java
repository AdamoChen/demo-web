package com.chen.demoweb.testExecutor;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 15:50
 */
@Service
public class ThirdService {

    @PreDestroy
    public String thirdTest(){
        LocalDateTime l = LocalDateTime.now();
        Date d = new Date();
        System.out.println(this.getClass().getSimpleName() + " preDestroy time: " + l);
        return l.toString();
    }

    public String third(){
        LocalDateTime l = LocalDateTime.now();
        Date d = new Date();
        System.out.println(" third() time: " + l);
        return l.toString();
    }
}