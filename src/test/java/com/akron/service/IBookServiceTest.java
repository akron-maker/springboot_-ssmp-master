package com.akron.service;

import com.akron.domain.book;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:Akron
 * @Date:created in 15:18 2022/1/23
 */
//MP提供业务层的测试
@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    public void testGetById(){
        book bookServiceById = bookService.getById(1);
        System.out.println(bookServiceById);
    }

    @Test
    public void testSave(){
        book book = new book();
        book.setType("service");
        book.setBname("service");
        book.setDescription("service");
        Boolean save = bookService.save(book);
        System.out.println(save);
    }
    @Test
    public void testDelete(){
        System.out.println(bookService.removeById(15));
    }
    @Test
    public void testUpdate(){
        book book = new book();
        book.setId(14);
        book.setType("service");
        book.setBname("service123");
        book.setDescription("service123");
        System.out.println(bookService.updateById(book));
    }
    @Test
    public void testGetAll(){
        System.out.println(bookService.list());
    }
    @Test
    public void testGetPage(){
        Page<book> page = new Page<>(2, 4);
        bookService.page(page);
        System.out.println(page.getRecords());
    }
}