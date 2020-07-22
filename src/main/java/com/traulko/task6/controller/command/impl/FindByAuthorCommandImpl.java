package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByAuthorCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        Map<String, Object> response = new HashMap<>();
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        List<CustomBook> neededBooks = bookStorageService.findByAuthor((String) parameters.get(ParameterType.AUTHOR));
        response.put(ResponseType.RESULT, neededBooks);
        return response;
    }
}
