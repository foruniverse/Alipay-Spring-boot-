package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Book;
import com.demo.springboot.helloworld.mapper.BookMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    public PageInfo<Book> findBooks(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Book> books = bookMapper.selectByExample(null);
        return new PageInfo<>(books);
    }

    @Override
    @Transactional // 事务对应的注解
    public void deleteBookById(Book book) {
        bookMapper.deleteByPrimaryKey(book.getId());
    }

    @Override
    public void deleteBooksByIds(List<Integer> ids) {
        bookMapper.deleteBooksByIds(ids);
    }
}
