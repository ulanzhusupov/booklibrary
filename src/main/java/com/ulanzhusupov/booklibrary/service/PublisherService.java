/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.service;

import com.ulanzhusupov.booklibrary.dao.PublisherDao;
import com.ulanzhusupov.booklibrary.entities.Publisher;
import com.ulanzhusupov.booklibrary.repository.PublisherRepository;
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
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;
    
    @Override
    public Publisher get(long id) {
        return publisherRepository.getOne(id);
    }
    
    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int intPageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, intPageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> search(String... searchQuery) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchQuery[0]);
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchQuery) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchQuery[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
    
}
