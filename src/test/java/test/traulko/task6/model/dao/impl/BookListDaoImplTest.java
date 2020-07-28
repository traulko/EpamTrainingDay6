package test.traulko.task6.model.dao.impl;

import com.traulko.task6.exception.DaoException;
import com.traulko.task6.model.dao.BookListDao;
import com.traulko.task6.model.dao.impl.BookListDaoImpl;
import com.traulko.task6.model.entity.BookStorage;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.util.IdGenerator;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BookListDaoImplTest {
    BookListDao bookListDao;

    @BeforeMethod
    public void setUp() {
        bookListDao = new BookListDaoImpl();
    }

    @AfterMethod
    public void tearDown() {
        bookListDao = null;
        BookStorage.getInstance().removeAll();
    }

    @Test(expectedExceptions = DaoException.class)
    public void addExceptionTest() throws DaoException {
        bookListDao.add(null);
    }

    @Test(expectedExceptions = DaoException.class)
    public void removeExceptionTest() throws DaoException {
        bookListDao.remove(null);
    }

    @Test
    public void findByIdPositiveTest() {
        CustomBook actual = bookListDao.findById(IdGenerator.generateId());
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        CustomBook actual = bookListDao.findById(IdGenerator.generateId());
        CustomBook expected = book1;
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByNamePositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByName("First book");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByName("First book");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByAuthorPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByAuthor("Vasil Bikay");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByAuthor("Vasil Bikay");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByPagesCountPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByPagesCount(596);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPagesCountNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByPagesCount(596);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByPublishingYearPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByPublishingYear(1967);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPublishingYearNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findByPublishingYear(1967);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findAllPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findAll();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void findAllNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.findAll();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByNamePositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByNameNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByPagesCountPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByPagesCount();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPagesCountNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByPagesCount();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortBooksByPublishingYearPositiveTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByPublishingYear();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPublishingYearNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByPublishingYear();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }
}