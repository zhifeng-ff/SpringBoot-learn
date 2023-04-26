package com.zpf;

import com.zpf.dao.BookDao;
import com.zpf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpirngBootMybatisApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void  testGetById() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }

}
