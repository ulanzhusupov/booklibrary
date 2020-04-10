/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.repository;

import com.ulanzhusupov.booklibrary.entities.Publisher;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dollar
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String... publisherQuery);
    
    Page<Publisher> findByNameContainingIgnoreCaseOrderByName(String publisherQuery, Pageable pageable);
}
