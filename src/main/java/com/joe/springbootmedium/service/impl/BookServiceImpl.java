package com.joe.springbootmedium.service.impl;

import com.joe.springbootmedium.domain.Book;
import com.joe.springbootmedium.domain.BookRepository;
import com.joe.springbootmedium.exception.BookNotFoundException;
import com.joe.springbootmedium.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        //因spring boot的版本與影片不同(課程為1.5.7版)所以其帶入方法也不同
        Optional<Book> book = bookRepository.findById(id);


        if (!book.isPresent()){
            throw new BookNotFoundException("書單信息不存在");
        }
        return book.get();
    }
}
