/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.service;

import com.ulanzhusupov.booklibrary.dao.AuthorDao;
import com.ulanzhusupov.booklibrary.entities.Author;
import com.ulanzhusupov.booklibrary.repository.AuthorRepository;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author dollar
 */
@Service
@Transactional
public class AuthorService implements AuthorDao {
    
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(long id) {
        return authorRepository.getOne(id);
    }
    
    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int intPageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, intPageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> search(String... searchQuery) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchQuery[0]);
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchQuery) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchQuery[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
    
}
