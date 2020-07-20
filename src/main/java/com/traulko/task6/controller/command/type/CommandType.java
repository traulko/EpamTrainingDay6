package com.traulko.task6.controller.command.type;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK("Add book", new AddBookCommandImpl()),
    REMOVE_BOOK("Remove book", new RemoveBookCommandImpl()),
    FIND_BY_ID("Find by id", new FindByIdCommand()),
    FIND_BY_NAME("Find by name", new FindByNameCommand()),
    FIND_BY_AUTHOR("Find by author", new FindByAuthorCommand()),
    FIND_BY_PAGES_COUNT("Find by pages count", new FindByPagesCommand()),
    FIND_BY_PUBLISHING_HOUSE("Find by publishing year", new FindByPublishingHouseCommand()),
    SORT_BY_ID("Sort by id", new SortByIdCommandImpl()),
    SORT_BY_NAME("Sort by name", new SortByNameCommandImpl()),
    SORT_BY_AUTHOR("Sort by author", new SortByAuthorCommandImpl()),
    SORT_BY_PAGES_COUNT("Sort by pages count", new SortByPagesCountCommandImpl()),
    SORT_BY_PUBLISHING_YEAR("Sort by publishing year", new SortByPublishingYearCommandImpl()),
    FIND_ALL("Find all", new FindAllCommandImpl()),
    EMPTY_COMMAND("Empty command", new EmptyCommandImpl());

    String name;
    Command command;
    CommandType(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
