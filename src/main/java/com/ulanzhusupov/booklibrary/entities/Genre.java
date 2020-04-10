/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.entities;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author dollar
 */
@Entity
@Table(name="genre", catalog="library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Genre {
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(nullable=false)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Basic(fetch=FetchType.LAZY)
    @OneToMany(mappedBy="genre")
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public String toString() { return name; }
}
