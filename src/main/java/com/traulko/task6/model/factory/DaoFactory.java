package com.traulko.task6.model.factory;

import com.traulko.task6.model.dao.BookListDAO;
import com.traulko.task6.model.dao.impl.BookListDAOImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final BookListDAO bookListDAOImpl = new BookListDAOImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public BookListDAO getBookListDao() {
        return bookListDAOImpl;
    }
}
