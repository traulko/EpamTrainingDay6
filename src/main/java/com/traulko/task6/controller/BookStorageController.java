package com.traulko.task6.controller;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.provider.CustomProvider;
import com.traulko.task6.model.entity.CustomBook;

import java.util.Map;
import java.util.List;

public class BookStorageController {
    private static BookStorageController instance;

    public static BookStorageController getInstance() {
        if (instance == null) {
            instance = new BookStorageController();
        }
        return instance;
    }

    public Map<String, List<CustomBook>> processRequest(String cmd, Map<String, String> parameters) {
        Map<String, List<CustomBook>> response;
        Command command = CustomProvider.defineCommand(cmd);
        response = command.execute(parameters);
        return response;
    }
}
