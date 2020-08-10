package com.sun.springcloud.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author makejava
 * @since 2020-08-05 23:57:35
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class Dept implements Serializable {
    private static final long serialVersionUID = -51820738686135899L;

    private Long deptno;

    private String dname;

    private String dbSource;



}