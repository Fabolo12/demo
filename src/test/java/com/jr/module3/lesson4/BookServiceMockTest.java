package com.jr.module3.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
public class BookServiceMockTest {

    @InjectMocks
    private BookService target;

    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Integer> integerArgumentCaptor;

    /*@BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        target = new BookService(bookRepository);
    }*/

    @Test
    void getAllBooksZero() {
        final int expected = 0;
        final int actual = target.getAllBooksRep();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllBooksNotZero1() {
        final int expected = 5;
        target.createBooks(expected);

        Mockito.when(bookRepository.getAllBooks()).thenReturn(5);

        final int actual = target.getAllBooksRep();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllBooksNotZero2() {
        final int expected = 5;
        target.createBooks(expected);

        Mockito.doReturn(5).when(bookRepository).getAllBooks();

        final int actual = target.getAllBooksRep();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void voidMethod() {
        Mockito.doThrow(IllegalStateException.class).when(bookRepository).save();
        target.createBooks(true);
    }

    @Test
    void methodWithParams() {
        Mockito.when(bookRepository.save(0)).thenReturn("");
        target.createBooks(false);
        Mockito.verify(bookRepository).save(0);
    }

    @Test
    void methodWithUnknownParams() {
        target.createRandomBooks2();
        Mockito.verify(bookRepository).save(Mockito.anyInt(), Mockito.eq(2));
    }

    @Test
    void answer() {
        Mockito.when(bookRepository.save(0)).thenAnswer(new Answer<String>() {
            @Override
            public String answer(final InvocationOnMock invocationOnMock) throws Throwable {
                return "";
            }
        });
        Mockito.when(bookRepository.save(0)).thenAnswer((Answer<String>) invocationOnMock -> "");

        target.createBooks(false);

        Mockito.verify(bookRepository).save(0);
    }

    @Test
    void verifyTimes() {
        target.createBooks2(5);

        Mockito.verify(bookRepository, Mockito.times(5)).save(0);
    }


    @Test
    void matcher() {
        target.createBooks2(1);

        Mockito.verify(bookRepository).save(Mockito.argThat(new IntegerMatcher()));
        Mockito.verify(bookRepository).save(Mockito.argThat(integer -> integer == 0));
    }

    @Test
    void captor() {
        target.createBooks2(1);

        final ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(bookRepository).save(captor.capture());
        final Integer value = captor.getValue();
        Assertions.assertEquals(0, value);
    }
}

class IntegerMatcher implements ArgumentMatcher<Integer> {
    @Override
    public boolean matches(final Integer s) {
        return s == 0;
    }
}