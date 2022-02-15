package com.akron.controller;

import com.akron.controller.utils.resultsChange;
import com.akron.domain.book;
import com.akron.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:Akron
 * @Date:created in 15:48 2022/1/23
 */
@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public resultsChange getAll()  {
        System.out.println("getall");
        System.out.println("getall2");
        System.out.println("getall3");
        return new resultsChange(true,bookService.list());
    }
    @PostMapping
    public resultsChange save(@RequestBody book book) throws Exception{
        if (book.getBname().equals("123")) throw new Exception();//测试异常处理
        return new resultsChange(bookService.save(book));
    }
    @DeleteMapping("{id}")
    public resultsChange delete(@PathVariable Integer id){
        return new resultsChange(bookService.removeById(id));
    }
    @PutMapping
    public resultsChange update(@RequestBody book book){
        return new resultsChange(bookService.updateById(book));
    }
    @GetMapping("{id}")
    public resultsChange getById(@PathVariable Integer id){
        return new resultsChange(true,bookService.getById(id));
    }
//    @GetMapping("{CurrentPage}/{PageSize}")
//    public resultsChange getPage(@PathVariable Integer CurrentPage,@PathVariable Integer  PageSize){
//        IPage<book> page = bookService.getPage(CurrentPage, PageSize);
//        //如果当前页码值大于总页码值，就传入总页码值重新获得page对象
//        if (CurrentPage>page.getPages()){
//            page = bookService.getPage((int) page.getPages(), PageSize);
//        }
//        return new resultsChange(true,page);
//    }
@GetMapping("{CurrentPage}/{PageSize}")
public resultsChange getPage(@PathVariable Integer CurrentPage,@PathVariable Integer  PageSize,book book){
    IPage<book> page = bookService.getPage(CurrentPage, PageSize,book);
    //如果当前页码值大于总页码值，就传入总页码值重新获得page对象
    if (CurrentPage>page.getPages()){
        page = bookService.getPage((int) page.getPages(), PageSize,book);
    }
    return new resultsChange(true,page);
}
}
