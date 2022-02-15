package com.akron.service.impls;

import com.akron.dao.bookDao;
import com.akron.domain.book;
import com.akron.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Akron
 * @Date:created in 15:14 2022/1/23
 */
//MP提供的业务层接口实现类，需要继承ServiceImpl并添加泛型
@Service
public class IBookImpl extends ServiceImpl<bookDao, book> implements IBookService {
    @Autowired
    private bookDao bookDao;
    @Override
    public IPage<book> getPage(Integer CurrentPage, Integer PageSize) {
        return bookDao.selectPage(new Page<book>(CurrentPage,PageSize),null);
    }

    @Override//加入条件查询参数的实现
    public IPage<book> getPage(Integer CurrentPage, Integer PageSize, book queryBook) {
        Page<book> bookPage = new Page<>(CurrentPage,PageSize);
        LambdaQueryWrapper<book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(queryBook.getType()),book::getType,queryBook.getType());
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(queryBook.getBname()),book::getBname,queryBook.getBname());
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(queryBook.getDescription()),book::getDescription,
                queryBook.getDescription());
        return bookDao.selectPage(bookPage,bookLambdaQueryWrapper);
    }
}
