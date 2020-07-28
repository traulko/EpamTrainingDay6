package test.traulko.task6.controller.command.impl;

import com.traulko.task6.controller.command.Command;
import com.traulko.task6.controller.command.impl.EmptyCommandImpl;
import com.traulko.task6.controller.command.type.ResponseType;
import com.traulko.task6.model.entity.BookStorage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class EmptyCommandImplTest {
    Command emptyCommand;

    @BeforeClass
    public void setUp() {
        emptyCommand = new EmptyCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        emptyCommand = null;
        BookStorage.getInstance().removeAll();
    }

    @Test
    public void executeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, "EMPTY COMMAND");
        Map<String, Object> actual = emptyCommand.execute(new HashMap<>());
        assertEquals(actual, expected);
    }
}