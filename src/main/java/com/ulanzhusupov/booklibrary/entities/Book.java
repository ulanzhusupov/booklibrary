/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author dollar
 */
@Entity
@Table(name="book", catalog="library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Book {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Lob
    @Column(updatable=false)
    private byte[] content;
    
    private String name;
    
    @Column(name="page_count")
    private Integer pageCount;
    
    private String isbn;
    
    @ManyToOne
    @JoinColumn
    private Author author;
    
    @ManyToOne
    @JoinColumn
    private Genre genre;
    
    @ManyToOne
    @JoinColumn
    private Publisher publisher;
    
    @Column(name="publish_year")
    private Integer publishYear;
    
    private byte[] image;
    
    private String descr;
    
    @Column(name="view_count")
    private Integer viewCount;
    
    @Column(name="total_rating")
    private long totalRating;
    
    @Column(name="total_vote_count")
    private long totalVoteCount;
    
    @Column(name="avg_rating")
    private int avgRating;
    
    public Book() {}
    
    public Book(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Book(Long id, String name, Integer pageCount, String isbn, Author author, Genre genre, Publisher publisher, Integer publishYear, byte[] image, String descr, Integer viewCount, long totalRating, long totalVoteCount, int avgRating) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.viewCount = viewCount;
        this.totalRating = totalRating;
        this.totalVoteCount = totalVoteCount;
        this.avgRating = avgRating;
    }
    
    public String toString() { return name; }
}
