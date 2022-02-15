package com.akron.controller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Akron
 * @Date:created in 17:39 2022/1/23
 */
//用于前后端数据统一
@Data
public class resultsChange {
    private Boolean flag;
    private Object data;
    private String exceptionMSG;
    public resultsChange(){}
    public resultsChange(boolean flag){
        this.flag=flag;
    }
    public resultsChange(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public resultsChange(String exceptionMSG){
       this.exceptionMSG=exceptionMSG;
    }
}