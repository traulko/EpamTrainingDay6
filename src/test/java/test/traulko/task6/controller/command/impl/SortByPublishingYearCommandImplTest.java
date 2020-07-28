package test.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.SortByPagesCountCommandImpl;
import com.traulko.task6.controller.command.impl.SortByPublishingYearCommandImpl;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.BookStorage;
import com.traulko.task6.model.entity.CustomBook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SortByPublishingYearCommandImplTest {
    Command sortByPublishingYearCommand;

    @BeforeClass
    public void setUp() {
        sortByPublishingYearCommand = new SortByPublishingYearCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        sortByPublishingYearCommand = null;
        BookStorage.getInstance().removeAll();
    }

    @Test
    public void executeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> books = new ArrayList<>();
        books.add(book2);
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> actual = sortByPublishingYearCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}