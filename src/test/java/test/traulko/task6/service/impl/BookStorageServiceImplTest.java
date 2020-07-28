package test.traulko.task6.service.impl;

import com.traulko.task6.exception.BookStorageServiceException;
import com.traulko.task6.model.entity.BookStorage;
import com.traulko.task6.model.entity.CustomBook;
import com.traulko.task6.service.BookStorageService;
import com.traulko.task6.service.impl.BookStorageServiceImpl;
import com.traulko.task6.util.IdGenerator;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BookStorageServiceImplTest {
    BookStorageService bookStorageService;

    @BeforeMethod
    public void setUp() {
        bookStorageService = new BookStorageServiceImpl();
    }

    @AfterMethod
    public void tearDown() {
        BookStorage.getInstance().removeAll();
        bookStorageService = null;
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void addExceptionTest() throws BookStorageServiceException {
        bookStorageService.add(null, null,0, 0);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void removeExceptionTest() throws BookStorageServiceException {
        bookStorageService.remove(null, null, 0, 0);
    }

    @Test
    public void findByIdPositiveTest() {
        CustomBook actual = bookStorageService.findById(IdGenerator.generateId());
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook expected = new CustomBook("First book", book1Authors, 256, 1998);
        CustomBook actual = bookStorageService.findById(IdGenerator.generateId());
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByNamePositiveTest() throws BookStorageServiceException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookStorageService.findByName("First book");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws BookStorageServiceException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Valentin Solovev");
        book1Authors.add("Stepan Ryazanin");
        CustomBook book1 = new CustomBook("First book", book1Authors, 256, 1998);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Vasil Bikay");
        CustomBook book2 = new CustomBook("Second book", book2Authors, 596, 1967);
        BookStorage.getInstance().add(book1);
        BookStorage.getInstance().add(book2);
        List<CustomBook> actual = bookStorageService.findByName("First book");
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
        List<CustomBook> actual = bookStorageService.findByAuthor("Vasil Bikay");
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
        List<CustomBook> actual = bookStorageService.findByAuthor("Vasil Bikay");
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
        List<CustomBook> actual = bookStorageService.findByPagesCount(596);
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
        List<CustomBook> actual = bookStorageService.findByPagesCount(596);
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
        List<CustomBook> actual = bookStorageService.findByPublishingYear(1967);
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
        List<CustomBook> actual = bookStorageService.findByPublishingYear(1967);
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
        List<CustomBook> actual = bookStorageService.sortBooksByName();
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
        List<CustomBook> actual = bookStorageService.sortBooksByName();
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
        List<CustomBook> actual = bookStorageService.sortBooksByAuthor();
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
        List<CustomBook> actual = bookStorageService.sortBooksByAuthor();
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
        List<CustomBook> actual = bookStorageService.sortBooksByPagesCount();
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
        List<CustomBook> actual = bookStorageService.sortBooksByPagesCount();
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
        List<CustomBook> actual = bookStorageService.sortBooksByPublishingYear();
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
        List<CustomBook> actual = bookStorageService.sortBooksByPublishingYear();
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }
}