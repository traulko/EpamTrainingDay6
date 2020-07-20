package com.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.model.entity.CustomBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmptyCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, String> parameters) {
        Map<String, List<CustomBook>> response = new HashMap<>();
        response.put("Empty command", new ArrayList<>());
        return response;
    }
}
