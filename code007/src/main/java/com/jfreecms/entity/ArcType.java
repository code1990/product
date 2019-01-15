package com.jfreecms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 8:39
 * @Author: Mr.Deng
 * @Description:资源类型 确切的来讲是分类信息 分类信息需要被加载到applicationContext当中
 */
@Entity
@Table(name="t_arcType")
public class ArcType {

    /**编号*/
    @Id
    @GeneratedValue
    private Integer id;

    /**资源类型名称*/
    @Column(length=100)
    private String name;

    /**描述*/
    @Column(length=1000)
    private String remark;

    /**排序 从小到大*/
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

