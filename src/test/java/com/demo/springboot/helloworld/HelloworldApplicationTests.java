package com.demo.springboot.helloworld;

import com.demo.springboot.helloworld.common.domain.Book;
import com.demo.springboot.helloworld.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloworldApplicationTests {
    @Autowired
    BookMapper bookMapper;

    @Test
    void contextLoads() {
        for (int i = 1; i <= 103; i++) {
            Book book = new Book();
            book.setAuthor("作者-"+i);
            book.setName("名字-"+i);
            book.setPrice(Math.random()*100);
            book.setRemark("备注信息-"+i);
            bookMapper.insert(book);
        }
    }

}
