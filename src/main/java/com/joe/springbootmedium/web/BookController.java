package com.joe.springbootmedium.web;

import com.joe.springbootmedium.domain.Book;
import com.joe.springbootmedium.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/books")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;


//    書單詳情
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book =bookService.getBookById(id);
        model.addAttribute("book",book);
        return "book";
    }






////    於Controller錯誤處理，只能處理這個Controller
//    @ExceptionHandler({Exception.class})
//    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
//
//        logger.error("Request URL : {} , Exception : {}", request.getRequestURL(),e.getMessage());
////      若有已設定異常狀態碼之異常則直接拋出
//        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
//            throw e;
//        }
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("url",request.getRequestURL());
//        modelAndView.addObject("exception",e);
//        modelAndView.setViewName("error/error");
//
//        return modelAndView;
//    }
}
