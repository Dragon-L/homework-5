package com.thoughtworks.lgl.controller;

import com.thoughtworks.lgl.model.Book;
import com.thoughtworks.lgl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookShelfControllerByJson {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public @ResponseBody Iterable<Book> queryBooks() {
        return bookService.findAll();
    }

    @RequestMapping(value = "/json/book/{isbn}", method = RequestMethod.GET)
    public @ResponseBody Book getBook(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @RequestMapping(value = "/json/book/new",method = RequestMethod.GET)
    public @ResponseBody Book newBook(){
        return new Book();
    }

//    @RequestMapping(value = "book",method = RequestMethod.POST)
//    public String createNewBook(Book book){
//        bookService.addBook(book);
//        return "redirect:/json";
//    }

    @RequestMapping(value = "/json/book/edit/{isbn}",method = RequestMethod.GET)
    public @ResponseBody Book editBook(@PathVariable String isbn){
        return bookService.findByIsbn(isbn);
    }


}
