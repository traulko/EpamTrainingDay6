package com.traulko.task6.controller.command;

import java.util.Map;

public interface Command {
    Map<String, Object> execute(Map<String, Object> parameters);
}
