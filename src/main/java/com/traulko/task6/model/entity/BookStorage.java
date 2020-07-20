package com.traulko.task6.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class BookStorage {
    private static final int CAPACITY = 2500;
    private static BookStorage instance;
    private List<CustomBook> books;

    private BookStorage() {
        this.books = new ArrayList<>();
    }

    public static BookStorage getInstance() {
        if (getInstance() == null) {
            instance = new BookStorage();
        }
        return instance;
    }

    public List<CustomBook> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public boolean add(CustomBook book) {
        boolean result = true;
        if (books.contains(book)) {
            result = false;
        } else {
            books.add(book);
        }
        return result;
    }

    public boolean remove(CustomBook book) {
        boolean result = true;
        if (!books.contains(book)) {
            result = false;
        } else {
            books.remove(book);
        }
        return result;
    }

    public int size() {
        return books.size();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookStorage.class.getSimpleName() + "[", "]")
                .add("books=" + books)
                .toString();
    }
}
