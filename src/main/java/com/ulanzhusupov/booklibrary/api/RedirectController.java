/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.api;

import com.ulanzhusupov.booklibrary.entities.Author;
import com.ulanzhusupov.booklibrary.entities.Book;
import com.ulanzhusupov.booklibrary.repository.AuthorRepository;
import com.ulanzhusupov.booklibrary.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dollar
 */
@Controller
public class RedirectController {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        Page<Author> books = authorRepository.findByFioContainingIgnoreCaseOrderByFio("г", PageRequest.of(1, 10, Sort.DEFAULT_DIRECTION));
        System.out.println(books);
        return "ok";
    }
}
