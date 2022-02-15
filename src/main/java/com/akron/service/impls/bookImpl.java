package com.akron.service.impls;


import com.akron.dao.bookDao;
import com.akron.domain.book;
import com.akron.service.bookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Akron
 * @Date:created in 14:19 2022/1/23
 */
@Service
public class bookImpl implements bookService {

    @Autowired
    private bookDao bookDao;

    @Override
    public Boolean save(book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Boolean update(book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public IPage<book> getPage(int currentPage, int PageSize) {
        return bookDao.selectPage(new Page<>(currentPage,PageSize),null);
    }

    @Override
    public List<book> getAll() {
        return bookDao.selectList(null);
    }
}
