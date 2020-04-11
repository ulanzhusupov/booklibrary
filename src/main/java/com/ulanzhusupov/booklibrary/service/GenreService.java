/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.service;

import com.ulanzhusupov.booklibrary.dao.GenreDao;
import com.ulanzhusupov.booklibrary.entities.Genre;
import com.ulanzhusupov.booklibrary.repository.GenreRepository;
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
public class GenreService implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;
    
    @Override
    public Genre get(long id) {
        return genreRepository.getOne(id);
    }
    
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
    
    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int intPageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(PageRequest.of(pageNumber, intPageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public List<Genre> search(String... searchQuery) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchQuery[0]);
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchQuery) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchQuery[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
    
}
