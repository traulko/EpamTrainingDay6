package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FindByNameCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        Map<String, Object> response = new HashMap<>();
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        List<CustomBook> neededBooks = bookStorageService.findByName((String) parameters.get(ParameterType.NAME));
        response.put(ResponseType.RESULT, neededBooks);
        return response;
    }
}
