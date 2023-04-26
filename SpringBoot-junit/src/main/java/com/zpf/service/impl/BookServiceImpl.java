package com.zpf.service.impl;

import com.zpf.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("running...");
    }
}
