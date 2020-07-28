package test.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.FindByIdCommandImpl;
import com.traulko.task6.controller.command.type.ParameterType;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.BookStorage;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.util.IdGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class FindByIdCommandImplTest {
    Command findByIdCommand;

    @BeforeClass
    public void setUp() {
        findByIdCommand = new FindByIdCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        findByIdCommand = null;
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
        CustomBook book = new CustomBook();
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, book);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.ID, IdGenerator.generateId());
        Map<String, Object> actual = findByIdCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}