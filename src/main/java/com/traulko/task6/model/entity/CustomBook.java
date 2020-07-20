package com.traulko.task6.model.entity;

import com.traulko.task6.util.IdGenerator;

import java.util.*;

public class CustomBook {
    private String id;
    private String name;
    private List<String> authors;
    private int pagesCount;
    private int publishingYear;

    public CustomBook(String name, List<String> authors,
                      int pagesCount, int publishingYear) {
        IdGenerator idGenerator = new IdGenerator();
        this.id = idGenerator.generateId();
        this.name = name;
        this.authors = authors;
        this.pagesCount = pagesCount;
        this.publishingYear = publishingYear;
    }

    public CustomBook() {
        IdGenerator idGenerator = new IdGenerator();
        this.id = idGenerator.generateId();
        this.name = "";
        this.authors = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    // TODO: 19.07.2020
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomBook that = (CustomBook) o;
        return id == that.id &&
                pagesCount == that.pagesCount &&
                publishingYear == that.publishingYear &&
                Objects.equals(name, that.name) &&
                Objects.equals(authors, that.authors);
    }

    // TODO: 19.07.2020
    @Override
    public int hashCode() {
        return Objects.hash(id, name, authors, pagesCount, publishingYear);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomBook.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("authors=" + authors)
                .add("pagesCount=" + pagesCount)
                .add("publishingYear=" + publishingYear)
                .toString();
    }
}
