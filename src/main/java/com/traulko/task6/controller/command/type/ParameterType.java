package com.traulko.task6.controller.command.type;

public enum ParameterType {
    ID("id"),
    NAME("name"),
    AUTHOR("author"),
    PAGES_COUNT("pagesCount"),
    PUBLISHING_YEAR("publishingYear");

    String name;
    ParameterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
