package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Book;
import com.demo.springboot.helloworld.common.utils.Result;
import com.demo.springboot.helloworld.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/getbooks")
    @ResponseBody
    public Object getBooks(@RequestParam(defaultValue = "1") int pageNo,  @RequestParam(defaultValue = "10")int pageSize){
        return Result.success(bookService.findBooks(pageNo,pageSize),"分页 查询book 对象");
    }

    @GetMapping("/listbooks")
    public String toBookListPage(){

        return "/views/book/book-list";
    }

    @DeleteMapping("/deleteBook")
    @ResponseBody
    public Object deleteBook(@RequestBody Book book){
        bookService.deleteBookById(book);
        return Result.success(book.getId());
    }

    @DeleteMapping("/deleteBooks")
    @ResponseBody
    public Object deleteBooks(@RequestBody List<Integer> ids){
        bookService.deleteBooksByIds(ids);
        return Result.success();
    }
}
