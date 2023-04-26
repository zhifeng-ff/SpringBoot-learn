package com.zpf.dao;

import com.zpf.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from t_book where id= #{id}")
    public Book getById(Integer id);
}
