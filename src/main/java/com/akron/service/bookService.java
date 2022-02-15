package com.akron.service;

import com.akron.domain.book;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author:Akron
 * @Date:created in 14:14 2022/1/23
 */
public interface bookService {
    Boolean save(book book);
    Boolean delete(Integer id);
    Boolean update(book book);
    book getById(Integer id);
    List<book> getAll();
    IPage<book> getPage(int currentPage,int PageSize);
}
