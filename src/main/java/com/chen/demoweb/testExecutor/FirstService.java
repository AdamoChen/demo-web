package com.chen.demoweb.testExecutor;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 15:50
 */
@Service
public class FirstService  {

    @PreDestroy
    public String firstTest(){
        LocalDateTime l = LocalDateTime.now();
        Date d = new Date();
        System.out.println(this.getClass().getSimpleName() + " preDestroy time: " + l);
        return l.toString();
    }

    public String first(){
        LocalDateTime l = LocalDateTime.now();
        Date d = new Date();
        System.out.println(" first() time: " + l);
        return l.toString();
    }
}