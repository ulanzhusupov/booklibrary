/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.repository;

import com.ulanzhusupov.booklibrary.entities.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dollar
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String bookQuery);
    
    Page<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String searchQuery, Pageable pageable);

    @Query("select new com.ulanzhusupov.booklibrary.entities.Book(b.id, b.name, b.pageCount, b.isbn, b.author, b.genre, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);
    
    @Modifying(clearAutomatically=true)
    @Query("update Book b set b.content=:content where b.id=:id")
    void updateContent(@Param("id") long id, @Param("content") byte[] content);
    
    @Query("select new com.ulanzhusupov.booklibrary.entities.Book(b.id, b.image) from Book b")
    List<Book> findTopBooks(Pageable pageable);
    
    @Query("select b.content from Book b where b.id=:id")
    byte[] getContent(@Param("id") long id);
    
    @Query("select new com.ulanzhusupov.booklibrary.entities.Book(b.id, b.name, b.pageCount, b.isbn, b.author, b.genre, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b where b.genre.id=:id")
    Page<Book> findByGenre(@Param("id") long genreId, Pageable pageable);
}
