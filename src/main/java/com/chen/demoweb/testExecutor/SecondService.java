package com.chen.demoweb.testExecutor;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 15:51
 */
@Service
public class SecondService {

    @PreDestroy
    public String secondTest(){
        Date d = new Date();
        LocalDateTime l = LocalDateTime.now();
        System.out.println(this.getClass().getSimpleName() + " preDestroy time: " + l);
        return d.toString();
    }

    public String second(){
        LocalDateTime l = LocalDateTime.now();
        Date d = new Date();
        System.out.println( " second() time: " + l);
        return d.toString();
    }
}