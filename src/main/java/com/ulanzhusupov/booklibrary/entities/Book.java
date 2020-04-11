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
    
    @Column(name="total_vote_count")
    private long totalVoteCount;
    
    @Column(name="avg_rating")
    private long avgRating;
    
    @Column(name="total_rating")
    private long totalRating;
    
    public Book() {}
    
    public Book(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Book(Long id, String name, Integer pageCount, String isbn, Author author, Genre genre, Publisher publisher, Integer publishYear, byte[] image, String descr, Integer viewCount, long totalRating, long totalVoteCount, long avgRating) {
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

    public Long getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public long getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(long totalRating) {
        this.totalRating = totalRating;
    }

    public long getTotalVoteCount() {
        return totalVoteCount;
    }

    public void setTotalVoteCount(long totalVoteCount) {
        this.totalVoteCount = totalVoteCount;
    }

    public long getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(long avgRating) {
        this.avgRating = avgRating;
    }
    
}
