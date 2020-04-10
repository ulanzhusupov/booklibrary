/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.dao;

import com.ulanzhusupov.booklibrary.entities.Book;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 *
 * @author dollar
 */
public interface BookDao extends MainDao<Book> {
    
    List<Book> findTopBooks(int limit);
    
    // получение контента по id
    byte[] getContent(long id);
    
    // получение книг по жанру с постраничностью
    Page<Book> getBooksByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);
}
