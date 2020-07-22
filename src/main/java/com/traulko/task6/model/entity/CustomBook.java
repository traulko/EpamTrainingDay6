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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomBook other = (CustomBook) obj;
        if (name != null ? !name.equals(other.name) : other.name != null) {
            return false;
        }
        if (authors != null ? !authors.equals(other.authors) : other.authors != null) {
            return false;
        }
        if (pagesCount != other.pagesCount) {
            return false;
        }
        if (publishingYear != other.publishingYear) {
            return false;
        }
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = prime + (id != null ? id.hashCode() : 0);
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (authors != null ? authors.hashCode() : 0);
        result = prime * result + pagesCount;
        result = prime * result + publishingYear;
        return result;
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
