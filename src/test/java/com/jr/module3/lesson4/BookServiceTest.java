package com.jr.module3.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

class BookServiceTest {
    private BookService target;

    private static Stream<Integer> createRandomCount() {
        return Stream.of(new Random().nextInt(100));
    }

    @BeforeEach
    void setUp() {
        final BookRepository bookRepository = new BookRepository();
        target = new BookService(bookRepository);
    }

    @Test
    void getAllBooksZero() { // TDD | BDD
        final int expected = 0;
        final int actual = target.getAllBooks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllBooksHasCreatedBooks() {
        final int bookCount = 5;
        final int expected = bookCount;
        target.createBooks(bookCount);

        final int actual = target.getAllBooks();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 10})
    void createBooks(final int count) {
        target.createBooks(count);

        final int actual = target.getAllBooks();
        if (count <= 0) {
            Assertions.assertEquals(0, actual);
        } else {
            Assertions.assertEquals(count, actual);
        }
    }

    @ParameterizedTest
    @EnumSource(value = BookCount.class, mode = EnumSource.Mode.EXCLUDE, names = {"ZERO"})
    void createBooks1(final BookCount bookCount) {
        final int count = bookCount.getCount();
        target.createBooks(bookCount);

        final int actual = target.getAllBooks();
        Assertions.assertEquals(count, actual);
    }

    @ParameterizedTest
    @EnumSource(value = BookCount.class, mode = EnumSource.Mode.INCLUDE, names = {"ZERO"})
    void createBooks2(final BookCount bookCount) {
        target.createBooks(bookCount);

        final int actual = target.getAllBooks();
        Assertions.assertEquals(0, actual);
    }

    @ParameterizedTest
    @NullSource
//    @EmptySource
    void createBooks3(final BookCount bookCount) {
        target.createBooks(bookCount);

        final int actual = target.getAllBooks();
        Assertions.assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "createRandomCount")
    void createBooks4(final int count) {
        target.createBooks(count);

        final int actual = target.getAllBooks();
        Assertions.assertEquals(count, actual);
    }

    @Test
    @Disabled
    void getBookCount() {
        final int expected = 0;
        final int actual = target.getAllBooksRep();
        Assertions.assertEquals(expected, actual);
    }
}