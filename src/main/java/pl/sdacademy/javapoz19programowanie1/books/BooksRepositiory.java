package pl.sdacademy.javapoz19programowanie1.books;

import java.util.List;

public interface BooksRepositiory {
    List<Book> findAll();

    List<Book> findAfterReleaseYear(int releaseYear);

    List<Book> searchByPhrase(String phrase);

    List<Book> searchByAuthor (String authorPhrase);
}
