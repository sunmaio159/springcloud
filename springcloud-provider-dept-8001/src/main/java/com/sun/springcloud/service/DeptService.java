package com.sun.springcloud.service;

import com.sun.springcloud.pojo.entity.Dept;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
