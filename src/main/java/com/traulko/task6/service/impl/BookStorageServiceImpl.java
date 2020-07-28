package com.traulko.task6.service.impl;

import com.traulko.task6.exception.BookStorageServiceException;
import com.traulko.task6.exception.DaoException;
import com.traulko.task6.model.dao.BookListDao;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.model.factory.DaoFactory;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.validator.BookValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookStorageServiceImpl implements BookStorageService {
    @Override
    public void add(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException {
        BookValidator bookValidator = new BookValidator();
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();

        boolean isCorrectParameters = bookValidator.isCorrectName(name) &&
                bookValidator.isCorrectAuthor(authors) &&
                bookValidator.isCorrectPagesCount(pagesCount) &&
                bookValidator.isCorrectPublishingYear(publishingYear);
        if (isCorrectParameters) {
            CustomBook book = new CustomBook(name, getAuthors(authors), pagesCount, publishingYear);
            try {
                bookListDAO.add(book);
            } catch (DaoException e) {
                throw new BookStorageServiceException(e.getMessage());
            }
        } else {
            throw new BookStorageServiceException("Incorrect parameters");
        }
    }

    @Override
    public void remove(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException {
        BookValidator bookValidator = new BookValidator();
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();

        boolean isCorrectParameters = bookValidator.isCorrectName(name) &&
                bookValidator.isCorrectAuthor(authors) &&
                bookValidator.isCorrectPagesCount(pagesCount) &&
                bookValidator.isCorrectPublishingYear(publishingYear);
        if (isCorrectParameters) {
            CustomBook book = new CustomBook(name, getAuthors(authors), pagesCount, publishingYear);
            try {
                bookListDAO.remove(book);
            } catch (DaoException e) {
                throw new BookStorageServiceException(e.getMessage());
            }
        } else {
            throw new BookStorageServiceException("Incorrect parameters");
        }
    }

    @Override
    public CustomBook findById(UUID id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.findById(id);
    }

    @Override
    public List<CustomBook> findByName(String name) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();

        List<CustomBook> neededBooks = new ArrayList<>();
        if (validator.isCorrectName(name)) {
            neededBooks = bookListDAO.findByName(name);
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();

        List<CustomBook> neededBooks = new ArrayList<>();
        if (validator.isCorrectAuthor(author)) {
            neededBooks = bookListDAO.findByAuthor(author);
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPagesCount(int pagesCount) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();

        List<CustomBook> neededBooks = new ArrayList<>();
        if (validator.isCorrectPagesCount(pagesCount)) {
            neededBooks = bookListDAO.findByPagesCount(pagesCount);
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPublishingYear(int publishingYear) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();

        List<CustomBook> neededBooks = new ArrayList<>();
        if (validator.isCorrectPublishingYear(publishingYear)) {
            neededBooks = bookListDAO.findByPublishingYear(publishingYear);
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> sortById() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.sortById();
    }

    @Override
    public List<CustomBook> sortBooksByName() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.sortBooksByName();
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.sortBooksByAuthor();
    }

    @Override
    public List<CustomBook> sortBooksByPagesCount() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.sortBooksByPagesCount();
    }

    @Override
    public List<CustomBook> sortBooksByPublishingYear() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.sortBooksByPublishingYear();
    }

    @Override
    public List<CustomBook> findAll() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        return bookListDAO.findAll();
    }

    private List<String> getAuthors(String authorsStringFormat) {
        String[] authors = authorsStringFormat.split(",");
        return new ArrayList<>(Arrays.asList(authors));
    }
}
