package com.tianqing.entity;

import com.tianqing.common.BaseCoreEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 学生实体类
 * Created by hyb on 2016/4/12.
 */
@Entity
@Table(name="student")
@Data
public class DB_Student extends BaseCoreEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="age")
    private Integer age;

}
