package com.sun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.springcloud.pojo.entity.Dept;
import com.sun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
          throw new RuntimeException("id=>"+id+",不存在该用户，或者信息无法找到~");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return  new Dept().setDeptno(id)
                .setDname("id=>"+id+",没有对应信息，null~@Hystrix")
                .setDbSource("no this database in MySql");
    }
}
