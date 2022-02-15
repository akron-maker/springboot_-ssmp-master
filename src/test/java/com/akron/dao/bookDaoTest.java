package com.akron.dao;

import com.akron.domain.book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author:Akron
 * @Date:created in 20:55 2022/1/22
 */
@SpringBootTest
public class bookDaoTest {

    @Autowired
    private bookDao bookDao;

    @Test//测试查找单个
    public void testgetByid(){
        book book = bookDao.selectById(1);
        System.out.println(book);
    }
    @Test//测试插入操作
    public void testInsert(){
        book book = new book();
        book.setType("测试");
        book.setBname("测试");
        book.setDescription("测试");
        bookDao.insert(book);//配置id-type: auto，否则argument type mismatch
    }
    @Test//测试删除操作
    public void testDelete(){
        bookDao.deleteById(12);
    }
    @Test//测试更新操作
    public void testUpdate(){
        book book = new book();
        book.setId(12);
        book.setType("测试123");
        book.setBname("测试123");
        book.setDescription("测试123");
        bookDao.updateById(book);
    }
    @Test//测试查找全部,可在配置文件中更改日志输出方式，configuration:log-impl：org.apache.ibatis.logging.stdout.StdOutImpl
    public void testGetAll(){
        bookDao.selectList(null);
    }
    @Test//测试分页操作，需要写配置类设置MP拦截器
    public void testGetPage(){
        Page<book> bookPage = bookDao.selectPage(new Page<>(2, 5), null);
//        IPage对象封装了所有分页数据
        System.out.println(bookPage.getRecords());//数据
        System.out.println(bookPage.getTotal());//总数
        System.out.println(bookPage.getSize());//页面大小
        System.out.println(bookPage.getCurrent());//当前页
        System.out.println(bookPage.getOrders());//
        System.out.println(bookPage.getCountId());//
        System.out.println(bookPage.getMaxLimit());//
    }
    @Test//测试条件查询
    public void testGetBy(){
        String name="语言";//用户输入条件字符串
        LambdaQueryWrapper<book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();//建立一个条件构造器对象LambdaQueryWrapper,
        // 不需要手动写比较属性名，可以非空判断
        // ，也可用原生的QueryWrapper，需要手动写比较属性名，容易出错
        bookLambdaQueryWrapper.like(name!=null,book::getBname,name);//模糊查询，还有许多api
        bookDao.selectList(bookLambdaQueryWrapper);
    }
}
