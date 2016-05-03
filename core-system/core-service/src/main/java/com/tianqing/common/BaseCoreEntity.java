package com.tianqing.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 基础核心库实体
 * Created by hyb on 2016/4/26.
 */
@MappedSuperclass
@Data
public abstract class BaseCoreEntity {

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Column(name="req_seq")
    private String reqSeq;

}
