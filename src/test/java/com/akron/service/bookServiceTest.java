package com.akron.service;

import com.akron.domain.book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:Akron
 * @Date:created in 14:32 2022/1/23
 */
@SpringBootTest
public class bookServiceTest {

    @Autowired
    private bookService bookService;

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
        System.out.println(bookService.delete(13));
    }
    @Test
    public void testUpdate(){
        book book = new book();
        book.setId(14);
        book.setType("service");
        book.setBname("service");
        book.setDescription("service123");
        System.out.println(bookService.update(book));
    }
    @Test
    public void testGetAll(){
        System.out.println(bookService.getAll());
    }
    @Test
    public void testGetPage(){
        System.out.println(bookService.getPage(1,4));
    }

}
