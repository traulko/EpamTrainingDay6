package com.traulko.task6.model.dao;

import com.traulko.task6.exception.DaoException;
import com.traulko.task6.model.entity.CustomBook;
import java.util.List;

public interface BookListDAO {
    void add(CustomBook book) throws DaoException;

    void remove(CustomBook book) throws DaoException;

    CustomBook findById(String id);

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
