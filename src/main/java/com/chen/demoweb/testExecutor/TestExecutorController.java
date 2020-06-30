package com.chen.demoweb.testExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 15:52
 */
@Controller
@RequestMapping("/TestExecutorController")
public class TestExecutorController {

    @Autowired
    ThreadPoolService threadPoolService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String name){
        System.out.println("---TestExecutorController 参数 ---：" + name);
        int i = 0;
        while(i<20){
            threadPoolService.testAsync();
            i++;
        }
        return "id : " + i;
    }
}