package test.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.AddBookCommandImpl;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.BookStorage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class AddBookCommandImplTest {
    Command addBookCommand;

    @BeforeClass
    public void setUp() {
        addBookCommand = new AddBookCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        addBookCommand = null;
        BookStorage.getInstance().removeAll();
    }

    @Test
    public void executePositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.NAME,"Book_name");
        parameters.put(ParameterType.AUTHOR, "Valentin Solovev, Stepan Ryazin");
        parameters.put(ParameterType.PAGES_COUNT, 156);
        parameters.put(ParameterType.PUBLISHING_YEAR, 2019);
        Map<String, Object> actual = addBookCommand.execute(parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_FAIL);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.NAME,"Book_name");
        parameters.put(ParameterType.AUTHOR, "Valentin Solovev, Stepan Ryazin");
        parameters.put(ParameterType.PAGES_COUNT, 156);
        parameters.put(ParameterType.PUBLISHING_YEAR, 2019);
        Map<String, Object> actual = addBookCommand.execute(parameters);
        assertNotEquals(actual, expected);
    }
}