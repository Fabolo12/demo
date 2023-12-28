package com.jr.module3.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class BookService {
    private final List<Integer> books = new ArrayList<>();
    private final BookRepository bookRepository;

    BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getAllBooks() {
        return books.size();
    }

    void createBooks(final BookCount bookCount) {
        final int count = bookCount == null ? 0 : bookCount.getCount();

        final Integer count1 = Optional.ofNullable(bookCount)
                .map(BookCount::getCount)
                .orElse(0);

        final int count2 = Objects.requireNonNullElse(bookCount, BookCount.ZERO).getCount();

        createBooks(count);
    }

    void createBooks(final int bookCount) {
        for (int i = 0; i < bookCount; i++) {
            books.add(i);
        }
    }

    public int getAllBooksRep() {
        return bookRepository.getAllBooks();
    }

    void createBooks(final boolean useRep) {
        if (useRep) {
            bookRepository.save();
        } else {
            bookRepository.save(0);
        }
    }

    void createRandomBooks() {
        bookRepository.save(new Random().nextInt());
    }

    void createRandomBooks2() {
        bookRepository.save(new Random().nextInt(), 2);
    }

    void createBooks2(final int bookCount) {
        for (int i = 0; i < bookCount; i++) {
            bookRepository.save(0);
        }
    }

    void createBooks3(final int i) {
        bookRepository.throwException();
    }
}
