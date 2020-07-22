package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class FindByIdCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        Map<String, Object> response = new HashMap<>();
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        CustomBook book = bookStorageService.findById((String) parameters.get(ParameterType.ID));
        response.put(ResponseType.RESULT, book);
        return response;
    }
}
