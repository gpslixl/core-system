package com.tianqing.common;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * 基础核心服务类
 * Created by hyb on 2016/4/26.
 */
public abstract class BaseCoreService {

    @Resource
    private ThreadPoolTaskExecutor poolTaskExecutor;

    protected void addTask(Runnable task){
        this.poolTaskExecutor.execute(task);
    }

    protected Object addTaskAndReturn(Callable<Object> callBack){
        return this.poolTaskExecutor.submit(callBack);
    }

}
