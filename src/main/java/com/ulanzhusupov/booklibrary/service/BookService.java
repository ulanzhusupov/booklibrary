/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.service;

import com.ulanzhusupov.booklibrary.dao.BookDao;
import com.ulanzhusupov.booklibrary.entities.Book;
import com.ulanzhusupov.booklibrary.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author dollar
 */
public class BookService implements BookDao {
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0, limit));
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }
    
    @Override
    public Book get(long id) {
        return bookRepository.getOne(id);
    }    

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    
    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int intPageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAll(PageRequest.of(pageNumber, intPageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Book> getBooksByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> search(String... searchQuery) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchQuery[0]);
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchQuery) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchQuery[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
    
}
