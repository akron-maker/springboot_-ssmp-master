package com.akron.service;

import com.akron.domain.book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author:Akron
 * @Date:created in 15:09 2022/1/23
 */
//MP提供的业务层接口
public interface IBookService extends IService<book> {
    IPage<book> getPage(Integer CurrentPage,Integer PageSize);
    IPage<book> getPage(Integer CurrentPage,Integer PageSize,book queryBook);//加入条件查询参数的接口
}
