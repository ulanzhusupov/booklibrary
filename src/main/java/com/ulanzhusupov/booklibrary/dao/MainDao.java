/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulanzhusupov.booklibrary.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 *
 * @author dollar
 */
public interface MainDao<T> {
    // получение всех записей
    List<T> getAll();
    
    // получение записи по id
    T get(long id);
    
    // сохраняет или обновляет объект(один метод на 2 случая)
    T save(T book);
    
    // удаление записи
    void delete(T book);
    
    // поиск записи по тексту
    List<T> search(String... searchQuery);
    
    // получение всех записей с сортировкой
    List<T> getAll(Sort sort);
    
    // получение всех записей с постраничностью
    Page<T> getAll(int pageNumber, int  intPageSize, String sortField, Sort.Direction sortDirection);
    
    // поиск записей с постраничностью
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchQuery);
}
