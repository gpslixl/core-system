package com.tianqing.common;

import com.tianqing.common.emun.AppType;
import com.tianqing.common.util.reqcreator.SequenceCreator;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 基础请求类
 * Created by hyb on 2016/4/26.
 */
@Data
public class BaseCoreRequest {

    @NotNull
    private String reqIp;

    @NotNull
    private Date reqTime;

    @NotNull
    private AppType reqApp;

    @NotNull
    private String reqSeq;

}
