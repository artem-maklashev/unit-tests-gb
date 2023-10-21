package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookService bookService;
    BookRepository bookRepository;
    Book book1, book2;


    @BeforeEach
    void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);
        book1 = new Book("1", "Book 1", "author1");
        book2 = new Book("2", "Book 2", "author2");
    }

    @Test
    void testFindBookByID() {
        when(bookRepository.findById(anyString())).thenReturn(book1);
        Book book = bookService.findBookById("5");

        verify(bookRepository, times(1)).findById("5");
        assertThat(book).isEqualTo(book1);
    }

    @Test
    void testFindAllBooks() {

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookRepository.findAll();

        verify(bookRepository, times(1)).findAll();
        assertThat(result).isEqualTo(books);
    }

    @Test
    void testBookGetId(){
        assertThat(book1.getId()).isNotNull().isEqualTo("1");
    }
    @Test
    void testBookGetTitle(){
        assertThat(book1.getTitle()).isNotNull().asString().isEqualTo("Book 1");
    }
    @Test
    void testBookGetAuthor() {
        assertThat(book1.getAuthor()).isNotNull().isEqualTo("author1");
    }
    @Test
    void testBookSetId() {
        book1.setId("8");
        String result = book1.getId();
        assertThat(result).isEqualTo("8");
    }
    @Test
    void testBookSetTitle() {
        book1.setTitle("New Title");
        String result = book1.getTitle();
        assertThat(result).isEqualTo("New Title");
    }
    @Test
    void testBookSetAuthor() {
        book1.setAuthor("afftor");
        String result = book1.getAuthor();
        assertThat(result).isEqualTo("afftor");
    }
}