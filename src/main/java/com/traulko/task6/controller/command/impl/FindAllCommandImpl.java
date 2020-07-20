package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, String> parameters) {
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        Map<String, List<CustomBook>> response = new HashMap<>();
        List<CustomBook> neededBooks = bookStorageService.findAll();
        response.put("Find all", neededBooks);
        return response;
    }
}
