package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookService bookService;
    BookRepository bookRepository;
    @BeforeEach
    void setUp() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookByID(){
        when(bookRepository.findById(anyString())).thenReturn(new Book("1","Book new", "affftor"));
        Book book = bookService.findBookById("5");

        verify(bookRepository, times(1)).findById("5");
        assertThat(bookRepository.findById("5")).isEqualTo(book);


    }
}