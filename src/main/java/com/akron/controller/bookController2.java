package com.akron.controller;

import com.akron.domain.book;
import com.akron.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Akron
 * @Date:created in 15:48 2022/1/23
 */
//@RestController
@RequestMapping("/books")
public class bookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<book> getAll(){
        return bookService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody book book){
        return bookService.save(book);
    }
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }
    @PutMapping
    public Boolean update(@RequestBody book book){
        return bookService.updateById(book);
    }
    @GetMapping("{id}")
    public book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }
    @GetMapping("{CurrentPage}/{PageSize}")
    public IPage<book> getPage(@PathVariable Integer CurrentPage,@PathVariable Integer  PageSize){
        return bookService.getPage(CurrentPage,PageSize);
    }
}
