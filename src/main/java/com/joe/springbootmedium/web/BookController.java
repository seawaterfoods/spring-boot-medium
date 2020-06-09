package com.joe.springbootmedium.web;

import com.joe.springbootmedium.domain.Book;
import com.joe.springbootmedium.exception.BookNotFoundException;
import com.joe.springbootmedium.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


//    書單詳情
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book =bookService.getBookById(id);
        model.addAttribute("book",book);
        return "book";
    }
}
