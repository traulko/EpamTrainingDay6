package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.exception.BookStorageServiceException;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveBookCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, String> parameters) {
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        Map<String, List<CustomBook>> response = new HashMap<>();
        if (parameters.containsKey(ParameterType.ID.getName())
                && parameters.containsKey(ParameterType.NAME.getName())
                && parameters.containsKey(ParameterType.AUTHOR.getName())
                && parameters.containsKey(ParameterType.PAGES_COUNT.getName())
                && parameters.containsKey(ParameterType.PUBLISHING_YEAR.getName())) {
            String name = parameters.get("name");
            String authors = parameters.get("author");
            int pagesCount = Integer.parseInt(parameters.get("pagesCount"));
            int publishingYear = Integer.parseInt(parameters.get("publishingYear"));
            try {
                bookStorageService.remove(name, authors, pagesCount, publishingYear);
                response.put("Book removed", bookStorageService.findAll());
            } catch (BookStorageServiceException e) {
                response.put("Book is not exists", new ArrayList<>());
            }
        }
        return response;
    }
}
