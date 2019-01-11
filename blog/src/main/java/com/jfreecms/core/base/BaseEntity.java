package com.jfreecms.core.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: blog
 * @Date: 2019/1/11 0011 14:05
 * @Author: Mr.Deng
 * @Description:
 */
public class BaseEntity extends AbstractEntity{

    /**模型编号*/
    @Id
    @GenericGenerator(name="uuid",strategy="uuid")
    @GeneratedValue(generator="uuid")
    @Column(length=32,name="id")
    private String id;

    /**创建时间*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false,updatable=false,name="create_time")
    private Date createTime = new Date();

    /**当前的表是否失效*/
    @Transient
    private Integer delFlag = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
