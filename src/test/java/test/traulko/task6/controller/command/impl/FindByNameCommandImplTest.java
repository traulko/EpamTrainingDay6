package test.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.FindByNameCommandImpl;
import com.traulko.task6.controller.command.type.ParameterType;
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

import static org.testng.Assert.assertEquals;

public class FindByNameCommandImplTest {
    Command findByNameCommand;

    @BeforeClass
    public void setUp() {
        findByNameCommand = new FindByNameCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        findByNameCommand = null;
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
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.NAME, "First book");
        Map<String, Object> actual = findByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}