package com.akron.dao;

import com.akron.domain.book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:Akron
 * @Date:created in 20:52 2022/1/22
 */
@Mapper
@Repository
public interface bookDao extends BaseMapper<book> {

}
