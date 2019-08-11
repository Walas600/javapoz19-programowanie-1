package pl.sdacademy.javapoz19programowanie1.books;

import java.util.ArrayList;
import java.util.List;

public class BooksService {
    private BooksRepositiory booksRepositiory;

    public BooksService(BooksRepositiory booksRepositiory) {
        this.booksRepositiory = booksRepositiory;
    }

    public List<Book> findAll() {
        return booksRepositiory.findAll();
    }

    public List<Book> findBYAfterReleaseYear(int releaseYear) {
        return booksRepositiory.findAfterReleaseYear(releaseYear);
    }

    public List<Book> searchByPhrase(String phrase){
        return booksRepositiory.searchByPhrase(phrase);
    }

    public List<Book> searchByAuthor (String authorPhrase){
        return booksRepositiory.searchByAuthor(authorPhrase);
    }
}
