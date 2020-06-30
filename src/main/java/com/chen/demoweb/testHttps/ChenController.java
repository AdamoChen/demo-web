package com.chen.demoweb.testHttps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Adamo_chen
 * @Date: 2020/6/13 16:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/chen")
public class ChenController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(String name){
        System.out.println("--- 参数 ---：" + name);
        return "name : " + name;
    }
}
