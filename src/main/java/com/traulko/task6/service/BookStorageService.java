package com.traulko.task6.service;

import com.traulko.task6.exception.BookStorageServiceException;
import com.traulko.task6.model.entity.CustomBook;

import java.util.List;
import java.util.UUID;

public interface BookStorageService {
    void add(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException;

    void remove(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException;

    CustomBook findById(UUID id);

    List<CustomBook> findByName(String name);

    List<CustomBook> findByAuthor(String author);

    List<CustomBook> findByPagesCount(int pagesCount);

    List<CustomBook> findByPublishingYear(int publishingYear);

    List<CustomBook> sortById();

    List<CustomBook> sortBooksByName();

    List<CustomBook> sortBooksByAuthor();

    List<CustomBook> sortBooksByPagesCount();

    List<CustomBook> sortBooksByPublishingYear();

    List<CustomBook> findAll();
}
