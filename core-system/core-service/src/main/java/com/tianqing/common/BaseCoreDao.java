package com.tianqing.common;

import com.tianqing.common.BaseCoreEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 基础核心库操作类
 * Created by hyb on 2016/4/26.
 */
public abstract class BaseCoreDao<T extends BaseCoreEntity> extends HibernateDaoSupport {

    @Resource
    private void initHibernateTemplate(SessionFactory sessionFactory){
        super.setHibernateTemplate(super.createHibernateTemplate(sessionFactory));
    }

    protected abstract Class getEntityClass();

    public Serializable save(T entity){
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return super.getHibernateTemplate().save(entity);
    }

    public List<T> findAll(){
        return super.getHibernateTemplate().loadAll(this.getEntityClass());
    }

}
