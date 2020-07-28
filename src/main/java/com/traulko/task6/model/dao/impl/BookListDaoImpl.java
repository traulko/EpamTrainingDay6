package com.traulko.task6.model.dao.impl;

import com.traulko.task6.exception.DaoException;
import com.traulko.task6.model.comparator.*;
import com.traulko.task6.model.dao.BookListDao;
import com.traulko.task6.model.entity.BookStorage;
import com.traulko.task6.model.entity.CustomBook;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookListDaoImpl implements BookListDao {
    @Override
    public void add(CustomBook book) throws DaoException {
        if (book == null) {
            throw new DaoException("Book is null");
        }
        if (!BookStorage.getInstance().add(book)) {
            throw new DaoException("Error while adding");
        }
    }

    @Override
    public void remove(CustomBook book) throws DaoException {
        if (book == null) {
            throw new DaoException("Book is null");
        }
        if (!BookStorage.getInstance().remove(book)) {
            throw new DaoException("Error while removing");
        }
    }

    @Override
    public CustomBook findById(UUID id) {
        List<CustomBook> storage = BookStorage.getInstance().getBooks();
        CustomBook neededBook = new CustomBook();
        for (CustomBook book : storage) {
            if (book.getId().equals(id)) {
                neededBook = book;
                break;
            }
        }
        return neededBook;
    }

    @Override
    public List<CustomBook> findByName(String name) {
        List<CustomBook> storage = BookStorage.getInstance().getBooks();
        List<CustomBook> neededBooks = new ArrayList<>();
        for (CustomBook book : storage) {
            if (book.getName().equalsIgnoreCase(name)) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        List<CustomBook> storage = BookStorage.getInstance().getBooks();
        List<CustomBook> neededBooks = new ArrayList<>();
        for (CustomBook book : storage) {
            if (book.getAuthors().contains(author)) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPagesCount(int pagesCount) {
        List<CustomBook> storage = BookStorage.getInstance().getBooks();
        List<CustomBook> neededBooks = new ArrayList<>();
        for (CustomBook book : storage) {
            if (book.getPagesCount() == pagesCount) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPublishingYear(int publishingYear) {
        List<CustomBook> storage = BookStorage.getInstance().getBooks();
        List<CustomBook> neededBooks = new ArrayList<>();
        for (CustomBook book : storage) {
            if (book.getPublishingYear() == publishingYear) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> sortById() {
        List<CustomBook> books = BookStorage.getInstance().getBooks();
        List<CustomBook> sortedBooks = new ArrayList<>(books);
        IdComparator idComparator = new IdComparator();
        sortedBooks.sort(idComparator);
        return sortedBooks;
    }

    @Override
    public List<CustomBook> sortBooksByName() {
        List<CustomBook> books = BookStorage.getInstance().getBooks();
        List<CustomBook> sortedBooks = new ArrayList<>(books);
        NameComparator nameComparator = new NameComparator();
        sortedBooks.sort(nameComparator);
        return sortedBooks;
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() {
        List<CustomBook> books = BookStorage.getInstance().getBooks();
        List<CustomBook> sortedBooks = new ArrayList<>(books);
        AuthorComparator authorComparator = new AuthorComparator();
        sortedBooks.sort(authorComparator);
        return sortedBooks;
    }

    @Override
    public List<CustomBook> sortBooksByPagesCount() {
        List<CustomBook> books = BookStorage.getInstance().getBooks();
        List<CustomBook> sortedBooks = new ArrayList<>(books);
        PagesCountComparator pagesCountComparator = new PagesCountComparator();
        sortedBooks.sort(pagesCountComparator);
        return sortedBooks;
    }

    @Override
    public List<CustomBook> sortBooksByPublishingYear() {
        List<CustomBook> books = BookStorage.getInstance().getBooks();
        List<CustomBook> sortedBooks = new ArrayList<>(books);
        PublishingYearComparator publishingYearComparator = new PublishingYearComparator();
        sortedBooks.sort(publishingYearComparator);
        return sortedBooks;
    }

    @Override
    public List<CustomBook> findAll() {
        return BookStorage.getInstance().getBooks();
    }
}
